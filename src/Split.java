
public class Split {

	public static void main(String[] args) {
		String op = " ";
		String temp = "";
		int x =0;
		
		x = op.indexOf(" ");
		System.out.println(x);
		
		
		if(x >= 0) {
		System.out.println(op.substring(0, x));
		System.out.println(op.substring(x+1, op.length()));
		}

	}

}
