package modelpackage;
import java.net.*;
import java.io.*;
/**
 * Klasa User ze strony servera. Dodany
 * socket i przedefinowane funkcje do 
 * utworzenia polaczenia
 * 
 * @see Client
 * @see User
 * 
 * @author Szymon
 */
public class Server extends User{	
	private Socket clientSocket;
	private ServerSocket serverSocket;
	
	/**
	 * Konstruktor
	 */	
	public Server() 
	{
		super();
		
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
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
	public Server(String n,String ip,int port) 
	{
		super(n,ip,port);
		
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Cos sie popsulo na porcie: 4444 ." + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Stworzenie nowego servra aby klient mogl
	 * nawiazac polaczenie
	 */
	private void createConnection(int port) 
	{
		try {
			serverSocket = new ServerSocket(port);
			
		} catch (IOException e) {
			System.err.println("Cos sie popsulo na porcie: 4444 ." + e);
			System.exit(1);
		}
	}
	
	/**
	 * Nawiazanie polaczenia
	 * 
	 * @param ip     ip - adres drugiego uzytkownika
	 * @param port   port - numer portu aktualizowany automatycznie
	 * 
	 * @see #User#connect(String, int)
	 */
	
	public void connect(String ip,int port)  
	{
		createConnection(port);
		
		try {
			clientSocket = serverSocket.accept();
			
			System.out.println("Polaczenie! " 
					+ "IP: "
					+ clientSocket.getInetAddress()
					+ ", port: "
					+ clientSocket.getPort());

		} catch (IOException e) {
			System.err.println("Cos sie popsulo. Nie bylo mnie slychac" + e);
			System.exit(1);
		}
	}
	
	/**
	 * pobranie socket
	 * 
	 * @see #User{@link #connect(String, int)}
	 */
	@Override 
	public Socket getSocket() {
		return clientSocket;
	}
	
}
