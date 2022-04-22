import java.io.File;
import java.util.Scanner;


public class q3 {
	public static void main(String[] args) {
		String filename;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter filename : ");
		filename = sc.nextLine();
		
		File file = new File(filename);
		if(file.exists()) {
			if(file.isDirectory()) {
				System.out.println(filename+" exists & is a directory");
				System.out.println("The files in the directory ===>");
				
				File[] listOfFiles = file.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {
				  if (listOfFiles[i].isFile()) {
				    System.out.println("File " + listOfFiles[i].getName());
				  }
				}
			}else {
				System.out.println(filename+" exists & is a file");
				if(file.canRead()) {
					System.out.println(filename+" can be read");
				}else {
					System.out.println(filename+" can not be read");
				}
				
				if(file.canWrite()) {
					System.out.println(filename+" can be written");
				}else {
					System.out.println(filename+" can not be written");
				}
			}
		}else {
			System.out.println(filename+" does not exists");
		}
		
	}
}

