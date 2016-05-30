package modelpackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Klasa User ze strony klienta. Dodany
 * socket i przedefinowane funkcje do 
 * utworzenia polaczenia
 * 
 * @see Server
 * @see User
 * 
 * @author Szymon
 */
public class Client extends User{
	
	private Socket socket;
	
	/**
	 * Konstruktor
	 */
	public Client() 
	{
		super();
		
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Cos sie popsulo na porcie: 4444 ." + e);
			e.printStackTrace();
		}
	}
	
	 /**
		 * Konstruktor z nazwa
		 * 
		 * @param n      n - nazwa uzytkownika
		 * @param ip     ip - adres drugiego uzytkownika
		 * @param port   port - numer portu aktualizowany automatycznie
		 * 
		 */
	public Client(String n,String ip,int port) 
	{
		super(n,ip,port);
		
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Cos sie popsulo na porcie: 4444 ." + e);
			e.printStackTrace();
		}
	}
	
	 /**
		 * Nawiazanie polaczenia
		 * 
		 * @param ip     ip - adres drugiego uzytkownika
		 * @param port   port - numer portu aktualizowany automatycznie
		 * 
		 * @see #User{@link #connect(String, int)}
		 */
	@Override
	public void connect(String ip,int port) 
	{
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			System.err.println("Nikogo tu nie ma " + e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Brak polaczenia " + e);
			System.exit(1);
		}
	}
	
	
	/**
	 * pobranie socket
	 * 
	 * @see #User{@link #connect(String, int)}
	 */
	@Override
	public Socket getSocket() 
	{
		return socket;
	}	
}
