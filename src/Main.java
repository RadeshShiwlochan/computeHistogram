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
		int num;
		try {
			Scanner readFile = new Scanner(new File(inputFile));
			PrintWriter writeToFile = new PrintWriter(new File(outputFile));
			numRows = readFile.nextInt();
			numCols = readFile.nextInt();
			minVal = readFile.nextInt();
			maxVal = readFile.nextInt();
			histogram = new int[maxVal + 1];
			
			//initialize the histogram array to zeroes
			for(int i = 0; i < histogram.length;i++)
				histogram[i] = 0;
			
			while(readFile.hasNextInt()) {
				num = readFile.nextInt();
				computeHistogram(num);
			}	
			printHistogram(writeToFile);
			readFile.close();
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
	
	public void computeHistogram(int numFromFile) {
		histogram[numFromFile]++;
	}
	
	public void printHistogram(PrintWriter writeToFile) {
		int numVal = 0;
		for(int i = 0; i < histogram.length; i++) {
			if(histogram[i] >= 60)
				numVal = 60;
			else 
				numVal = histogram[i];
			writeToFile.print( "( " + i + " ) : " + histogram[i] + " ");
			for(int j = 0; j < numVal; j++)
				writeToFile.print("+");
			writeToFile.println();
		}
		writeToFile.flush();
		writeToFile.close();
	}
}
