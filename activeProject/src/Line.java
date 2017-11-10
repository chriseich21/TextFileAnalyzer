//Austin Peterson
//class for line objs used in FileAttribs
//a vector of lines is included in FileAttribs
//a Vector of (tokenized) words is included in Line

import java.util.Vector;

public class Line {

	//attributes
	
	Vector<String> words;
	
	public Line(){
		
		words = new Vector<String>();
	}
	
	public void addWord(String word){
		words.addElement(word);
	}
	
	//getters
	public int getNumWords(){
		return words.size();
	}
	
	public int getNumSpaces(){
		//return # of spaces in the line
		//tokenizing method should make this true
		//whitespaces on end not counted
		//larger spaces counted as single space
		return words.size()-1;
	}
	
	public boolean isEmpty(){
		return words.isEmpty();
	}
	
	//returns vector of words, for FileAnalysis
	public Vector<String> getWords(){
		
		return words;
	}
	
}
