import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class temp {

	private JFrame frame;
	private JTextArea textArea;
	static String cur;
	static int line;
	static int CaretLine;
	static int Caret;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp window = new temp();
					window.frame.setVisible(true);
					cur = "C:\\";
					line=1;
					CaretLine=1;
					Caret=0;
					window.textArea.append(cur+">");
					System.out.println(window.textArea.getCaretPosition());
					window.textArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
					window.textArea.getInputMap().put(KeyStroke.getKeyStroke("UP"), "none");
					window.textArea.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "none");
					//window.textArea.setEditable(false);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public temp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if(Caret>=1) {
					
					//textArea.getInputMap().remove(KeyStroke.getKeyStroke("BACK_SPACE"));
					
					}
					else {
						textArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
					}
				}
			}
		});*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					//System.out.println(textArea.getCaretPosition());
					line++;
					System.out.println("Line 70 Line: "+line);
					CaretLine++;
					System.out.println("Line 72 CaretLine: "+CaretLine);
					Caret=0;
					System.out.println("Line 74 Caret: "+Caret);
					textArea.append(cur +">");
					//pos = textArea.getCaretPosition(); 
					//System.out.println(textArea.getLineCount());
					//System.out.println(textArea.getCaretPosition());
				}
			}
		});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_UP) {
					
					if(line!=1 && CaretLine!=1) {
						CaretLine--;
						System.out.println("Line 97 CaretLine: "+CaretLine);
						System.out.println("Line 98 line!=1");
						
						textArea.setEditable(false);
						textArea.getCaret().setVisible(true);
						System.out.println("textArea not Editable");
						
					}

					//Caret=0;
					
					//textArea.setEditable(true);
				}
			}
		});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
					if(CaretLine < line) {
						CaretLine++;
						System.out.println("Line 110 CaretLine: "+CaretLine);
					}
					
					
					//textArea.setEditable(true);
				}
			}
		});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(CaretLine==line) {
				textArea.setEditable(true);
				if(evt.getKeyChar() >='a' && evt.getKeyChar() <='z') {
					Caret++;
				}
				else if(evt.getKeyChar() >='A' && evt.getKeyChar() <='Z') {
					Caret++;
				}
				else if(evt.getKeyChar() >='0' && evt.getKeyChar() <='9') {
					Caret++;
				}
				else if(evt.getKeyChar() >='!' && evt.getKeyChar() <='~') {
					Caret++;
				}
				}
				else {
					textArea.setEditable(false);
				}
				
				System.out.println("Line 141 Caret: "+Caret);
				//textArea.setEditable(false);
		}});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if(Caret>=1) {
						Caret--;
						System.out.println("Line 155 Caret: "+Caret);
						System.out.println("Line 156 backspace enabled");
					textArea.getInputMap().remove(KeyStroke.getKeyStroke("BACK_SPACE"));
					}
					else {
						System.out.println("Line 160 backspace disabled");
						textArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
					}
					
				}
			}
		});
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setCaretColor(Color.white);
	}

}
