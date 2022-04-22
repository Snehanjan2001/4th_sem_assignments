import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String filename = "names2.txt";
		
		try {
			FileWriter fileWriter = new FileWriter(filename);
			while(true) {
				System.out.print("Enter name to save [Enter -1 to stop]:");
				name = sc.nextLine();
				if(name.equals("-1")) break;
				fileWriter.write(name+"\n");
			}
			fileWriter.close();
			System.out.println("All the names has been writen in file!");
			
			Scanner sc1 = new Scanner(new File(filename));
			while(sc1.hasNext()) {
				System.out.println(sc1.nextLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
