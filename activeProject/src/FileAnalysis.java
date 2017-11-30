import java.util.List;
import java.util.Vector;

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
		
		return numSpaces+ getNumBlankLines(file);
	}

	//Done
	public int getNumWords(FileAttribs file){
		
		int numWords = 0;
		
		for(int i = 0; i < file.getSize(); i++){
			numWords = numWords+file.getLine(i).getNumWords();
		}
		
		return numWords;
	}
	
	//not currently correct:)
	//this is probably written less efficient than it could be
	//feel free to rewrite
	public double avgCharsPerLine(FileAttribs file){
		
		int[] charsPerLine = new int[file.getSize()];
		
		//iterate over lines
		for(int i = 0; i < file.getSize(); i++){
			int charsInline = 0;
			
			Vector<String> words = file.getLine(i).getWords();
			
			//iterate over words in line
			for(int j = 0; j < words.size(); j++){
				charsInline = charsInline + words.elementAt(j).length();
			}
			
			charsPerLine[i] = charsInline;
		}
		
		//sum the chars
		double sum = 0;
		
		for(int i = 0; i < charsPerLine.length; i++){
			sum = sum+charsPerLine[i];
		}
		
		//find average
		double average = sum/(charsPerLine.length);
		
		return average;
	}
	
	//Done
	public double avgWordLength(FileAttribs file){
		int charsInFile = 0;
		double avgWordLength = 0;
		double totalWords = getNumWords(file);
		
		//Iterate through all the lines and find the total characters
		for(int i = 0; i < file.getSize(); i++) {
			int charsInline = 0;
			
			Vector<String> words = file.getLine(i).getWords();
			
			//iterate over words in line
			for(int j = 0; j < words.size(); j++){
				charsInline = charsInline + words.elementAt(j).length();
			}
			
			charsInFile = charsInline +charsInFile;
		}
		
		//fine average
		avgWordLength = charsInFile/totalWords;
		
		return avgWordLength;
	}
	
	//return most common words within a String array
	//could do top 10, top 5? make configurable and pass in - in GUI?
	public List<String> mostCommonWords(FileAttribs file){
		List<String> strList = new Vector<String>(); // Store all words
		List<Integer> intList = new Vector<Integer>(); //(Synchronized with strList) This is the number of times of the appearance of the words
		
		for(int i = 0 ; i < file.getSize(); i++) {// iterate through all the lines
			
			Vector<String> words = file.getLine(i).getWords();
			
			for(int j = 0; j < words.size() ; j++) {// go through each word
				//add the word first
				String wordsTemp = words.elementAt(j); // get the word first
				int one = 1;
				
				int strIndex = strList.lastIndexOf(wordsTemp);
				int intIndex = intList.lastIndexOf(one);
				
				if(strIndex == -1) {// not present
					strList.add(wordsTemp); // add to the end of the vector
					intList.add(one); // add the count for it
				}
				else {// It is inside the array already
					int countTemp = intList.get(strIndex);
					countTemp++;
					intList.set(strIndex, countTemp);
				}
			}
		}
		
		//Sort the sizes
		List<String> strListNew = new Vector<String>();
		
		int n = strList.size();
		for(int i = 0; i < n; i++) {
			int key = intList.get(i);
			String strKey = strList.get(i);
			int j = i-1;
			while(j>=0 && intList.get(j)< key) {
				intList.set(j+1, intList.get(j));
				strList.set(j+1, strList.get(j));
				j = j-1;
			}
			intList.set(j+1, key);
			strList.set(j+1, strKey);
		}
		
		//get the top 5
		if(strList.size() > 5) {
			for(int i = 0; i < 5; i++) {
				strListNew.add(strList.get(i));
			}
			return strListNew;
		}
		else {
			return strList;
		}
	}
	
}
