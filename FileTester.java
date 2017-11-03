//Written by Austin Peterson
//CSE360

//This is just a quick main method to test out file IO and analysis classes
//Designed to test the back end components of our file analyzer

public class FileTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//need to retrieve serialized file objects and push all into a data structure 
		//in any main we use :) -> NEED history array of File Objs
		
		//get size of historical Files
		
		//need FileIO obj to create File obj
		//need FileAnalysis obj to pass the File obj to for analysis
		//FileAnalysis obj will return specs to File obj
		
		FileIO myFileIO = new FileIO();
		myFileIO.FileRead("test.txt");
		
		//easy file testing
		FileAttribs myFile = new FileAttribs("AustinsFile");
		System.out.println(myFile.getDate());
		System.out.println(myFile.getName());
	}
}
