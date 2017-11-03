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
	public FileAttribs FileRead(String pathway){//pathway passed in
		
		//use pathway to get the file and validate that it works,
		//set up a reader
		
		//create
		
		//loop through lines of file
		//for each new line,
		
		
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
