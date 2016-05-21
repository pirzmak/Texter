import java.net.*;
import java.io.*;
 
public class Server {
	
	private Socket clientSocket;
	private ServerSocket serverSocket;
	private PrintWriter out;
	private String m;
	BufferedReader in;
	
	public Server() {
		connect();
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createConnection() {
		try {
			serverSocket = new ServerSocket(4443);
		} catch (IOException e) {
			System.err.println("Cos sie popsulo na porcie: 4444 ." + e);
			System.exit(1);
		}
	}
	
	private void closeConnection() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	
	public void connect() {
		createConnection();
		
		try {
			clientSocket = serverSocket.accept();
			
			System.out.println("Lo kurwa polaczenie! " 
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
	
	
	public String toString() {
		return new String("Server");
	}
	

	public void write(String msg) {
		
		out.println(msg);	               
	       
	}
	
	public String read(){
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
