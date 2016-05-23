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
	 */
	public Client(String n) 
	{
		super(n);
		
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
	 */
	public void connect() 
	{
		try {
			socket = new Socket("localhost", 4444);
		} catch (UnknownHostException e) {
			System.err.println("Nikogo tu nie ma " + e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Brak polaczenia " + e);
			System.exit(1);
		}
	}
	/**
	 * Zerwanie polaczenia
	 */
	public void disconnect() 
	{
		try {
			socket.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	/**
	 * pobranie socket
	 */
	public Socket getSocket() 
	{
		return socket;
	}	
}
