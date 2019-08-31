import java.io.File;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class ParsingHex {
	// 21 0x/0X
	// output:
	// 0x32f2f 3276476
	// hex dec

	public static void main(String[] args) throws IOException {
		// creates string array that contains information of hexdata.txt, line by line
		String[] hexdata = getData("hexdata.txt");

		// prints out entire array
		printStringArray(hexdata);
		// counts number of 0x's
		int numHexStarts = countNumHex(hexdata);
		System.out.println("There are " + numHexStarts + " hexedecimals.");

		String hex = "";
		for (int i = 0; i < hexdata.length; i++) {
			for (int j = 0; j < hexdata[i].length(); j++) {
				if (hexdata[i].charAt(j) == '0' && (hexdata[i].charAt(j + 1) == 'x' || hexdata[i].charAt(j + 1) == 'X')) {
					j+=2;
					for (int foo = 0; foo < 8 && j < hexdata[i].length(); foo++, j++) {
						if (!isHex(hexdata[i].charAt(j))) {
							break;
						}
						hex+=hexdata[i].charAt(j);
					}
//					System.out.println("Hex Found: "+hex);
					System.out.println("Hex Found: "+hex+" Dec: "+hexToDec(hex));
					hex="";
				}
			}
		}
		// System.out.println("Hex: F23AC43"); //253996099
		// System.out.println("Dec: "+hexToDec("F23AC43"));
	}

	public static int hexToDec(String hex) { //(maybe i gave in a tried) broken? like this program broke me so no fix
		int dec = 0;
		for (int i = 0; i < hex.length(); i++) {
			switch (Character.toUpperCase(hex.charAt(hex.length()-i-1))) {
				case '0':
					dec += 0;
					break;
				case '1':
					dec += 1 * Math.pow(16, i);
					break;
				case '2':
					dec += 2 * Math.pow(16, i);
					break;
				case '3':
					dec += 3 * Math.pow(16, i);
					break;
				case '4':
					dec += 4 * Math.pow(16, i);
					break;
				case '5':
					dec += 5 * Math.pow(16, i);
					break;
				case '6':
					dec += 6 * Math.pow(16, i);
					break;
				case '7':
					dec += 7 * Math.pow(16, i);
					break;
				case '8':
					dec += 8 * Math.pow(16, i);
					break;
				case '9':
					dec += 9 * Math.pow(16, i);
					break;
				case 'A':
					dec += 10 * Math.pow(16, i);
					break;
				case 'B':
					dec += 11 * Math.pow(16, i);
					break;
				case 'C':
					dec += 12 * Math.pow(16, i);
					break;
				case 'D':
					dec += 13 * Math.pow(16, i);
					break;
				case 'E':
					dec += 14 * Math.pow(16, i);
					break;
				case 'F':
					dec += 15 * Math.pow(16, i);
					break;
				default:
					System.out.println("Something is wrong");
					break;
			}
		}
		return dec;
	}

	public static boolean isHex(char x) { // utility method
		String hex = "0123456789ABCDEF";
		for (int i = 0; i < 16; i++) {
			if (Character.toLowerCase(hex.charAt(i))==Character.toLowerCase(x)) {
				return true;
			}
		}
		return false;
	}

	public static int countNumHex(String[] hexdata) {
		int numHexStarts = 0;
		for (int i = 0; i < hexdata.length; i++) {
			for (int j = 0; j < hexdata[i].length(); j++) {
				if (hexdata[i].charAt(j) == '0'
						&& (hexdata[i].charAt(j + 1) == 'x' || hexdata[i].charAt(j + 1) == 'X')) {
					numHexStarts++;
				}
				// System.out.println(i+" "+j);
			}
		}
		return numHexStarts;
	}

	public static String[] getData(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner inputStream = new Scanner(file);
		int numLines = 0;

		// finds number of lines in hexdata.txt
		while (inputStream.hasNextLine()) {
			numLines++;
			inputStream.nextLine();
		}

		// creates array
		String[] hexdata = new String[numLines];
		int i = 0;

		// reconstructs inputStream so that you can read file from begining again
		inputStream.close();
		inputStream = new Scanner(file);

		// puts information of hexdata.txt in a String array
		while (inputStream.hasNextLine()) {
			hexdata[i] = inputStream.nextLine();
			i++;
		}
		inputStream.close();
		return hexdata;
	}

	public static void printStringArray(String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
