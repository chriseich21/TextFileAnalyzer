
//Written by Zoe

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

	private JLabel currentFiles;
	private JLabel filesUploaded1;
	private JLabel filesUploaded2;
	private JLabel filesUploaded3;
	private JButton clearUploads;
	
	private JFrame historyFrame;
	private JPanel historyPanel;
	private String fileHistoryText = "";

	private int numberOfUploads = 0;
	private int uploadSpot = 0;

	private JButton analyzeFileButton;
	private String currentFilePath;
	private JFrame analysisFrame;
	private JOptionPane analysisResult;

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
	private JFrame guideFrame;
	private JPanel guidePanel;
	private String chosenPath;

	private JMenu historyOption;
	private JMenuItem seeHistory;
	private JMenuItem clearHistory;
	
	public GUI() {
		gui();
	}

	public void gui() {
		// set up program frame
		fileFrame = new JFrame("File Analyzer");
		fileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // User hits X button -> Close out

		// Menu bar.
		toolbar = new JMenuBar();
		fileFrame.setJMenuBar(toolbar);

		// Help option and dropdown items (about, user guide)
		helpOption = new JMenu("Help");
		toolbar.add(helpOption); // Help added to toolbar
		aboutItem = new JMenuItem("About");
		helpOption.add(aboutItem);
		useGuide = new JMenuItem("File Analyzer Guide");
		helpOption.add(useGuide);

		//History option and dropdown items.
		// File history option
		historyOption = new JMenu("History");
		toolbar.add(historyOption); //history added to toolbar
		seeHistory = new JMenuItem("See file history");
		historyOption.add(seeHistory);
		clearHistory = new JMenuItem("Clear history");
		historyOption.add(clearHistory);
		final JTextArea fileHistory1 = new JTextArea(10, 40); //text area for file history
		
		// panel.
		filePanel = new JPanel(new GridBagLayout());
		// filePanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints panelLayout = new GridBagConstraints();

		// welcome text
		welcomeText = new JLabel(
				"Welcome to the Text File Analyzer. Hit the button below to upload a text for analysis.");

		// file upload button
		uploadFileButton = new JButton("Upload File");

		// analyze file button
		analyzeFileButton = new JButton("Analyze!");
		analyzeFileButton.setEnabled(false); // user cannot hit Analyze! until file uploaded

		// Current files label
		currentFiles = new JLabel("Files uploaded: ");		
		
		//labels for files uploaded
		filesUploaded1 = new JLabel("");
		filesUploaded2 = new JLabel("");
		filesUploaded3 = new JLabel("");
		
		clearUploads = new JButton("Clear Uploads");
		clearUploads.setEnabled(false); 

		fileFrame.setVisible(true);
		fileFrame.setSize(700, 500);

		// add panel to frame
		fileFrame.add(filePanel);
		// add text to panel
		panelLayout.gridx = 0;
		panelLayout.gridy = 0;
		panelLayout.insets = new Insets(10, 10, 10, 10); // spacing between label and button
		filePanel.add(welcomeText, panelLayout);
		// add button to panel
		panelLayout.gridx = 0;
		panelLayout.gridy = 1;
		filePanel.add(uploadFileButton, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 2;
		filePanel.add(analyzeFileButton, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 3;
		filePanel.add(currentFiles, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 4;
		filePanel.add(filesUploaded1, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 5;
		filePanel.add(filesUploaded2, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 6;
		filePanel.add(filesUploaded3, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 7;
		filePanel.add(clearUploads, panelLayout);

		// User hits select file button
		uploadFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when select file button is clicked, view and select text file
				openFile = new JButton();
				
				selectFile = new JFileChooser();
				selectFile.setCurrentDirectory(new java.io.File("C:/Users/")); // directory will be desktop
				selectFile.setDialogTitle("Choose File");
				selectFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // file chooser only shows
																						// directories and files

				if (selectFile.showOpenDialog(openFile) == JFileChooser.APPROVE_OPTION) { // user selects file
					currentFilePath = selectFile.getSelectedFile().getAbsolutePath();
					analyzeFileButton.setEnabled(true); // allow user to hit Analyze!
					
					//list files uploaded
					if (uploadSpot == 0) {
						if ((!currentFilePath.equals(filesUploaded2.getText()))
								&& (!currentFilePath.equals(filesUploaded3.getText()))) {
							filesUploaded1.setText(currentFilePath);
							uploadSpot = 1;
							if(numberOfUploads < 3) { //update if user hasn't uploaded 3 files already
								numberOfUploads = 1;
							}
						}
					} else if (uploadSpot == 1) {
						if ((!currentFilePath.equals(filesUploaded1.getText()))
								&& (!currentFilePath.equals(filesUploaded3.getText()))) {
							filesUploaded2.setText(currentFilePath);
							uploadSpot = 2;
							if(numberOfUploads < 3) {
							numberOfUploads = 2;
							}
						}
					} else {
						if ((!currentFilePath.equals(filesUploaded1.getText()))
								&& (!currentFilePath.equals(filesUploaded2.getText()))) {
							filesUploaded3.setText(currentFilePath);
							numberOfUploads = 3;
						}
					}
					
					clearUploads.setEnabled(true); //user can now clear uploads
				}

				else { // user hits cancel

				}

			}
		});

		// User hits select file button
		analyzeFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentFilePath != null) { // user has chosen at least one file path
					String userResults = "";
					for(int i = 1; i<=numberOfUploads; i++) {
					//for multiple file functionality. Iterate until all uploads have had their results printed.
					if(i==1) {
						// modify string of analysis
						userResults = AnalyzeAdder.addVectorPath(filesUploaded1.getText()); // using the user's filepath,
					}
					if(i==2) {
						userResults = userResults + "\n" + AnalyzeAdder.addVectorPath(filesUploaded2.getText());
					}
					if(i==3) {
						userResults = userResults + "\n" +  AnalyzeAdder.addVectorPath(filesUploaded3.getText());
					}
					}
					
					if(numberOfUploads>1) { //only calculate averages if more than one file is involved
					//append a calculation of the average 
					userResults = AnalyzeAdder.appendAverage(userResults);
					}
					//reset average until next time the analyze button is clicked
					AnalyzeAdder.clearCurrentAverage();
					
					//modify history
					fileHistoryText = AnalyzeAdder.historyFileString;
					
					//create frame for results to be shown in
					analysisResult = new JOptionPane(); // Create JOptionPane for popup
					analysisFrame = new JFrame(); // new frame for the pane
					//display results in frame
					analysisResult.showMessageDialog(analysisFrame, userResults); 
					
				} else {
					// user hasn't uploaded file yet. analysis not possible.
				}
			}
		});

		// user hits clear uploads button
		clearUploads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reset current file list
				filesUploaded1.setText("");
				filesUploaded2.setText("");
				filesUploaded3.setText("");
				numberOfUploads = 0; //reset number of uploads
				uploadSpot = 0;
				currentFilePath = null; //no current file
				analyzeFileButton.setEnabled(false); //grey out analyze file button
				clearUploads.setEnabled(false); //grey out clear uploads
			}
		});
		// User hits help on toolbar
		helpOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				aboutFrame = new JFrame("About Text File Analyzer");
				aboutPanel = new JPanel(new GridBagLayout());
				GridBagConstraints aboutPanelLayout = new GridBagConstraints();
				// about text
				aboutText1 = new JLabel("Text Files Analyzer");
				aboutText2 = new JLabel("Completed 29/11/2017.");
				aboutText3 = new JLabel("The Text Files Analyzer produces text file statistics. Coded in Java.");
				aboutText4 = new JLabel(
						"Contributors are Austin Peterson, Christopher Eich, Mark Buenaflor and Zoe Vasquez.");

				aboutFrame.setVisible(true);
				aboutFrame.setSize(600, 200);

				// add panel to frame
				aboutFrame.add(aboutPanel);

				aboutPanelLayout.gridx = 0;
				aboutPanelLayout.gridy = 1;
				aboutPanelLayout.insets = new Insets(10, 10, 10, 10); // spacing between label
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
		
		seeHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//create frame for file history
			historyFrame = new JFrame("File History");			
			historyPanel = new JPanel();
			historyFrame.setVisible(true);
			historyFrame.setSize(600, 300);
			
			// add panel to frame
			historyFrame.add(historyPanel);
			
			//create file history text box and add scroll pane
			fileHistory1.setEditable(false); //user cannot edit file history
			JScrollPane historyScroll = new JScrollPane(fileHistory1);
			historyScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			if(fileHistoryText == "") { //no history yet
				fileHistory1.setText("No file history.");
			}
			else {
			fileHistory1.setText(fileHistoryText); //text should be set to current fileHistoryText
			}
			historyPanel.add(historyScroll); //include scroll pane in case file upload history is long
			}
		});
		
		clearHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			final JFrame clearFrame = new JFrame("Cleared History");			
			final JPanel clearPanel = new JPanel(new GridBagLayout());
			GridBagConstraints clearPanelLayout = new GridBagConstraints();
			final JLabel clearedText = new JLabel("History has been cleared."); //communicate to user
			
			clearFrame.setVisible(true);
			clearFrame.setSize(200, 200);
			
			// add panel to frame
			clearFrame.add(clearPanel);
			clearPanelLayout.gridx = 0;
			clearPanelLayout.gridy = 2;
			clearPanel.add(clearedText, clearPanelLayout);
			
			//reset historyFileString
			AnalyzeAdder.historyFileString = "";
			//reset fileHistoryText
			fileHistoryText = "";
			
			}
		});
		
		useGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				guideFrame = new JFrame("Using the Text File Analyzer");
				guidePanel = new JPanel(new GridBagLayout());
				GridBagConstraints aboutPanelLayout = new GridBagConstraints();

				// list model will give us all the items in the list
				DefaultListModel helpListModel = new DefaultListModel();
				helpListModel.addElement("Uploading files");
				helpListModel.addElement("Analyzing files");
				helpListModel.addElement("Analyzing multiple files");
				helpListModel.addElement("File history");

				// create the list for the items
				JList helpList = new JList(helpListModel);
				helpList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				helpList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

				JPanel infoBox = new JPanel();

				GridBagConstraints infoPanelLayout = new GridBagConstraints();
				infoPanelLayout.insets = new Insets(10, 10, 10, 10);
				JLabel infoText1 = new JLabel("");
				JLabel infoText2 = new JLabel("");
				JLabel infoText3 = new JLabel("");

				infoPanelLayout.gridx = 0;
				infoPanelLayout.gridy = 1;
				infoBox.add(infoText1, infoPanelLayout);
				infoPanelLayout.gridx = 0;
				infoPanelLayout.gridy = 2;
				infoBox.add(infoText2, infoPanelLayout);
				infoPanelLayout.gridx = 0;
				infoPanelLayout.gridy = 3;
				infoBox.add(infoText3, infoPanelLayout);

				JSplitPane guideSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, helpList, infoBox);
				guideSplitPane.setDividerLocation(150);

				guideFrame.setVisible(true);
				guideFrame.setSize(700, 200);
				// add panel to frame
				guideFrame.add(guideSplitPane);

				helpList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						boolean isAdjusting = e.getValueIsAdjusting();
						if (isAdjusting == false) {
							if (helpList.getSelectedIndex() == 0) {
								infoText1.setText("To upload file, hit the \"Upload File\" button.");
								infoText2.setText("Browse your computer for a text file and select it, then hit OK.");
								infoText3.setText("");
							}
							if (helpList.getSelectedIndex() == 1) {
								infoText1.setText("To analyze files, first upload a text file.");
								infoText2.setText(
										"Then, hit the \"Analyze!\" button. It will popup a window giving you a full analysis of your text file.");
								infoText3.setText("");
							}
							if (helpList.getSelectedIndex() == 2) {
								infoText1.setText("The TextAnalyzer can analyze up to three files and ");
								infoText2.setText(" provide a report for statistics of all three files together.");
								infoText3.setText(
										"To utilize this, upload more than one file, and then hit the \"Analyze!\" button.");
							}
							if (helpList.getSelectedIndex() == 3) {
								infoText1.setText("To view file history, click the history item on the toolbar ");
								infoText2.setText("and select \"See File History\".  ");
								infoText3.setText(
										"To clear it, select \"Clear History\". ");
							}
						}
					}
				});

			}
		});

	}
}
