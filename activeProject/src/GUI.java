//Written by Zoe

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.FileFilter;

public class GUI {
	private JFrame fileFrame;
	private JPanel filePanel;
	private JButton uploadFileButton;
	private JButton openFile;
	private JLabel welcomeText;
	private JFileChooser selectFile;
	private FileNameExtensionFilter textOnly;
	
	private JButton analyzeFileButton;
	private String currentFilePath;
	
	private JMenuBar toolbar;
	private JMenu helpOption;
	private JMenuItem aboutItem;
	private JFrame aboutFrame;
	private JPanel aboutPanel;
	private JLabel aboutText1;
	private JLabel aboutText2;
	private JLabel aboutText3;
	private JLabel aboutText4;
	private JMenuItem useGuide;
	private JMenuItem guideItem;
	private JFrame guideFrame;
	private JPanel guidePanel;
	private JLabel guideText1;
	private JLabel guideText2;
	private JLabel guideText3;
	private JLabel guideText4;
	private String chosenPath;
	
	public GUI()
	{
		gui();
	}
	
	public void gui() {
		//set up program frame
		fileFrame = new JFrame("File Analyzer");
		fileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //User hits X button -> Close out
		
		//Menu bar.
		toolbar = new JMenuBar();
		fileFrame.setJMenuBar(toolbar);
		
		//Help option and dropdown items
		helpOption = new JMenu("Help");
		toolbar.add(helpOption); //Help added to toolbar
		aboutItem = new JMenuItem("About");
		helpOption.add(aboutItem);
		useGuide = new JMenuItem("File Analyzer Guide");
		helpOption.add(useGuide);
		
		//panel. 
		filePanel = new JPanel(new GridBagLayout());
		//filePanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints panelLayout = new GridBagConstraints();
		
		//welcome text
		welcomeText = new JLabel("Welcome to the Text File Analyzer. Hit the button below to upload a text for analysis.");
		
		//file upload button
		uploadFileButton = new JButton("Upload File");
	
		//analyze file button
		analyzeFileButton = new JButton("Analyze!");
		
		fileFrame.setVisible(true);
		fileFrame.setSize(700, 500);
		
		//add panel to frame
		fileFrame.add(filePanel);
		//add text to panel
		panelLayout.gridx = 0;
		panelLayout.gridy = 0;
		panelLayout.insets = new Insets(10, 10, 10 ,10); //spacing between label and button
		filePanel.add(welcomeText, panelLayout);
		//add button to panel
		panelLayout.gridx = 0;
		panelLayout.gridy = 1;
		filePanel.add(uploadFileButton, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 2;
		filePanel.add(analyzeFileButton, panelLayout);
		
		//User hits select file button
		uploadFileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//when select file button is clicked, view and select text file
				openFile = new JButton();
				selectFile = new JFileChooser();
				//allow text files only
				//textOnly = new FileNameExtensionFilter("Text files", "txt"); //text files only
				//selectFile.setFileFilter(textOnly); //text only filter
				
				selectFile.setCurrentDirectory(new java.io.File("C:/Users/Zoe/Desktop")); //directory will be desktop
				selectFile.setDialogTitle("Choose File");
				selectFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //file chooser only shows directories and files
				
				if(selectFile.showOpenDialog(openFile) == JFileChooser.APPROVE_OPTION) { //user selects file
					currentFilePath = selectFile.getSelectedFile().getAbsolutePath();
					//TextFileAnalyzer.addVectorPath(selectFile.getSelectedFile().getAbsolutePath());   //prints exactly what the user clicks on
				}
				else { //user hits cancel
					
				}
			}
		});
		
		//User hits select file button
		analyzeFileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(currentFilePath != null) { //user has chosen at least one file path
					TextFileAnalyzer.addVectorPath(currentFilePath);   //prints exactly what the user clicks on
				}
				else { //user hasn't uploaded file yet. analysis not possible.
					
				}
			}
		});
		
		//User hits help on toolbar
		helpOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				aboutFrame = new JFrame("About Text File Analyzer");
				aboutPanel = new JPanel(new GridBagLayout());
				GridBagConstraints aboutPanelLayout = new GridBagConstraints();
				//about text
				aboutText1 = new JLabel("Text Files Analyzer");
				aboutText2 = new JLabel("Completed (day)/(month)/(year).");
				aboutText3 = new JLabel("The Text Files Analyzer produces text file statistics. Coded in Java.");
				aboutText4 = new JLabel("Contributors are Austin Peterson, Christopher Eich, Mark Buenaflor and Zoe Vasquez.");
				
				aboutFrame.setVisible(true);
				aboutFrame.setSize(600, 200);
				
				//add panel to frame
				aboutFrame.add(aboutPanel);
				
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 1;
				aboutPanelLayout.insets = new Insets(10, 10, 10 ,10); //spacing between label
				aboutPanel.add(aboutText1, aboutPanelLayout);
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 2;
				aboutPanel.add(aboutText2, aboutPanelLayout);
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 3;
				aboutPanel.add(aboutText3, aboutPanelLayout);
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 4;
				aboutPanel.add(aboutText4, aboutPanelLayout);
				
			}
		});
		
		useGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guideFrame = new JFrame("Using the Text File Analyzer");
				guidePanel = new JPanel(new GridBagLayout());
				GridBagConstraints aboutPanelLayout = new GridBagConstraints();
				//about text
				guideText1 = new JLabel("Text Files Analyzer");
				guideText2 = new JLabel("Completed (day)/(month)/(year).");
				guideText3 = new JLabel("The Text Files Analyzer produces text file statistics. Coded in Java.");
				guideText4 = new JLabel("Contributors are Austin Peterson, Christopher Eich, Mark Buenaflor and Zoe Vasquez.");
				
				guideFrame.setVisible(true);
				guideFrame.setSize(600, 200);
				/* editing right now
				//add panel to frame
				aboutFrame.add(aboutPanel);
				
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 1;
				aboutPanelLayout.insets = new Insets(10, 10, 10 ,10); //spacing between label
				aboutPanel.add(aboutText1, aboutPanelLayout);
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 2;
				aboutPanel.add(aboutText2, aboutPanelLayout);
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 3;
				aboutPanel.add(aboutText3, aboutPanelLayout);
				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 4;
				aboutPanel.add(aboutText4, aboutPanelLayout);
				*/
			}
		});
		/*
		openFile = new JButton();
		selectFile = new JFileChooser();
		//allow text files only
		textOnly = new FileNameExtensionFilter("Text files", "txt"); //text files only
		selectFile.setFileFilter(textOnly); //text only filter
		
		selectFile.setCurrentDirectory(new java.io.File("C:/Users/Zoe/Desktop")); //directory will be desktop
		selectFile.setDialogTitle("Choose File");
		selectFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //file chooser only shows directories and files
		
		if(selectFile.showOpenDialog(openFile) == JFileChooser.APPROVE_OPTION) { //user selects file
			System.out.println(selectFile.getSelectedFile().getAbsolutePath()); //prints exactly what the user clicks on
		}
		else { //user hits cancel
			
		}
		*/
	}
}
