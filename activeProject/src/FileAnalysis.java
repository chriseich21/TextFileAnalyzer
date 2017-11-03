//Austin Peterson

//This class will be responsible of the logic/analysis heavy lifting
//given an obj created by FileIO

public class FileAnalysis {

	//NOTE: this class will act as a wrapper for returning information about
	//FileAttribs objects that the object COULD do on its own (# of lines, spaces, etc).
	
	public int getNumLines(FileAttribs file){
		
		return file.getSize();
	}
	
	public int getNumBlankLines(FileAttribs file){
		
		return 1;
	}
	
	public int getNumSpaces(FileAttribs file){
		
		return 1;
	}

	public int getNumWords(FileAttribs file){
		
		return 1;
	}
	
	public int avgCharsPerLine(FileAttribs file){
		 
		return 1;
	}
	
	public int avgWordLength(FileAttribs file){
		
		return 1;
	}
	
	//return most common words within a String array
	//could do top 10, top 5? make configurable and pass in - in GUI?
	public String[] mostCommonWords(FileAttribs file){
		
		return null;
	}
	
}
