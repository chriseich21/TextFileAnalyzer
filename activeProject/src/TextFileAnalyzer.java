import java.util.Vector;

public class TextFileAnalyzer {

	public static void main(String[] args) {
		
		new GUI();//Zoe find a way to return the pathway/buttons people choose
		//for starters, return an vector/whatever of pathways the user chooses.
		//could be 10, could be 1.
		
		
		
		//placeholders/testers for returned values/data from GUI
		Vector<String> pathways = new Vector<String>();//ZOE RETURN THIS DATA STRUCTURE
		pathways.addElement("/Users/austinpeterson/Desktop/test.txt");//easy testing
		
		
		
		//FileIO for creating FileAttrib objects
		FileIO myFileIO = new FileIO();
		
		//vector of FileAttribs that is the size of the pathways returned
		Vector<FileAttribs> selectedFiles = new Vector<FileAttribs>();
		
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
		
		
		
	}

}
