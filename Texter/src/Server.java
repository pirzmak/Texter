import java.net.*;
import java.io.*;
 
public class Server extends User{	
	private Socket clientSocket;
	private ServerSocket serverSocket;
	
	
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
	
	public Server(String n) 
	{
		super(n);
		
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Cos sie popsulo na porcie: 4444 ." + e);
			e.printStackTrace();
		}
	}
	
	private void createConnection() 
	{
		try {
			serverSocket = new ServerSocket(4444);
			
		} catch (IOException e) {
			System.err.println("Cos sie popsulo na porcie: 4444 ." + e);
			System.exit(1);
		}
	}
	
	private void closeConnection() 
	{
		try {
			serverSocket.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	
	public void connect() 
	{
		createConnection();
		
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
	
	public void disconnect() {
		try {
			clientSocket.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		
		closeConnection();
	}
	
	public Socket getSocket() {
		return clientSocket;
	}
	
}
