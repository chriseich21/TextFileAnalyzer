
import java.util.Vector;


public class AnalyzeAdder {
	static Vector<String> pathways = new Vector<String>();
	// new File Reading portion done
	static FileAnalysis myFileAnalysis = new FileAnalysis();
	static Vector<FileAttribs> selectedFiles = new Vector<FileAttribs>();
	
	static String historyFileString = "";
	static double finalAvgFileSize = 0;
	static double finalAvgLines = 0;
	static double finalAvgSpaces = 0;
	static double finalAvgNumWords = 0;
	static double finalAvgNumChars = 0;
	
	//add pathway given by user for the text file. returns statistics for the text file in a string.
	public static String addVectorPath(String newPathway) {
		
		//local variables for current sum for later average calculations
		int avgFileSize = 0;
		int avgLines = 0;
		int avgSpaces = 0;
		int avgNumWords = 0;
		double avgNumChars = 0;
		
		//add the pathway
		pathways.addElement(newPathway);
		
		// FileIO for creating FileAttrib objects
		FileIO myFileIO = new FileIO();

		// vector of FileAttribs that is the size of the pathways returned
		 Vector<FileAttribs> selectedFiles = new Vector<FileAttribs>();
		 
		//keep track of failed files, otherwise the i value will become inaccurate
		 int numberOfFailedFiles = 0; 
		 
		 //messageDialog. it begins as empty string.
		 String messageDialog = "";
		 
		// iterate through provided pathways
		for (int i = 0; i < pathways.size(); i++) {
			// call FileIO with current pathway
			FileAttribs tempFile = myFileIO.FileRead(pathways.elementAt(i));

			// if pathway is invalid, skip this pathway
			if (myFileIO.FileRead(pathways.elementAt(i)) == null) {
				numberOfFailedFiles++; //keep track of how many files failed - it will affect which element we want to examine for file stats.
				messageDialog = "opening File at: " + pathways.elementAt(i) + " [FAILED]\n";
			} else {
				selectedFiles.addElement(tempFile);
				// simple testing - modified to return stats of added file
				messageDialog =  "opening File at: " + pathways.elementAt(i) + " [SUCCESS]\n" + 
							"File Analysis Testing: " + "\nsize of file: "
						+ myFileAnalysis.getNumLines(selectedFiles.elementAt(i-numberOfFailedFiles)) + "\nblank lines in file: "
						+ myFileAnalysis.getNumBlankLines(selectedFiles.elementAt(i-numberOfFailedFiles)) + "\n# of spaces in file: "
						+ myFileAnalysis.getNumSpaces(selectedFiles.elementAt(i-numberOfFailedFiles)) + "\n# of words in file: "
						+ myFileAnalysis.getNumWords(selectedFiles.elementAt(i-numberOfFailedFiles)) + "\navg chars/line in file: "
						+ myFileAnalysis.avgCharsPerLine(selectedFiles.elementAt(i-numberOfFailedFiles)) + "\nmost common words in file: "
						+ myFileAnalysis.mostCommonWords(selectedFiles.elementAt(i-numberOfFailedFiles)) + "\n\n";
				
				//extra for sum of stats if multiple files exist
				avgFileSize += myFileAnalysis.getNumLines(selectedFiles.elementAt(i-numberOfFailedFiles));
				avgLines += myFileAnalysis.getNumBlankLines(selectedFiles.elementAt(i-numberOfFailedFiles));
				avgSpaces += myFileAnalysis.getNumSpaces(selectedFiles.elementAt(i-numberOfFailedFiles));
				avgNumWords += myFileAnalysis.getNumWords(selectedFiles.elementAt(i-numberOfFailedFiles));
				avgNumChars += myFileAnalysis.avgCharsPerLine(selectedFiles.elementAt(i-numberOfFailedFiles));
				
				//add the last file we added in for analysis to history
				FileAttribs newHistory = myFileIO.FileRead(pathways.elementAt(pathways.size()-1));
				historyFileString = historyFileString + "name: " + newHistory.name + "\ndate: " + newHistory.date + "\n\n";	

			}
		}
		
		//average only working on first call?
		//call update average function
		updateAverage(avgFileSize, avgLines, avgSpaces, avgNumWords, avgNumChars, numberOfFailedFiles);

		return messageDialog;
	}

	//updates the current average for each file stat
	public static void updateAverage(double avgFileSize, double avgLines, double avgSpaces, double avgNumWords, double avgNumChars, double numberOfFailedFiles) {
		finalAvgFileSize = avgFileSize/((pathways.size()-numberOfFailedFiles));
		finalAvgLines = avgLines/((pathways.size()-numberOfFailedFiles));
		finalAvgSpaces = avgSpaces/((pathways.size()-numberOfFailedFiles));
		finalAvgNumWords = avgNumWords/((pathways.size()-numberOfFailedFiles));
		finalAvgNumChars = avgNumChars/((pathways.size()-numberOfFailedFiles));

		return;
	}
	
	//appends the average among the files to the end of the message dialogue. returns new message dialogue with avgs appended onto it.
	public static String appendAverage(String currentMD) {
		currentMD = currentMD + "Averages:\nsize of file: " + finalAvgFileSize
				+ "\nblank lines: " + finalAvgLines 
				+ "\n# of spaces: "+ finalAvgSpaces
				+ "\n# of words: " + finalAvgNumWords 
				+ "\n# of chars: " + finalAvgNumChars + "\n ";
		return currentMD;
	}
	
	//clears the current average and resets pathways
	public static void clearCurrentAverage() {
		//reset all values
		finalAvgFileSize = 0; 
		finalAvgLines = 0;
		finalAvgSpaces = 0;
		finalAvgNumWords = 0;
		finalAvgNumChars = 0;
		pathways.clear(); //clear the vector pathways.
		return;
	}
	
}
