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
			histogram = new int[maxVal + 1];
			
			while(readFile.hasNextInt()) {
				num = readFile.nextInt();
				computeHistogram(num);
				//System.out.print(num + " ");
				writeToFile.print(String.format("%2d", num) + "\t");
				count++;
				if(count == numCols) {
					//System.out.println();
					count = 0;
				}	
			}
			writeToFile.flush();
		} catch(IOException exc) {
			System.out.println("Error occurred reading in file " + exc);
		}
		printHistogram();
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
	
	public void computeHistogram(int numFromFile) {
		histogram[numFromFile]++;
	}
	
	public void printHistogram() {
		int numVal = 0;
		for(int i = 0; i < histogram.length; i++) {
			if(histogram[i] >= 60)
				numVal = 60;
			else 
				numVal = histogram[i];
			System.out.print( "( " + i + " ) : " + histogram[i] + " ");
			for(int j = 0; j < numVal; j++)
				System.out.print("+");
			System.out.println();
		}
	}
}
