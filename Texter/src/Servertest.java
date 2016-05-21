import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Servertest {
	
	
	public static void main(String[] args) {
		
		final Server server = new Server();
		final View2 view = new View2();
		
		
		view.getButton().addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					server.write(view.getMessage());
					System.out.println("a");
				}
		});
		String msg="";
		while(true)
		{
			msg=server.read();
			if(msg.length()!=0)
			{
				view.setPane(msg);
			}
		}

	}
}
