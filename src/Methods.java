import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Methods {
	public static String cd(File[] Filez,String name) {
		
		File x = findFile(Filez,name);
		if(x != null) {
		//System.out.println("Line 14:"+x.getName());
		//System.out.println("Line 15:"+x.getParent());
		refreshFilez(Filez,x.getAbsolutePath());
		
		return x.getAbsolutePath();
		}
		else {
			return null;
		}
	}
	
	public static File findFile(File[] File, String name) {
		File f = null;
		//System.out.println("line 21");
		for(int i=0; i < File.length; i++) {
			
			if(File[i].getName().toLowerCase().equals(name.toLowerCase())) {
				f = new File(File[i].getAbsolutePath());
			}
			
		}
		if(f != null) {
		//System.out.println("Line 27:"+name);
		//System.out.println("Line 29:"+f.getName());
		//System.out.println("Line 28:"+f.getAbsolutePath());
		}
		else {
			f = new File("C:\\" + name);
			if(f.exists()) {
				return f;
			}
			else {
				f = null;
			}
		}
		
		return f;
	}
	
	
	public static void ls(File[] File, BasicFileAttributes attr) throws IOException {
		temp2.textArea.append("\n");
		for(int i=0; i < File.length; i++) {
			if(!(File[i].isHidden())){
				attr= Files.readAttributes(File[i].toPath(), BasicFileAttributes.class);
				
				if(File[i].isDirectory()) {
					//System.out.println(attr.creationTime() + "\t<DIR>\t" +File[i].getName());
					temp2.textArea.append(attr.creationTime() + "\t<DIR>\t" +File[i].getName());
					temp2.textArea.append("\n");
				}
				else {
					//System.out.println(attr.creationTime() + "\t     \t" +File[i].getName());
					temp2.textArea.append(attr.creationTime() + "\t     \t" +File[i].getName());
					temp2.textArea.append("\n");
				}
				
			}
			
		}
	}
	
	public static File[] refreshFilez(File[] filez, String path) {
		File folder = new File(path);
		filez = folder.listFiles();
		
		
		//System.out.println("Line 56:"+path);
		//System.out.println(filez[0].getName());
		
		return filez;

	}
	
	public static void cat(File[] filez,String name) {
		
		temp2.textArea.append("\n");
		File file = findFile(filez, name);
		if(file != null) {
			if(file.isFile()) {
			try {
				Scanner reader = new Scanner(file);
				while(reader.hasNextLine()) {
					//System.out.println(reader.nextLine());
					temp2.textArea.append(reader.nextLine());
					temp2.textArea.append("\n");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}//if
			else {
				//System.out.println("Not File");
				temp2.textArea.append("Can't Read From DIR" );
			}
		}
		else {
			//System.out.println("File doesn't exists");
			temp2.textArea.append("File doesn't exists");
		}
		
	}

	public static void clear() {
	        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		temp2.textArea.setText("");
	    
	}
	
	public static void mkdir(File[] filez, String name, String cur) {
		File file = findFile(filez,name);
		
		if(file == null) {
			if(cur.toLowerCase().equals("C:\\".toLowerCase())) {
				System.out.println(cur+name);
				new File(cur+name).mkdir();
			}
			else {
				System.out.println(cur+"\\"+name);
				new File(cur+"\\"+name).mkdir();
			}
		
		}
		else {
			//System.out.println("Folder or File Exists");
			temp2.textArea.append("\nFolder or File Exists");
		}
	}

	public static void createFile() {
		
	}
}
