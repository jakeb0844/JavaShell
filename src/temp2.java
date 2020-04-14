import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class temp2 {

	static JFrame frame;
	static JTextArea textArea;
	static String cur;
	static int line;
	//static int CaretLine;
	static int Caret;
	static String text="";
	static String curText="";
	static String temp="";
	static String op = "";
	static String arg = "";
	static int num = 0;
	static File[] Filez;

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
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public temp2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		File folder = new File("C:\\");
		Filez = folder.listFiles();
		BasicFileAttributes attr = null;
		cur=Filez[0].getParent();
		
		line=1;
		Caret=0;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 595, 380);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setCaretColor(Color.white);
		textArea.append(cur+">");
		textArea.setCaretPosition(4);
		System.out.println(textArea.getCaretPosition());
		textArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
		textArea.getInputMap().put(KeyStroke.getKeyStroke("UP"), "none");
		textArea.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "none");
		textArea.getInputMap().put(KeyStroke.getKeyStroke("Left"), "none");
		textArea.getInputMap().put(KeyStroke.getKeyStroke("Right"), "none");
		textArea.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "none");
		
		
		
		
		
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					//System.out.println(textArea.getCaretPosition());
					line++;
					System.out.println("Line 70 Line: "+line);
					
					num=text.indexOf(" ");
					System.out.println("NUM: "+num);
					
					
					
					//System.out.println("OP: "+op);
					//System.out.println("ARG: "+arg);
					if(num >=0) {
						op=text.substring(0, num);
						arg=text.substring(num+1, text.length());
					
						if(op.equals("cd") && (!arg.equals(".."))) {
							temp = cur;
							cur=Methods.cd(Filez,arg);
							
							if(cur != null) {
								Filez = Methods.refreshFilez(Filez, cur);
							}
							else {
								cur = temp;
								//System.out.println("Folder Doesn't Exist");
								textArea.append("\nFolder Doesn't Exist");
							}
							
						}
						else if(op.equals("cd") && arg.equals("..")) {
							
							if(!(cur.equals("C:\\"))) {
								File tempFile = new File(cur);
								cur=tempFile.getParent();
								Filez=Methods.refreshFilez(Filez, cur);
							}
						}
						else if(op.equals("cat")) {
							Methods.cat(Filez,arg);
						}
						else if(op.equals("mkdir")) {
							Methods.mkdir(Filez,arg,cur);
							Filez=Methods.refreshFilez(Filez, cur);
						}
					}//if num
					else {
						op=text;
						if(op.equals("ls")) {
							try {
								Methods.ls(Filez,attr);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else if(op.equals("Exit") || op.equals("exit")) {
							System.exit(0);
						}
						else if(op.equals("clear")) {
								Methods.clear();
						}
						
					}
					
					
					System.out.println("Line 74 Caret: "+Caret);
					System.out.println("Line 78 text: "+text);
					text="";
					textArea.append("\n");
					textArea.append(cur +">");
					textArea.setCaretPosition(textArea.getText().length());
					//System.out.println(textArea.getCaretPosition());
					//System.out.println(textArea.getText().length());
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
				else if(evt.getKeyChar() == ' ') {
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
						text=text.substring(0, Caret);
					
						textArea.getInputMap().remove(KeyStroke.getKeyStroke("BACK_SPACE"));
						
						System.out.println("Line 155 Caret: "+Caret);
						System.out.println("Line 156 text: "+text);
						System.out.println("Line 157 backspace enabled");
						
					
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
						curText = text.substring(0, Caret);
						System.out.println("Line 155 Caret: "+Caret);
						System.out.println("Line 156 curText: "+curText);
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
						curText = text.substring(0, Caret);
						System.out.println("Line 155 Caret: "+Caret);
						System.out.println("Line 156 curText: "+curText);
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
		

		
	}

}
