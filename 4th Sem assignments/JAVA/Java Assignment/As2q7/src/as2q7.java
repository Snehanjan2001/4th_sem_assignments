import java.util.Arrays;
import java.util.Scanner;

public class as2q7 {
	
	static int countA(String text) {
		int count = 0;
		for(char x : text.toCharArray()) {
			if(x == 'a' ) {
				count++;
			}
		}
		return count;
	}
	
	static int noOfTimesAnd(String text) {
		int count = 0;
		String a[] = text.split(" ");
		for(String x : a) {
			if(x.equals("and")) {
				count++;
			}
		}
		return count;
	}
	
	static boolean isStartWithThe(String text) {
		return text.startsWith("The");
	}
	
	static String[] getTokens(String text) {
		String[] tokens = new String[100];
		int index  = 0;
		int start = 0;
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ' ' || text.charAt(i) == '@' || text.charAt(i) == '.') {
				tokens[index++] = text.substring(start, i);
				start = i+1;
			}
		}
		tokens[index++] = text.substring(start, text.length());
		return tokens;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text : ");
		String text = sc.nextLine();
		
		System.out.println("Counts of a : "+countA(text));
		System.out.println("Counts of and : "+noOfTimesAnd(text));
		System.out.println("Started with `the` ? :  "+(isStartWithThe(text) ? "yes" : "no"));
		System.out.println("Array of characters : "+Arrays.toString(text.toCharArray()));
		System.out.print("Tokens : ");
		for(String i : getTokens(text)) {
			if(i==null)break;
			System.out.print(i+" ");
		}
		
		sc.close();

	}

}
