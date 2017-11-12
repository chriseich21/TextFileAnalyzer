import java.util.Vector;
import javax.swing.JOptionPane;

public class TextFileAnalyzer {
/*	//placeholders/testers for returned values/data from GUI
	static Vector<String> pathways = new Vector<String>();//ZOE RETURN THIS DATA STRUCTURE
	//initially after new GUI and before pathways.addElement
	
	//new File Reading portion done
	static FileAnalysis myFileAnalysis = new FileAnalysis();
	
	static Vector<FileAttribs> selectedFiles = new Vector<FileAttribs>();
			
	public static void addVectorPath(String newPathway) {
		pathways.addElement(newPathway);//easy testing
		//if you wanna test stuff have to come up with your own.
		
		//FileIO for creating FileAttrib objects
				FileIO myFileIO = new FileIO();
				
				//vector of FileAttribs that is the size of the pathways returned
				//Vector<FileAttribs> selectedFiles = new Vector<FileAttribs>();
				
				//iterate through provided pathways
				for (int i = 0; i < pathways.size(); i++){
					//call FileIO with current pathway
					FileAttribs tempFile = myFileIO.FileRead(pathways.elementAt(i));
					
					//if pathway is invalid, skip this pathway
					if(myFileIO.FileRead(pathways.elementAt(i)) == null){
						System.out.println("opening File at: " + pathways.elementAt(i) + " [FAILED]");
					}else{
						selectedFiles.addElement(tempFile);
						System.out.println("opening File at: " + pathways.elementAt(i) + " [SUCCESS]");
					}
					
				}
				
				selectedFiles.elementAt(0).printFileAttribs();
				
				
				//simple testing
				System.out.println("File Analysis Testing:");
				System.out.println("size of file: "+myFileAnalysis.getNumLines(selectedFiles.elementAt(0)));
				System.out.println("blank lines in file: "+myFileAnalysis.getNumBlankLines(selectedFiles.elementAt(0)));
				System.out.println("# of spaces in file: "+myFileAnalysis.getNumSpaces(selectedFiles.elementAt(0)));
				System.out.println("# of words in file: "+myFileAnalysis.getNumWords(selectedFiles.elementAt(0)));
				System.out.println("avg chars/line in file: "+myFileAnalysis.avgCharsPerLine(selectedFiles.elementAt(0)));
		return;
	}
			*/
	public static void main(String[] args) {
		
		
		new GUI();//Zoe find a way to return the pathway/buttons people choose
		//for starters, return an vector/whatever of pathways the user chooses.
		//could be 10, could be 1.
	}

}
