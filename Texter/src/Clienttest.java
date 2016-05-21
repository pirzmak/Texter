import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Clienttest {

	public static void main(String[] args) {
		final Client client = new Client();
		
		final View2 view = new View2();
		
		
		
		view.getButton().addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					client.write(view.getMessage());
				}
		});
		String msg;
		while(true)
		{
			msg=client.read();
			if(msg.length()!=0)
			{
				view.setPane(msg);
			}
		}
	}

}
