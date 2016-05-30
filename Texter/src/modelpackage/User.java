package modelpackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Klasa abstrakcyjna zawierajaca
 * glowne funkcje uzytkownika :
 * 
 * Nawiazanie polaczenia
 * Pisanie
 * Czytanie
 * Pobranie komponentow (nazwa, nazwa 2 rozmowcy, socket)
 * 
 * Uzywana przez klasy Server i Client
 * 
 * @see Server
 * @see Client
 * @see #connect(String, int)
 * @see #getName()
 * @see #getNameSecond()
 * @see #setNameSecond(String)
 * 
 * @author Szymon 
 */
public abstract class User {
	
	protected PrintWriter out;
	protected  BufferedReader in;
	protected  String name;
	protected  String nameSecond;
    
	/**
	 * Konstruktor
	 */
    public User()
    {
		connect("localhost",4444);		
		name="noname";
	}
    
    /**
	 * Konstruktor z nazwa
	 * 
	 * @param n      n - nazwa uzytkownika
	 * @param ip     ip - adres drugiego uzytkownika
	 * @param port   port - numer portu aktualizowany automatycznie
	 */
    public User(String n,String ip,int port)
    {
		connect(ip,port);
		name=n;
	}
    
    /**
	 * Nawiazanie polaczenia
	 * 
	 * @param ip     ip - adres drugiego uzytkownika
	 * @param port   port - numer portu aktualizowany automatycznie
	 */
    abstract public void connect(String ip,int port);
    
    
	/**
	 * Pobranie gniazda
	 * 
	 * @return socket
	 */
	abstract public Socket getSocket();
	
	/**
	 * Pobranie nazwy
	 * 
	 * @return nazwa uzytkownika
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Pobranie nazwy rozmowcy
	 * 
	 * @return nazwa 2 rozmowcy
	 */
	public String getNameSecond()
	{
		return nameSecond;
	}
	/**
	 * ustawienie nazwy rozmowcy
	 * 
	 * @param n  n - nazwa 2 uzytkownika
	 */
	public void setNameSecond(String n)
	{
		nameSecond=n;
	}
	
	/**
	 * Pisanie wiadomosci do 2 uzytkownika
	 * 
	 * @param msg  msg-nowa wiadomosc
	 */
	public void write(String msg) 
	{	
		out.println(msg); 
	}
	
	/**
	 * Czytanie wiadomosciod 2 uzytkownika
	 * jezeli brak to rowne ""
	 * 
	 * @return odzczytana wiadomosc
	 */
	public String read()
	{
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
