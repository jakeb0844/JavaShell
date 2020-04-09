import java.io.File;

public class Test {

	public static File findFile(File[] File, String name) {
		File f = null;
		System.out.println("line 21");
		for(int i=0; i < File.length; i++) {
			
			/*if(File[i].getName().toLowerCase().equals(name.toLowerCase())) {
				f = new File(File[i].getAbsolutePath());
			}*/
		
			
		}
		if(f != null) {
		System.out.println("Line 27:"+name);
		System.out.println("Line 29:"+f.getName());
		System.out.println("Line 28:"+f.getAbsolutePath());
		}
		
		return f;
	}
	
	
	public static void main(String[] args) {
		

	}

}
