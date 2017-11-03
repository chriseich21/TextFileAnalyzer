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
	
	public boolean isEmpty(){
		if(lines.size() == 0){
			return true;
		}else{
			return false;
		}
	}
}





