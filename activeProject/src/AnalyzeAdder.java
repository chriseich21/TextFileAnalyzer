import java.util.Vector;

public class AnalyzeAdder {
	static Vector<String> pathways = new Vector<String>();// ZOE RETURN THIS DATA STRUCTURE
	// new File Reading portion done
	static FileAnalysis myFileAnalysis = new FileAnalysis();
	static Vector<FileAttribs> selectedFiles = new Vector<FileAttribs>();

	public static String addVectorPath(String newPathway) {
		pathways.addElement(newPathway);// easy testing
		// if you wanna test stuff have to come up with your own.
		
		// FileIO for creating FileAttrib objects
		FileIO myFileIO = new FileIO();

		// vector of FileAttribs that is the size of the pathways returned
		 Vector<FileAttribs> selectedFiles = new Vector<FileAttribs>();
		 
		 String messageDialog = "";
		// iterate through provided pathways
		for (int i = 0; i < pathways.size(); i++) {
			// call FileIO with current pathway
			FileAttribs tempFile = myFileIO.FileRead(pathways.elementAt(i));

			//		NOTE: not recognizing invalid files
			// if pathway is invalid, skip this pathway
			if (myFileIO.FileRead(pathways.elementAt(i)) == null) {
				System.out.println("opening File at: " + pathways.elementAt(i) + " [FAILED]");
			} else {
				selectedFiles.addElement(tempFile);
				// simple testing - modified to return stats of added file
				messageDialog =  "opening File at: " + pathways.elementAt(i) + " [SUCCESS]\n" + 
							"File Analysis Testing: " + "\nsize of file: "
						+ myFileAnalysis.getNumLines(selectedFiles.elementAt(i)) + "\nblank lines in file: "
						+ myFileAnalysis.getNumBlankLines(selectedFiles.elementAt(i)) + "\nblank lines in file: "
						+ myFileAnalysis.getNumBlankLines(selectedFiles.elementAt(i)) + "\n# of spaces in file: "
						+ myFileAnalysis.getNumSpaces(selectedFiles.elementAt(i)) + "\n# of words in file: "
						+ myFileAnalysis.getNumWords(selectedFiles.elementAt(i)) + "\navg chars/line in file: "
						+ myFileAnalysis.avgCharsPerLine(selectedFiles.elementAt(i)) + "\n";
				
				//maybe add extra for sum of stats if multiple files exist
			}
			//selectedFiles.elementAt(i).printFileAttribs();
		}
		
		/*
		// simple testing - modified to return stats of added file
		String messageDialog = "File Analysis Testing: " + "\nsize of file: "
				+ myFileAnalysis.getNumLines(selectedFiles.elementAt(pathways.size()-1)) + "\nblank lines in file: "
				+ myFileAnalysis.getNumBlankLines(selectedFiles.elementAt(pathways.size()-1)) + "\nblank lines in file: "
				+ myFileAnalysis.getNumBlankLines(selectedFiles.elementAt(pathways.size()-1)) + "\n# of spaces in file: "
				+ myFileAnalysis.getNumSpaces(selectedFiles.elementAt(pathways.size()-1)) + "\n# of words in file: "
				+ myFileAnalysis.getNumWords(selectedFiles.elementAt(pathways.size()-1)) + "\navg chars/line in file: "
				+ myFileAnalysis.avgCharsPerLine(selectedFiles.elementAt(pathways.size()-1));
	*/	
		// compare outputs
		/*
		 * System.out.println("File Analysis Testing:");
		 * System.out.println("size of file: "+myFileAnalysis.getNumLines(selectedFiles.
		 * elementAt(0)));
		 * System.out.println("blank lines in file: "+myFileAnalysis.getNumBlankLines(
		 * selectedFiles.elementAt(0)));
		 * System.out.println("# of spaces in file: "+myFileAnalysis.getNumSpaces(
		 * selectedFiles.elementAt(0)));
		 * System.out.println("# of words in file: "+myFileAnalysis.getNumWords(
		 * selectedFiles.elementAt(0)));
		 * System.out.println("avg chars/line in file: "+myFileAnalysis.avgCharsPerLine(
		 * selectedFiles.elementAt(0)));
		 */
		
		return messageDialog;
	}

	/* modify later for history?
	static Vector<String> history = new Vector<String>(); //for previous files
	public static boolean updateHistory(String currentFilePath) {
		for(int i = 0; i < history.size(); i++){
			String previousFile = history.elementAt(i); //find previous file
			if(currentFilePath.equals(previousFile)) {
				return false; //file already included
			}
		}
		history.add(currentFilePath); //add this file path to history
		return true;
	}
	*/

}
