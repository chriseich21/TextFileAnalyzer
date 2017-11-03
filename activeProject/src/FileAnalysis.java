//Austin Peterson

//This class will be responsible of the logic/analysis heavy lifting
//given an obj created by FileIO

public class FileAnalysis {

	//NOTE: this class will act as a wrapper for returning information about
	//FileAttribs objects that the object COULD do on its own (# of lines, spaces, etc).
	
	//Done
	public int getNumLines(FileAttribs file){
		
		return file.getSize();
	}
	
	//Done
	public int getNumBlankLines(FileAttribs file){
		
		int blank = 0;
		
		//iterate through Line objs in file
		for(int i = 0; i < file.getSize(); i++){
			if(file.getLine(i).isEmpty()){
				blank++;
			}
		}
		
		return blank;
	}
	
	//Done
	//NOTE: in current version spaces are just whitespace between words. "     " counts as one space
	public int getNumSpaces(FileAttribs file){
		
		int numSpaces = 0;
		
		for(int i = 0; i < file.getSize(); i++){
			numSpaces = numSpaces+file.getLine(i).getNumSpaces();
		}
		
		return numSpaces;
	}

	//Done
	public int getNumWords(FileAttribs file){
		
		int numWords = 0;
		
		for(int i = 0; i < file.getSize(); i++){
			numWords = numWords+file.getLine(i).getNumWords();
		}
		
		return numWords;
	}
	
	//
	public int avgCharsPerLine(FileAttribs file){
		 
		return 1;
	}
	
	//
	public int avgWordLength(FileAttribs file){
		
		return 1;
	}
	
	//return most common words within a String array
	//could do top 10, top 5? make configurable and pass in - in GUI?
	public String[] mostCommonWords(FileAttribs file){
		
		return null;
	}
	
}
