import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class testGUI {

	public JFrame frmTerminal;
	JTextArea textArea;
	int line=1;
	int pos = 0;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testGUI window = new testGUI();
					window.frmTerminal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public testGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		frmTerminal = new JFrame();
		frmTerminal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jdbusby\\Downloads\\icons8-command-line-30.png"));
		frmTerminal.setTitle("Terminal");
		frmTerminal.getContentPane().setBackground(Color.BLACK);
		frmTerminal.getContentPane().setForeground(Color.BLACK);
		frmTerminal.setBounds(100, 100, 450, 300);
		frmTerminal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTerminal.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 434, 261);
		frmTerminal.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					//System.out.println(textArea.getCaretPosition());
					
					//textArea.append(mainClass.cur +">");
					//pos = textArea.getCaretPosition(); 
					System.out.println(textArea.getLineCount());
				}
			}
		});
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_UP) {
					textArea.setEditable(false);
					textArea.setCaretPosition(pos);
					
					//textArea.setEditable(true);
				}
			}
		});
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setCaretColor(Color.white);
		
		
	}
}
