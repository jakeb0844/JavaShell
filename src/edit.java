import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class edit {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String data = "the text you want to send";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		InputStream old = System.in;
		try {
		    System.setIn( testInput );

		    
		} finally {
		    System.setIn( old );
		}
		
		 final byte[] passCode = "12343434".getBytes();
		 final ByteArrayInputStream inStream = new ByteArrayInputStream(passCode);
		        System.setIn(inStream);
		        Scanner reader = new Scanner(inStream);      
		  System.out.println(reader.nextLine());

	}

}
