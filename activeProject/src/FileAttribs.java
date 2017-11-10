//Class to design object that can easily represent files
//that are evaluated/saved.
//a vector of lines is included in FileAttribs
//a Vector of (tokenized) words is included in a Line obj

//file statistics not held in this file, fileAnalysis should generate in real time
//only name and date are saved so that they may be serialized by FileIO

//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

//date object created

public class FileAttribs {
	
	//core attributes
	String name;
	String date;
	Vector<Line> lines;
	
	//constructor
	public FileAttribs(String name){
		this.name = name;
		
		//create date obj for File
		date = new SimpleDateFormat("MM/dd/yyyy @ HH:mm:ss").format(Calendar.getInstance().getTime());
		
		//allocate Vector
		lines = new Vector<Line>();
	}
	
	//Line population functions
	public void addLine(Line newLine){
		//push new line obj onto lines array
		lines.addElement(newLine);
	}
	
	//return stats of file (if applicable)
	
	public String getName(){
		return name;
	}
	
	public String getDate(){
		return date;
	}
	
	public int getSize(){
		return lines.size();
	}
	
	//passed index by FileAnalysis
	//return Line obj
	public Line getLine(int index){	
		return lines.elementAt(index);
	}
	
	//NOTE: WAY different from the isEmpty in Line class
	//this determines if there are NO lines in the files
	public boolean isEmpty(){
		if(lines.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	//debug stuff, prints all attributes
	//good example of how to iterate through the vector of Line data structures contained in obj
	//IMPORTANT: should use FileAttrib's getLine function to iterate through like this in FileAnalysis
	//the only thing that should be touching the Line objects is the FileAttrib object itself
	public void printFileAttribs(){
		System.out.println("name: " + name);
		System.out.println("date: " + date);
		
		for(int i = 0; i < lines.size(); i++){
			Line tempLine = lines.elementAt(i);
			Vector<String> tempWords = tempLine.getWords();
			
			for(int j = 0; j < tempWords.size(); j++){
				System.out.print(tempWords.elementAt(j)+ " ");
			}
			
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("# of lines: " + lines.size());
	}
}





