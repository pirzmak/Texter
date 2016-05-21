import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class View2 {
	
	
	private JFrame frame;
	private JTextPane textPane_1;
	private JButton button;
	private JTextPane textPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View2 window = new View2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View2() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
		
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(0, 0, 450, 169);
		frame.getContentPane().add(textPane);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(0, 180, 450, 82);
		frame.getContentPane().add(textPane_1);
		
		button = new JButton("Wyslij");
		button.setBounds(345, 270, 89, 23);
		frame.getContentPane().add(button);
	}
	
	public JButton getButton()
	{
		return button;
	}
	
	public String getMessage()
	{
		String a = textPane_1.getText();
		textPane_1.setText(""); 
		Document doc = textPane.getDocument();
	      try {
			if(a.length()!=0)doc.insertString(doc.getLength(), "b: " + a + "\n", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public void setPane(String msg)
	{
		 Document doc = textPane.getDocument();
	      try {
			doc.insertString(doc.getLength(), "a: " + msg + "\n", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
