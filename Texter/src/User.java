import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class User {
	protected PrintWriter out;
	protected  BufferedReader in;
	protected  String name;
    
    public User()
    {
		connect();
		name="noname";
	}
    
    public User(String n)
    {
		connect();
		name=n;
	}
    
    abstract public void connect();
	abstract public void disconnect();
	abstract public Socket getSocket();
	
	public String toString()
	{
		return name;
	}
	
	public void write(String msg) 
	{		
		out.println(msg); 
	}
	
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
