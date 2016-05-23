import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Klasa abstrakcyjna zawierajaca
 * glowne funkcje uzytkownika
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
		connect();		
		name="noname";
	}
    
    /**
	 * Konstruktor z nazwa
	 */
    public User(String n)
    {
		connect();
		name=n;
	}
    
    /**
	 * Nawiazanie polaczenia
	 */
    abstract public void connect();
    
    /**
	 * Zakaczenie polaczenia
	 */
	abstract public void disconnect();
	
	/**
	 * Pobranie gniazda
	 */
	abstract public Socket getSocket();
	
	/**
	 * Pobranie nazwy
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Pobranie nazwy rozmowcy
	 */
	public String getNameSecond()
	{
		return nameSecond;
	}
	
	public void setNameSecond(String n)
	{
		nameSecond=n;
	}
	
	/**
	 * Pisanie wiadomosci do 2 uzytkownika
	 */
	public void write(String msg) 
	{	
		out.println(msg); 
	}
	
	/**
	 * Czytanie wiadomosciod 2 uzytkownika
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
