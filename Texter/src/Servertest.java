import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Servertest {
	
		private User user;
		private View view;
		
		public Servertest(String n,boolean a)
		{
			if(a)user = new Server(n);
			else user = new Client(n);
			view = new View();
			
		}
		
		public void run(){	
			
			view.getButton().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(user.getLastT()==1)user.write(view.getMessage("  "));
					else 
						{
							user.write(view.getMessage("a: "));
							user.setLastT(1); 
						}
				}
			});
			
			String msg="";
			while(true)
			{
				msg=user.read();
				if(user.getLastT()==2)view.setPane(msg,"  ");
				else 
					{
						view.setPane(msg,"b: ");
						user.setLastT(2); 
					}
			}
		};

}