package controlerpackage;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelpackage.Client;
import modelpackage.Server;
import modelpackage.User;
import viewpackage.Menu;
import viewpackage.View;
/** 
 * Klasa kontrulujaca aplikacje w modelu MVC.
 * Pobiera dane od uzytkownika za pomoca Widoku
 * Aktualizuje model oraz widok
 * 
 * @see packageView
 * @see packageModel
 * 
 * @author Szymon
 * 
 */
public class Controler implements ActionListener {
	
	private Menu menu;
	private View view;
	private User user;
	private int  last;
	private String msg="";
	private int port = 4444;
	boolean chat = false;
	
	/**
	 * Konstruktor
	 */
	public Controler()
	{
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				menu = new Menu();
				initialize();
			}
		});
		
	}
	
	/**
	 * Initializacja komponentow
	 */
	private void initialize()
	{
		last=0;
		menu.getButton().addActionListener(this);
		
	}
	/**
	 * Wlaczenie widoku czatowego
	 * inicjalizacja przyciskow
	 */
	private void chat()
	{
		view = new View();		
		view.initListener();
		user.write(user.getName());
		user.setNameSecond(user.read());
		view.getButton().addActionListener(this);
		port++;
		chat=true;
		new Read().start();
	}
	
	
	/**
	 * Obsługa przyciskow z menu i view
	 * Z menu skojarzenie czy klient lub serwer 
	 * i nawiazanie polaczenia po nacisnieciu START
	 * W view przycisk wyslij ktory wysyla wiadomosc i czysci
	 * pole do pisania wiadomosci
	 * 
	 * @param e  e- przycisk eventu do okreslenia ktory przycisk nacisniety
	 * 
	 * @see ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if(source == menu.getButton())
		{
			if(menu.getHost())
			{
				user = new Server(menu.getName(),menu.getIP(),port);
				chat();
			}
			if(menu.getGuest())
			{
				user = new Client(menu.getName(),menu.getIP(),port);
				chat();
			}
		}
		if(source == view.getButton())
		{
			
			if(last==1)user.write(view.getMessage(""));
			else 
				{
					user.write(view.getMessage(user.getName() + " :\n"));
					last=1; 
				}
		}
		
	}
	/**
	 *  Odbieranie i wyswietlanie wiadomosci 
	 *  Dziala az do skonczenia rozmowy
	 *  Ciaglen asluchuje nowych wiadomosci
	 *  i w przypadku odebrania aktualizuje widoki
	 */
	public class Read extends Thread 
	{
		public Read()
		{			
		}
		@Override
		public void run()
		{
				while(chat)
				{
					msg=user.read();
					if(msg.length()!=0)
					{
						if(last==2)view.setPane(msg,"",false);
						else 
							{
								view.setPane(msg, user.getNameSecond() + " :\n",false);
								last=2;
							}
					}
				}
		}
		
	}
	
	
}
