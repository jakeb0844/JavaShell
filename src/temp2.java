import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class temp2 {

	 JFrame frame;
	 JTextArea textArea;
	static String cur;
	static int line;
	//static int CaretLine;
	static int Caret;
	static String text="";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp2 window = new temp2();
					window.frame.setVisible(true);
					cur = "C:\\";
					line=1;
					//CaretLine=1;
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
	}*/

	/**
	 * Create the application.
	 */
	public temp2() {
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
		
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					//System.out.println(textArea.getCaretPosition());
					line++;
					System.out.println("Line 70 Line: "+line);
					//CaretLine++;
					//System.out.println("Line 72 CaretLine: "+CaretLine);
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
				
				if(evt.getKeyChar() >='a' && evt.getKeyChar() <='z') {
					Caret++;
					text+=evt.getKeyChar();
				}
				else if(evt.getKeyChar() >='A' && evt.getKeyChar() <='Z') {
					Caret++;
					text+=evt.getKeyChar();
				}
				else if(evt.getKeyChar() >='0' && evt.getKeyChar() <='9') {
					Caret++;
					text+=evt.getKeyChar();
				}
				else if(evt.getKeyChar() >='!' && evt.getKeyChar() <='~') {
					Caret++;
					text+=evt.getKeyChar();
				}
			
				
				//text+=evt.getKeyChar();
				System.out.println("Line 140 Text Length:"+text.length());
				System.out.println("Line 141 Caret: "+Caret);
				//textArea.setEditable(false);
		}});
		//Have to delete characters off string.
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if(Caret>=1) {
						Caret--;
						textArea.getInputMap().remove(KeyStroke.getKeyStroke("BACK_SPACE"));
						System.out.println("Line 155 Caret: "+Caret);
						System.out.println("Line 156 backspace enabled");
						
					
					}
					else {
						System.out.println("Line 160 backspace disabled");
						textArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
					}
					
				}
			}
		});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_LEFT) {
					if(Caret>=1) {
						Caret--;
						System.out.println("Line 155 Caret: "+Caret);
						System.out.println("Line 156 left enabled");
					textArea.getInputMap().remove(KeyStroke.getKeyStroke("LEFT"));
					}
					else {
						System.out.println("Line 160 left disabled");
						textArea.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "none");
					}
					
				}
			}
		});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(Caret >= 0 && Caret < text.length()) {
						Caret++;
						System.out.println("Line 155 Caret: "+Caret);
						System.out.println("Line 156 right enabled");
					textArea.getInputMap().remove(KeyStroke.getKeyStroke("RIGHT"));
					}
					else {
						System.out.println("Line 160 right disabled");
						textArea.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "none");
					}
					
				}
			}
		});
		
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
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(0, 0, 434, 261);
		textArea.setCaretColor(Color.white);
		frame.getContentPane().add(textArea);
	}

}
