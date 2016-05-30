package viewpackage;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/**
 * Klasa do generowania i odswierzania widoku  podczas konwersacji
 * Ma za zadanie odbieranie od uzytkownika wiadomosci, aktualizowanie
 * okna wiadomosci wysylanych i pobranych. Rownierz dzieki klasie AutoreplaceSmiles
 * przekształca tekst na emotikony
 * 
 * @see AutoreplaceSmiles
 * 
 * @author Szymon
 */
public class View {
	
	private JScrollPane scrollPane;
	private JFrame frame;
	private AutoreplaceSmiles textPane_1;
	private JButton button;
	private AutoreplaceSmiles textPane;
	private JPanel panel;

	/**
	 * Konstruktor
	 */
	public View() 
	{
		initialize();
		initListener();
		frame.setVisible(true);
	}

	/**
	 * Inicjalizacja konponentow i wyswietlanie ich na ekranie
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	/**
	 * inicjalizacjia sluchaczy
	 */
	public void initListener() 
	{
		textPane.initListener();
		textPane_1.initListener();
	}
		
	/**
	 * Pobranie wiadomosci z pola do wysylania
	 * i wpisanie do odczytywania
	 * 
	 * @param name    name-nazwa wlasna
	 * 
	 */
	public String getMessage(String name)
	{
		String a = textPane_1.getText();
		textPane_1.setText(""); 
		setPane(a,name,true);
		scrollPane.setViewportView(textPane);
		return a;
	}
	
	/**
	 * Ustawaianie pola do odczytywania wpisanie nowego textu po korekcie
	 * czyli odpowiednim pokolorowaniu i aktualizacji okna z tekstem
	 * 
	 * @param msg  msg - nowa wiadomosc
	 * @param name  name-nazwa uzytkownika
	 * @param ja  ja- zmienna boolean do odpowiedniego kolorowania tekstu
	 */
	public void setPane(String msg,String name,boolean ja)
	{
		 StyledDocument doc = textPane.getStyledDocument();
		 SimpleAttributeSet keyWord = new SimpleAttributeSet();
		 if(ja)
			 {
			 	StyleConstants.setForeground(keyWord, Color.GRAY);
			 }
		 
	      try {
			doc.insertString(doc.getLength(), name + msg + "\n", keyWord);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	     
	}
	
	
	
}
