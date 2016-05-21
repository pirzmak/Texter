import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket;
	private PrintWriter out;
    private BufferedReader in;


	public Client() {
		connect();
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = new BufferedReader(
			        new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public Socket getSocket() {
		return socket;
	}
	

	public void connect() {
		try {
			socket = new Socket("localhost", 4443);


		} catch (UnknownHostException e) {
			System.err.println("Nikogo tu nie ma " + e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Brak polaczenia " + e);
			System.exit(1);
		}
	}
	
	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public String toString() {
		return new String("Client");
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
