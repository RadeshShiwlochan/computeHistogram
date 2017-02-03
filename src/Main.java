import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main  {
	private int [] histogram;
	private int numRows;
	private int numCols;
	private int minVal;
	private int maxVal;
	
	public Main(String inputFile, String outputFile)  {
		int num, count = 0;
		try {
			Scanner readFile = new Scanner(new File(inputFile));
			PrintWriter writeToFile = new PrintWriter(new File(outputFile));
			numRows = readFile.nextInt();
			numCols = readFile.nextInt();
			minVal = readFile.nextInt();
			maxVal = readFile.nextInt();
			
			while(readFile.hasNextInt()) {
				num = readFile.nextInt();
				System.out.print(num + " ");
				writeToFile.print("" + String.format("%2d", num) + "\t");
				count++;
				if(count == numCols) {
					System.out.println();
					count = 0;
				}
					
			}
			writeToFile.flush();
		} catch(IOException exc) {
			System.out.println("Error occurred reading in file " + exc);
		}
	}

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Needs an input file");
			System.exit(-1);
		}
		
		try {
		String inputFile = args[0];	
		String outputFile = args[1];
		
			Main mainObj = new Main(inputFile, outputFile);
		} catch (Exception ioe) {
			System.out.println(ioe);
		}
		
	}
}
