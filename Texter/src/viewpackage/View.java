package viewpackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
/**
 * Klasa do generowania i odswierzania widoku 
 * podczas konwersacji
 */
public class View {
	
	private JScrollPane scrollPane;
	private JFrame frame;
	private AutoreplaceSmiles textPane_1;
	private JButton button;
	private AutoreplaceSmiles textPane;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
		initListener();
		frame.setVisible(true);
	}

	/**
	 * Inicjalizacja konponentow
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		button = new JButton("Wyslij");
		button.setBounds(355, 264, 89, 23);
		frame.getContentPane().add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 451, 175);
		frame.getContentPane().add(scrollPane);
		
		textPane= new AutoreplaceSmiles();
		textPane.setBounds(0, 0, 451, 175);
		textPane.setEditable(false);
		textPane.setVerifyInputWhenFocusTarget(true);
		scrollPane.setViewportView(textPane);
		
		textPane_1= new AutoreplaceSmiles();
		textPane_1.setBounds(2, 184, 352, 108);
		frame.getContentPane().add(textPane_1);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(354, 184, 94, 108);
		frame.getContentPane().add(panel);
	}
	/**
	 * Zwraca przycisk wyslij
	 */
	public JButton getButton()
	{
		return button;
	}
	
	public void initListener() 
	{
		textPane.initListener();
		textPane_1.initListener();
	}
		
	/**
	 * Pobranie wiadomosci z pola do wysylania
	 * i wpisanie do odczytywania
	 */
	public String getMessage(String name)
	{
		String a = textPane_1.getText();
		textPane_1.setText(""); 
		setPane(a,name);
		return a;
	}
	
	/**
	 * Ustawaianie pola do odczytywania
	 */
	public void setPane(String msg,String name)
	{
		 Document doc = textPane.getDocument();
	      try {
			doc.insertString(doc.getLength(), name + msg + "\n", null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
