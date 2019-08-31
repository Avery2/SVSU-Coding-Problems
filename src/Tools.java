import java.io.*;
import java.util.Scanner;
public class Tools {
	//IN PROGRESS
	static void PrintLns(String filePath, int lnStart, int lnEnd) throws IOException {
		Scanner read = new Scanner(new FileReader(filePath));
		for (int i=0; i<lnStart; i++) {
			read.nextLine();
		read.close();
		}
	}
	static void PrintFile(String filePath) throws FileNotFoundException {
		Scanner read = new Scanner(new FileReader(filePath));
		while (true) {
			try {
				System.out.println(read.nextLine());
			} catch (Exception e) {
				System.out.println(e);
				read.close();
				break;
			}
		}
	}
	
	static String ReadLn(String filePath, int lnNum) throws IOException {
		Scanner read = new Scanner(new FileReader(filePath));
		for (int i=1; i<lnNum; i++) {
			read.nextLine();
		}
		read.close();
		return read.nextLine();
	}
}