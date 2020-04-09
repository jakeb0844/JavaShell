import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import javax.swing.UnsupportedLookAndFeelException;

public class mainClass {
	public static String cur;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		File folder = new File("C:\\");
		File[] Filez = folder.listFiles();
		BasicFileAttributes attr = null;
		cur=Filez[0].getParent();
		String op="";
		String arg="";
		String temp="";
		int num=0;
		Scanner input = new Scanner(System.in);
		Boolean go = true;

		testGUI window = new testGUI();
		window.frmTerminal.setVisible(true);
		
		while(go) {
			window.textArea.append(cur);
			window.textArea.append(">");
			int len = window.textArea.getDocument().getLength();
			window.textArea.setCaretPosition(len);
			
			break;
		}
	}

}
