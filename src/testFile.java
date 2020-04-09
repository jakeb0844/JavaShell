import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class testFile {
	
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
		for(int i=0; i < File.length; i++) {
			if(!(File[i].isHidden())){
				attr= Files.readAttributes(File[i].toPath(), BasicFileAttributes.class);
				if(File[i].isDirectory()) {
					System.out.println(attr.creationTime() + "\t<DIR>\t" +File[i].getName());
				}
				else {
					System.out.println(attr.creationTime() + "\t     \t" +File[i].getName());
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
		
		
		File file = findFile(filez, name);
		if(file != null) {
			if(file.isFile()) {
			try {
				Scanner reader = new Scanner(file);
				while(reader.hasNextLine()) {
					System.out.println(reader.nextLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}//if
			else {
				System.out.println("Not File");
			}
		}
		else {
			System.out.println("File doesn't exists");
		}
		
	}

	public static void clear() throws InterruptedException, IOException {
	        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    
	}
	
	public static void mkdir(File[] filez, String name, String cur) {
		File file = findFile(filez,name);
		
		if(file == null) {
			new File(cur+name).mkdir();
		}
		else {
			System.out.println("Folder or File Exists");
		}
	}

	public static void createFile() {
		
	}
	public static void main(String[] args) throws IOException {
		File folder = new File("C:\\");
		File[] Filez = folder.listFiles();
		BasicFileAttributes attr = null;
		String cur=Filez[0].getParent();
		String op="";
		String arg="";
		String temp="";
		int num=0;
		Scanner input = new Scanner(System.in);
		Boolean go = true;
		
		while(go) {
			System.out.print(cur + ">");
			temp=input.nextLine();
			
			num=temp.indexOf(" ");
			//System.out.println("Line 82: "+num);
			if(num >= 0) {
				op=temp.substring(0, num);
				arg=temp.substring(num+1, temp.length());
				
				//System.out.println("OP: "+op);
				//System.out.println("ARG: "+arg);
				
				if(op.equals("cd") && (!arg.equals(".."))) {
					temp = cur;
					cur=cd(Filez,arg);
					
					if(cur != null) {
						Filez = refreshFilez(Filez, cur);
					}
					else {
						cur = temp;
						System.out.println("Folder Doesn't Exist");
					}
					
				}
				else if(op.equals("cd") && arg.equals("..")) {
					
					if(!(cur.equals("C:\\"))) {
						File tempFile = new File(cur);
						cur=tempFile.getParent();
						Filez=refreshFilez(Filez, cur);
					}
				}
				else if(op.equals("cat")) {
					cat(Filez,arg);
				}
				else if(op.equals("mkdir")) {
					mkdir(Filez,arg,cur);
					Filez=refreshFilez(Filez, cur);
				}
			}//if num
			else {
				op=temp;
				if(op.equals("ls")) {
					ls(Filez,attr);
				}
				else if(op.equals("Exit") || op.equals("exit")) {
					go = false;
					System.out.println("Exiting......");
				}
				else if(op.equals("clear")) {
					try {
						clear();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}//end of while
		
		input.close();
		
	}//end of main
	
}//end of class
