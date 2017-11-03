//Austin Peterson
//this is the ONLY class that should touch the file to be read
//this is the ONLY class that should touch the serialized historical files

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class FileIO {

	//read in file given pathway (check validity)
	//return a FileAttribs object
	//this method is ugly and I don't know how pathways work
	//note: filename String passed in should include the pathway?
	public FileAttribs FileRead(String filename){
		
		//FileReader
		try{
			//create reader with the filename
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			//create the new file obj
			FileAttribs myFile = new FileAttribs(filename);
			
			String line;//placeholder for line being read
			
			//read lines while not end of file
			while((line = bufferedReader.readLine()) != null){
				//print each line
				System.out.println(line);
				//tokenize the String line into individual words and push to line obj
				//new line obj each time around
				
				
				
				
			}
			
			
			
			
		}catch(FileNotFoundException e){
			System.out.println("could not find file.");
			//might want more logic here to help return something useful
			//(like an empty FileAttribs obj)
			return null;
		} catch(IOException e) {
			System.out.println("IOException, broken.");
			//this shouldn't happen, done to appease the:
			//line = bufferedReader.readLine()
			return null;
		}
		
		//return the parsed file
		return null;
	}
	
	//read old serialized files from history and return
	//(should return FULL objects, even though we'll probably only use name/date)
	public FileAttribs[] HistoryRead(){
		
		return null;
	}
	
	//should delete all serialized historical FileAttribs objects
	public void clearHistory(){
		
	}
	
	//serializes the new FileAttribs object to whereever we end up storing them
	public void commitHistory(){
		//might need to call HistoryRead() in order to get old serializations, and
		//wipe the whole file and reserialize all objects (this will let use kill dupe FileAttrib objs)
	}
	
}
