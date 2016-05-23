import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Clienttest {
	

	public static void main(String[] args) {
		final Client client = new Client();
		
		final View view = new View();
		
		
		
		view.getButton().addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(client.getLastT()==1)client.write(view.getMessage("  "));
					else 
						{
							client.write(view.getMessage("a: "));
							client.setLastT(1); 
						}
				}
		});
		String msg;
		while(true)
		{
			msg=client.read();
			if(msg.length()!=0)
			{
				if(client.getLastT()==2)view.setPane(msg,"  ");
				else 
					{
						view.setPane(msg,"b: ");
						client.setLastT(2); 
					}
			}
		}
	}

}
