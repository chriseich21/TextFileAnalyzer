//Austin Peterson
//this is the ONLY class that should touch the file to be read

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class FileIO {

	//read in file given pathway (check validity)
	//return a FileAttribs object
	//this method is ugly and I don't know how pathways work
	//note: filename String passed in should include the pathway?
	public FileAttribs FileRead(String pathway){//pathway passed in
		
		//use pathway to get the file and validate that it works,
		//set up a reader
		File file = new File(pathway);
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			//create new FileAttribs obj with pathway as name
			//might want to thin this down to JUST the filename (and not pathway)
			FileAttribs myFileAttribs = new FileAttribs(pathway);

			//Zoe added this. Check if file is correct type. Return null if not.
			if(pathway.endsWith(".txt")==false) {
				myFileAttribs = null;
				return myFileAttribs;
			}
			
			while((line = reader.readLine()) != null){
				Line tempLine = new Line();
				
				//split line into an array of tokenized word Strings using whitespace as delimiters
				String[] tokenizedLine = line.split("\\s+");
				//NOTE: don't know what this considers whitespace, might try to count newlines and such
				//if so, fix !!!
				
				//loop through words in tokenizedLine array, strip punctuation and push into line obj
				for(int i = 0; i < tokenizedLine.length; i++){
					String tempWord = stripPunctuation(tokenizedLine[i]);
					
					//check if word was JUST whitespace post-punctuation strip
					if(tempWord != ""){
						tempLine.addWord(tempWord);	
					}
				}
				
				//line object completed, push to myFileAttribs
				myFileAttribs.addLine(tempLine);
			}
			
			return myFileAttribs;
			
		}catch(FileNotFoundException e){
			//couldnt open file with specificed pathway
			e.printStackTrace();
			return null;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		
		
		//close the reader
		finally{
			try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
	}
	
	
	
	//helper method to strip punctuation
	public String stripPunctuation(String word){
		
		//written in stages for easy modification/dev
		
		//this should remove JUST punctuation
		word = word.replaceAll("\\p{Punct}+", "");	
		//remove apostrophes
		word = word.replaceAll("’", "");
		
		//When punctuation is stripped, if the word was ONLY punctuation i.e. " !! "
		//then a blank word would be added to the line object.  instead, I have a way to check
		
		//checks to make sure at least one real character in string 
		if(word.matches(".*\\w.*")){
			//System.out.println("working");
			return word;
		}else{
			return "";
		}
	}	
}
