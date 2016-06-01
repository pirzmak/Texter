package viewpackage;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * Menu jest to klasa do wyswiatlania menu głównego programu
 * W tym menu uzytkownik ma mozliwosc wpisania swojego nicku a nastepnie adresu ip z ktorym chce sie polaczyc
 * Przycisk start rozpoczyna konwersacje
 * 
 * @author Szymon 
 */

public class Menu {
	
	private JFrame frame;
	private JTextField textFieldNick;
	private JTextField textField_1;
	private JLabel lblNick;
	private JLabel lblIp;
	private JRadioButton rdbtnHost;
	private	JRadioButton rdbtnGuest;
	private ButtonGroup group;
	private JButton btnStart;
	
	/**
	 * Konstruktor
	 */
	public Menu() 
	{
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initializacja komponentow i wyswitlenie ich na ekranie
	 * 
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
						
		textFieldNick = new JTextField();
		textFieldNick.setBounds(116, 30, 86, 20);
		frame.getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 87, 126, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNick = new JLabel("    Nick :");
		lblNick.setBounds(20, 33, 66, 14);
		frame.getContentPane().add(lblNick);
		
		lblIp = new JLabel("       IP :");
		lblIp.setBounds(20, 90, 66, 14);
		frame.getContentPane().add(lblIp);
		
		rdbtnHost = new JRadioButton("Host");
		rdbtnHost.setBounds(20, 133, 109, 23);
		frame.getContentPane().add(rdbtnHost);
		
		rdbtnGuest = new JRadioButton("Guest");
		rdbtnGuest.setBounds(20, 159, 109, 23);
		frame.getContentPane().add(rdbtnGuest);
		
		group = new ButtonGroup();
		group.add(rdbtnHost);
		group.add(rdbtnGuest);
		
		btnStart = new JButton("Start");		
		btnStart.setBounds(76, 189, 89, 23);
		frame.getContentPane().add(btnStart);
		
	}
	
	/**
	 * Pobranie przycisku Start
	 * 
	 * @see JButton
	 */
	public JButton getButton()
	{
		return btnStart;
	}
	
	/**
	 * Sprawdzenie czy zaznaczony Host
	 */
	public boolean getHost()
	{
		return rdbtnHost.isSelected();
	}
	
	/**
	 * Sprawdzenie czy zaznaczony Guest
	 */
	public void iplock()
	{
		textField_1.setEditable(false);
	}
	
	/**
	 * Sprawdzenie czy zaznaczony Guest
	 */
	public JRadioButton getButtonHost()
	{
		return rdbtnHost;
	}
	
	/**
	 * Sprawdzenie czy zaznaczony Guest
	 */
	public boolean getGuest()
	{
		return rdbtnGuest.isSelected();
	}
	
	/**
	 * Pobranie nazwy uzytkownika
	 * 
	 * @see JTextPlace
	 */
	public String getName()
	{
		return textFieldNick.getText();
	}
	/**
	 * Pobranie adresu ip
	 * 
	 * @see JTextPlace
	 */
	public String getIP()
	{
		return textField_1.getText();
	}

}
