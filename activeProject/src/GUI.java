
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
	private FileNameExtensionFilter textOnly;

	private JLabel currentFiles;
	private JLabel fileHistory1;
	private JLabel fileHistory2;
	private JLabel fileHistory3;

	private JButton clearHistory;
	private int numberOfUploads = 0;

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
	private JMenuItem guideItem;
	private JFrame guideFrame;
	private JPanel guidePanel;
	private JLabel guideText1;
	private JLabel guideText2;
	private JLabel guideText3;
	private JLabel guideText4;
	private String chosenPath;

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

		// Help option and dropdown items
		helpOption = new JMenu("Help");
		toolbar.add(helpOption); // Help added to toolbar
		aboutItem = new JMenuItem("About");
		helpOption.add(aboutItem);
		useGuide = new JMenuItem("File Analyzer Guide");
		helpOption.add(useGuide);

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
		currentFiles = new JLabel("Current files: ");
		// additional labels for file history
		fileHistory1 = new JLabel("");
		fileHistory2 = new JLabel("");
		fileHistory3 = new JLabel("");

		// Clear history button
		clearHistory = new JButton("Clear File History");

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
		filePanel.add(fileHistory1, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 5;
		filePanel.add(fileHistory2, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 6;
		filePanel.add(fileHistory3, panelLayout);
		panelLayout.gridx = 0;
		panelLayout.gridy = 7;
		filePanel.add(clearHistory, panelLayout);

		// User hits select file button
		uploadFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when select file button is clicked, view and select text file
				openFile = new JButton();
				selectFile = new JFileChooser();
				// allow text files only
				// textOnly = new FileNameExtensionFilter("Text files", "txt"); //text files
				// only
				// selectFile.setFileFilter(textOnly); //text only filter

				selectFile.setCurrentDirectory(new java.io.File("C:/Users/Zoe/Desktop")); // directory will be desktop
				selectFile.setDialogTitle("Choose File");
				selectFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // file chooser only shows
																						// directories and files

				if (selectFile.showOpenDialog(openFile) == JFileChooser.APPROVE_OPTION) { // user selects file
					currentFilePath = selectFile.getSelectedFile().getAbsolutePath();
					// TextFileAnalyzer.addVectorPath(selectFile.getSelectedFile().getAbsolutePath());
					// //prints exactly what the user clicks on
					analyzeFileButton.setEnabled(true); // allow user to hit Analyze!

					// update history - may change later
					//NEED TO FIX
					if (numberOfUploads == 0) {
						if ((!currentFilePath.equals(fileHistory2.getText())) && (!currentFilePath.equals(fileHistory3.getText()))) {
							fileHistory1.setText(currentFilePath);
							numberOfUploads = 1;
						}
					}
					 else if (numberOfUploads == 1) {
						if ((!currentFilePath.equals(fileHistory1.getText())) && (!currentFilePath.equals(fileHistory3.getText()))) {
							fileHistory2.setText(currentFilePath);
							numberOfUploads = 2;
						}
					}
					 else {
						if ((!currentFilePath.equals(fileHistory1.getText())) && (!currentFilePath.equals(fileHistory2.getText()))) {
							fileHistory3.setText(currentFilePath);
							numberOfUploads = 0;
						}
					 }
				}
					

				 else { // user hits cancel

				}
			
			}
		});

		// User hits select file button
		analyzeFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentFilePath != null) { // user has chosen at least one file path
					String userResults = AnalyzeAdder.addVectorPath(currentFilePath); // using the user's filepath,
																						// return string of analysis
					analysisResult = new JOptionPane(); // Create JOptionPane for popup
					analysisFrame = new JFrame(); // new frame for the pane
					analysisResult.showMessageDialog(analysisFrame, userResults); // display popup with the analysis
																					// results

				} else {
					// user hasn't uploaded file yet. analysis not possible.
				}
			}
		});

		//user hits clear history button
		clearHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset current file list
				fileHistory1.setText("");
				fileHistory2.setText("");
				fileHistory3.setText("");
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
				aboutText2 = new JLabel("Completed (day)/11/2017.");
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

		useGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				guideFrame = new JFrame("Using the Text File Analyzer");
				guidePanel = new JPanel(new GridBagLayout());
				GridBagConstraints aboutPanelLayout = new GridBagConstraints();
				/*
				 * //about text guideText1 = new JLabel("Text Files Analyzer"); guideText2 = new
				 * JLabel("Completed (day)/(month)/(year)."); guideText3 = new
				 * JLabel("The Text Files Analyzer produces text file statistics. Coded in Java."
				 * ); guideText4 = new
				 * JLabel("Contributors are Austin Peterson, Christopher Eich, Mark Buenaflor and Zoe Vasquez."
				 * );
				 */

				// list model will give us all the items in the list
				DefaultListModel helpListModel = new DefaultListModel();
				helpListModel.addElement("Uploading files");
				helpListModel.addElement("Analyzing files");
				helpListModel.addElement("Utilizing file history");

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
				// editing right now
				// add panel to frame
				guideFrame.add(guideSplitPane);

				helpList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						boolean isAdjusting = e.getValueIsAdjusting();
						if (isAdjusting == false) {
							if (helpList.getSelectedIndex() == 0) {
								infoText1.setText("To upload file, hit the Upload File button.");
								infoText2.setText("Browse your computer for a text file and select it, then hit OK.");
								infoText3.setText("");
							}
							if (helpList.getSelectedIndex() == 1) {
								infoText1.setText("To analyze files, first upload a text file.");
								infoText2.setText(
										"Then, hit the Analyze! button. It will popup a window giving you a full analysis of your text file.");
								infoText3.setText("");
							}
							if (helpList.getSelectedIndex() == 2) {
								infoText1.setText("The TextAnalyzer can analyze up to three files and provide ");
								infoText2.setText("a report for statistics of all three files together.");
								infoText3.setText(
										"To utilize this, upload more than one file, and then hit the Analyze! button.");
							}
						}
					}
				});
				/*
				 * aboutPanelLayout.gridx = 0; aboutPanelLayout.gridy = 1;
				 * aboutPanelLayout.insets = new Insets(10, 10, 10 ,10); //spacing between label
				 * aboutPanel.add(aboutText1, aboutPanelLayout); aboutPanelLayout.gridx = 0;
				 * aboutPanelLayout.gridy = 2; aboutPanel.add(aboutText2, aboutPanelLayout);
				 * aboutPanelLayout.gridx = 0; aboutPanelLayout.gridy = 3;
				 * aboutPanel.add(aboutText3, aboutPanelLayout); aboutPanelLayout.gridx = 0;
				 * aboutPanelLayout.gridy = 4; aboutPanel.add(aboutText4, aboutPanelLayout);
				 */
			}
		});
		/*
		 * openFile = new JButton(); selectFile = new JFileChooser(); //allow text files
		 * only textOnly = new FileNameExtensionFilter("Text files", "txt"); //text
		 * files only selectFile.setFileFilter(textOnly); //text only filter
		 * 
		 * selectFile.setCurrentDirectory(new java.io.File("C:/Users/Zoe/Desktop"));
		 * //directory will be desktop selectFile.setDialogTitle("Choose File");
		 * selectFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //file
		 * chooser only shows directories and files
		 * 
		 * if(selectFile.showOpenDialog(openFile) == JFileChooser.APPROVE_OPTION) {
		 * //user selects file
		 * System.out.println(selectFile.getSelectedFile().getAbsolutePath()); //prints
		 * exactly what the user clicks on } else { //user hits cancel
		 * 
		 * }
		 */
	}
}
