// File: SorcerersCave.java
// Due Date: Feb 22, 2015
// Author: Revani Govender
// This class sets up the GUI and runs the search and sort functions for the program

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class SorcerersCave extends JFrame {
	
	static final long serialVersionUID = 123L;
	JTextArea jTextA = new JTextArea ();
	JTextArea displayFile = new JTextArea();
	JComboBox <String> jComboBoxSearch;
	JComboBox <String> jComboBoxSort;
	JComboBox <String> jComboBoxSortByCreature;
	JComboBox<String> jComboBoxSortByTreasure;
	JComboBox<String> jComboBoxSortByArtifact;
	JTextField jTextF;
	Cave cave = new Cave();
	JPanel buttons;
	JPanel displayArea;
	JPanel displayArea2;
	JSplitPane splitPane;
	JPanel runDisplay = new JPanel();
//	JProgressBar progressBar = new JProgressBar();
//	JButton jButtonStop = new JButton( "Stop");
//	JButton jButtonCancel = new JButton( "Cancel");
//	boolean goFlag = true; 
//	boolean noKillFlag = true;
	
	DefaultMutableTreeNode top = new DefaultMutableTreeNode("Sorcerers Cave");
 	JTree tree = new JTree(top);
 	
 	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
	DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();

	

	 public SorcerersCave () {
	        setTitle ("Sorcerer's Cave");
	        setSize (600, 300);
	        setMinimumSize(new Dimension(1000, 700));
	        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        setVisible (true);
	        setLocationRelativeTo(null);
	        
	        JScrollPane jScrollP = new JScrollPane (jTextA); //main text area
	        JScrollPane jScrollDisplay = new JScrollPane(displayFile); //secondary display
//	        	add (jScrollP, BorderLayout.EAST);
	        
	        	
	        JScrollPane jScrollRun = new JScrollPane(runDisplay); //secondary display
	        
	        JScrollPane jScrollDummy = new JScrollPane(tree);
	        jScrollDummy.setMaximumSize((new Dimension(300, 100)));
	        jScrollDummy.setMinimumSize((new Dimension(300, 100)));
	        jScrollP.setMaximumSize((new Dimension(600, 100)));
	        jScrollP.setMinimumSize((new Dimension(300, 100)));

	        JSplitPane hpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jScrollDummy, jScrollP);
	        hpane.setResizeWeight(0);

	        jScrollRun.setMinimumSize((new Dimension (700, 700)));
	        JSplitPane vpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, hpane, jScrollRun);	
	        vpane.setResizeWeight(0);

	        	add(vpane, BorderLayout.CENTER);

	        //main buttons
	        JButton jButtonOpen = new JButton ("Open");
	        JButton jButtonDisplay = new JButton ("Display"); 
	        JButton jButtonSearch = new JButton ("Search");
	   
	        
	        JLabel jLabelSearch = new JLabel ("Search target");
	        JLabel jLabelSort = new JLabel ("     Sort     ");
	        
	        //text field for searches
	        jTextF = new JTextField (10);
	        
	        jComboBoxSort = new JComboBox<String>();
	        	jComboBoxSort.addItem("Sort By");
	        	jComboBoxSort.addItem("Creature");
	        	jComboBoxSort.addItem("Treasure");
	        	jComboBoxSort.addItem("Artifact");
	        
	        jComboBoxSortByCreature = new JComboBox<String>();
	        	jComboBoxSortByCreature.addItem("Name");
	        	jComboBoxSortByCreature.addItem("Age");
	        	jComboBoxSortByCreature.addItem("Height");
	        	jComboBoxSortByCreature.addItem("Weight");
	        	jComboBoxSortByCreature.addItem("Empathy");
	        	jComboBoxSortByCreature.addItem("Fear");
	        	jComboBoxSortByCreature.addItem("Carrying Capacity");
	        	
			    jComboBoxSortByCreature.setVisible(false);
			    
			jComboBoxSortByTreasure = new JComboBox<String>();
				jComboBoxSortByTreasure.addItem("Weight");
				jComboBoxSortByTreasure.addItem("Value");

				jComboBoxSortByTreasure.setVisible(false);
				
			jComboBoxSortByArtifact = new JComboBox<String>();
				jComboBoxSortByArtifact.addItem("Name");
				jComboBoxSortByArtifact.addItem("Type");
				
				jComboBoxSortByArtifact.setVisible(false);
	        
	        //combo box for searches
	        jComboBoxSearch = new JComboBox <String> ();
	        	jComboBoxSearch.addItem("Search By");
		        jComboBoxSearch.addItem ("Index");
		        jComboBoxSearch.addItem ("Type");
		        jComboBoxSearch.addItem ("Name");
		        jComboBoxSearch.addItem ("Creature");
		        jComboBoxSearch.addItem ("Party");
		        jComboBoxSearch.addItem ("Artifact");
		        jComboBoxSearch.addItem ("Treasure");
		        
		    //check box to display original document    
		    final JCheckBox jCheckBox = new JCheckBox("Original Document");
		    
		    
		    
		  //Where the tree is initialized:
	        tree.getSelectionModel().setSelectionMode
	                (TreeSelectionModel.SINGLE_TREE_SELECTION);   
		    
		    //panel to hold buttons
	        JPanel panel = new JPanel();
//	        	panel.setLayout(new GridLayout(7 , 0));
	        	panel.setPreferredSize(new Dimension(160,100));
		        panel.add(jButtonOpen);
		        panel.add (jButtonDisplay);
		        panel.add(jLabelSort);
		        panel.add(jComboBoxSort);
		        panel.add(jComboBoxSortByCreature);
		        panel.add(jComboBoxSortByTreasure);
		        panel.add(jComboBoxSortByArtifact);
		        panel.add (jLabelSearch);
		        panel.add (jTextF);
		        panel.add (jComboBoxSearch);
		        panel.add(jButtonSearch);
		        panel.add(jCheckBox);
		        panel.setBackground(Color.LIGHT_GRAY);
		    
	        
	        add (panel, BorderLayout.WEST);
	        
	        //new frame for original document
	        final JFrame newFrame = new JFrame();
	        	newFrame.setSize(400, 400);
	        	newFrame.add(jScrollDisplay);
	        	newFrame.setTitle("Original Document");
	        	newFrame.setVisible(false);
	   
	        validate();
	        
	  
   
       
	        
	        
	        //action listeners for GUI elements
	        
	        jCheckBox.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if (jCheckBox.isSelected()){
						newFrame.setVisible(true);
					}
					else{
						newFrame.setVisible(false);
					}
					
				}
	        	
	        }
	        
	        );
	        
	        jButtonOpen.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent event) {
						top.removeAllChildren();
					 	model.reload(top);
						try {
							readFile();
						} catch (FileNotFoundException e) {
							System.out.println("File not found");
						}
							
						}//end Required Method
	        	}
	        );
	        
	        jButtonDisplay.addActionListener (new ActionListener () {
	        		public void actionPerformed (ActionEvent e) {
	        			displayCave ();
	        		} // end required method
	        } // end local definition of inner class
      
	        		); // the anonymous inner class
        
	        
	        jComboBoxSort.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					String string = (String) jComboBoxSort.getSelectedItem();
					
					if ( string == "Creature"){
						jComboBoxSortByTreasure.setVisible(false);
						jComboBoxSortByArtifact.setVisible(false);
						jComboBoxSortByCreature.setVisible(true);		
						
					}
					
					if (string == "Treasure"){
						jComboBoxSortByCreature.setVisible(false);
						jComboBoxSortByArtifact.setVisible(false);
						jComboBoxSortByTreasure.setVisible(true);
					}
					
					if (string == "Artifact"){
						jComboBoxSortByCreature.setVisible(false);
						jComboBoxSortByArtifact.setVisible(true);
						jComboBoxSortByTreasure.setVisible(false);
					}
					
				}//end required method
	        	
	        }//end combosort method
	        
	        		);
	        
	        jComboBoxSortByCreature.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					String selection = (String) jComboBoxSortByCreature.getSelectedItem();
					sortCreatures(selection);
					
				}
	        	
	        });
	        
	        jComboBoxSortByTreasure.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
				String selection = (String) jComboBoxSortByTreasure.getSelectedItem();
				sortTreasures(selection);
				
			}
        	
        });
	        
	        jComboBoxSortByArtifact.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e) {
					String selection = (String) jComboBoxSortByArtifact.getSelectedItem();
					sortArtifacts(selection);
					
				}
	        	
	        });
	        	
	        
	        
	        
	        jButtonSearch.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                	int length = jTextF.getText().trim().length();
                	
                	if (length >2){
                		jTextA.append("You searched for: " + jTextF.getText() + " in "
                					+ jComboBoxSearch.getSelectedItem() + "\n");
                		search ((String)(jComboBoxSearch.getSelectedItem()), jTextF.getText().trim());
                	}
                	else{
                		jTextA.append("Please enter more than 2 characters, \n"
                				+ "or the number of results will be overwhelming \n");
                	}
                		
                } // end required method
            } // end local definition of inner class
        ); // the anonymous inner class
	        
	        
	      
	
	      //Listen for when the selection changes.
	        tree.addTreeSelectionListener(new TreeSelectionListener(){

				@Override
				public void valueChanged(TreeSelectionEvent e) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                           tree.getLastSelectedPathComponent();

				        if (node == null) return;
			
				        Object object = tree.getLastSelectedPathComponent();
				        DefaultMutableTreeNode show = (DefaultMutableTreeNode) object;
				        String selection = (String) show.getUserObject();
				        
				        jTextA.setText(null);

				        try{
				        if(selection.equals("Sorcerers Cave")){
			        		top.removeAllChildren();
				        	displayCave();
				        }
   
				        for(Party party: cave.parties){
				        	DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) show.getParent();
				        	
				        	if(selection.equals(party.getName())){
				        		jTextA.append("" + party);
			    				jTextA.append("\n");
				        	}
				        	for(Creature creature: party.members){
				        		
					        	if(selection.equals(creature.getName())){
					        		jTextA.append("" + creature.attributesToString());
				    				jTextA.append("\n");
					        	}
					        	
					        	for(Treasure treasure: creature.treasures){
					        		if(show.isLeaf()){
					        			DefaultMutableTreeNode grandParentNode = (DefaultMutableTreeNode) parentNode.getParent();
							        	String grandParentString = (String) grandParentNode.getUserObject();
							        	
						        		if (treasure.getType().contains(selection)
						        				&&grandParentString.equals(creature.getName())){
						        			jTextA.append("" + treasure.attributesToString());
						    				jTextA.append("\n");
						        			
						        		}
					        		}
					        	}
					        	
					        	for(Artifact artifact: creature.artifacts){
					        		if(show.isLeaf()){
					        			DefaultMutableTreeNode grandParentNode = (DefaultMutableTreeNode) parentNode.getParent();
							        	String grandParentString = (String) grandParentNode.getUserObject();
							        	
						        		if (artifact.getName().contains(selection)
						        				&&grandParentString.equals(creature.getName())){
						        			jTextA.append("" + artifact.attributesToString());
						    				jTextA.append("\n");
						        		}
					        		}
					        	}
					        	
					        	for(Job job: creature.jobs){
					        		if(show.isLeaf()){
					        			DefaultMutableTreeNode grandParentNode = (DefaultMutableTreeNode) parentNode.getParent();
							        	String grandParentString = (String) grandParentNode.getUserObject();
							        	
						        		if (job.getName().contains(selection)
						        				&&grandParentString.equals(creature.getName())){
						        			jTextA.append("" + job.attributesToString());
						    				jTextA.append("\n");
						        		}
					        		}
					        	}
					        	
				        	}
				        }
				        
				        if (selection.equals("Creatures")){
				        	DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) show.getParent();
				        	String parentString = (String) parentNode.getUserObject();
				        	for(Party party: cave.parties){
				        		if(party.getName().contains(parentString)){
				        			jTextA.append("" + party);
				    				jTextA.append("\n");
				    			}
				        	}
				        }
				        
				        if (selection.equals("Artifacts")){
				        	DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) show.getParent();
				        	String parentString = (String) parentNode.getUserObject();
				        	for(Party party: cave.parties){
					        	for(Creature creature: party.members){
					        		for(Artifact artifact: creature.artifacts){
					        			if(creature.getName().contains(parentString)){
					        				jTextA.append("" + artifact.attributesToString());
					       				 	jTextA.append("\n");
					        			}
					        		}
					        	}      	
				        	}        
				        }
				        
				        if (selection.equals("Treasures")){
				        	DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) show.getParent();
				        	String parentString = (String) parentNode.getUserObject();
				        	for(Party party: cave.parties){
					        	for(Creature creature: party.members){
					        		for(Treasure treasure: creature.treasures){
					       			 	if(creature.getName().contains(parentString)){
					       			 		jTextA.append("" + treasure.attributesToString());
					       			 		jTextA.append("\n");
					       			 	}
					        		}
					        	}     	
				        	}
				        
				        }
				        
				        if (selection.equals("Jobs")){
				        	DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) show.getParent();
				        	String parentString = (String) parentNode.getUserObject();
				        	for(Party party: cave.parties){
					        	for(Creature creature: party.members){
					        		for(Job jobs: creature.jobs){
					       			 	if(creature.getName().contains(parentString)){
					       			 		jTextA.append("" + jobs.attributesToString());
					       			 		jTextA.append("\n");
					       			 	}
					        		}
					        	}     	
				        	}
				        
				        }
				        
				        if (selection.equals("Free Stuff")){
				        	if (show.children()!=null){
				        	
				        	for(Creature creatures: cave.freeCreature){
				        		jTextA.append("" + creatures.attributesToString());
		       			 		jTextA.append("\n");
							}
							for(Treasure treasures: cave.freeTreasure){
								jTextA.append("" + treasures.attributesToString());
		       			 		jTextA.append("\n");
							}
							for(Artifact artifacts: cave.freeArtifact){
								jTextA.append("" + artifacts.attributesToString());
		       			 		jTextA.append("\n");
							}
				        	}
				        	
				        }
				        
				        if (selection.equals("Free Creatures") ){
				        	for(Creature creatures: cave.freeCreature){
				        		jTextA.append("" + creatures.attributesToString());
		       			 		jTextA.append("\n");
							}
				        }
				        
				        if (selection.equals("Free Treasures") ){
							for(Treasure treasures: cave.freeTreasure){
					        	jTextA.append("" + treasures.attributesToString());
		       			 		jTextA.append("\n");
							}
				        }

					    if (selection.equals("Free Artifacts") ){
							for(Artifact artifacts: cave.freeArtifact){
						    	jTextA.append("" + artifacts.attributesToString());
		       			 		jTextA.append("\n");
							}   	
					    }
					    if(show.isLeaf()){	
					    	for (Creature creature: cave.freeCreature){	    	
					    		if (creature.getName().contains(selection)){
					    			jTextA.append("" + creature.attributesToString());
					       	 		jTextA.append("\n");
					    		}
						    }
					        		
					    	for(Treasure treasure: cave.freeTreasure)
					    		if (treasure.getType().contains(selection)){
					    			jTextA.append("" + treasure.attributesToString());
					        		jTextA.append("\n");
					     		}
			        		}
					    for(Artifact artifact: cave.freeArtifact){
					    	if (artifact.getName().contains(selection)){
				    			jTextA.append("" + artifact.attributesToString());
		       			 		jTextA.append("\n");
		       			 		}    
					    	}					    		
					    }	
					catch(NullPointerException error){
						
					}
				}
				
	        });

	        
	   } // end no-parameter constructor  

      
	public  void createNodes() {
		DefaultMutableTreeNode party = null;
		DefaultMutableTreeNode creatureTop = null;
		DefaultMutableTreeNode creature = null;
		DefaultMutableTreeNode treasureTop = null;
		DefaultMutableTreeNode artifactTop = null;
		DefaultMutableTreeNode jobTop = null;
		DefaultMutableTreeNode freeItemsTop = null;
		DefaultMutableTreeNode freeCreaturesTop = null;
		DefaultMutableTreeNode freeTreasuresTop = null;
		DefaultMutableTreeNode freeArtifactsTop = null;

		
		for (Party p: cave.parties) {
            top.add(party = new DefaultMutableTreeNode(p.getName()));
            party.add(creatureTop = new DefaultMutableTreeNode("Creatures"));
            for(Creature c: p.members){
            	creatureTop.add(creature = new DefaultMutableTreeNode(c.getName()));
            	if (c.getTreasures().size() != 0){
            		creature.add(treasureTop = new DefaultMutableTreeNode("Treasures"));
            		for(Treasure t: c.getTreasures()){
            			treasureTop.add(new DefaultMutableTreeNode(t.getType()));
            		}
            	} 
            	if(c.getArtifacts().size() != 0){
            		creature.add(artifactTop = new DefaultMutableTreeNode("Artifacts"));
            		for(Artifact a: c.getArtifacts()){
                		artifactTop.add(new DefaultMutableTreeNode(a.getName()));
                	}
            	}
            	
            	if(c.getJobs().size()!=0){
            		creature.add(jobTop = new DefaultMutableTreeNode("Jobs"));
	            	for(Job j: c.getJobs()){
	            		jobTop.add(new DefaultMutableTreeNode(j.getName()));
	            	}
            	}

            	
            	
            }
			
		
		}
		top.add(freeItemsTop = new DefaultMutableTreeNode("Free Stuff"));
			for(Creature creatures: cave.freeCreature){
				freeItemsTop.add(freeCreaturesTop = new DefaultMutableTreeNode("Free Creatures"));
				freeCreaturesTop.add(new DefaultMutableTreeNode(creatures.getName()));
			}
			for(Treasure treasures: cave.freeTreasure){
				freeItemsTop.add(freeTreasuresTop = new DefaultMutableTreeNode("Free Treasures"));
				freeTreasuresTop.add(new DefaultMutableTreeNode(treasures.getType()));
			}
			for(Artifact artifacts: cave.freeArtifact){
				freeItemsTop.add(freeArtifactsTop = new DefaultMutableTreeNode("Free Artifacts"));
				freeArtifactsTop.add(new DefaultMutableTreeNode(artifacts.getName()));
			}
		
	}

			public void sortCreatures(final String selection){
        		jTextA.setText(null);
        		top.removeAllChildren();
        	
        		
        		for(Party party: cave.parties){
//        			for(Creature creature: party.getPartyMembers()){
        				Collections.sort(party.getPartyMembers(), new Comparator<Creature>(){
        				public int compare(Creature creature1, Creature creature2){
							  	switch(selection){
						  		case "Name":
						  			return creature1.getName().compareTo(creature2.getName());
						  		case "Age":
						  			return Double.compare(creature1.getAge(), creature2.getAge());
						  		case "Height":
						  			return Double.compare(creature1.getHeight(), creature2.getHeight());
						  		case "Weight":
						  			return Double.compare(creature1.getWeight(), creature2.getWeight());
						  		case "Empathy":
						  			return Double.compare(creature1.getEmpathy(), creature2.getEmpathy());
						  		case "Fear":
						  			return Double.compare(creature1.getFear(), creature2.getFear());
						  		case "Carrying Capacity":
						  			return Double.compare(creature1.getCapacity(), creature2.getCapacity());
							  	}//end switch
        				
							return 0;
        					}//end compare
        					}//end collections
        				);
        		}//end party for
        	
			  	displayCave();
	        	
	    }
        	
        	public void sortTreasures(final String selection){
        		jTextA.setText(null);
        		top.removeAllChildren();

        		for (Party party: cave.getParties()){
        			for(Creature creature: party.getPartyMembers()){
//        				for (Treasure treasure: creature.getTreasures()){
        				
        			Collections.sort(creature.getTreasures(), new Comparator<Treasure>(){
		        		public int compare(Treasure treasure1, Treasure treasure2){
		        		switch(selection){
					  		case "Weight":
					  			return Double.compare(treasure1.getWeight(), treasure2.getWeight());
					  		case "Value":
					  			return Double.compare(treasure1.getValue(), treasure2.getValue());
				  			
		        		}//end switch
				
		        		return 0;
		        		}//end compare
        				}//end collections
        					);

        			}//end creature for
        		}//end party for

        		displayCave();
        			
	
        	}//end sortTreasure
        	
        	public void sortArtifacts(final String selection){
        		jTextA.setText(null);
        		top.removeAllChildren();

        		for (Party party: cave.getParties()){
        			for(Creature creature: party.getPartyMembers()){
//        				for (Treasure treasure: creature.getTreasures()){
        				
        			Collections.sort(creature.getArtifacts(), new Comparator<Artifact>(){
		        		public int compare(Artifact artifact1, Artifact artifact2){
		        		switch(selection){
					  		case "Name":
					  			return artifact1.getName().compareTo(artifact2.getName());
					  			
					  		case "Type":
					  			return artifact1.getType().compareTo(artifact2.getType());
				  			
		        		}//end switch
				
				return 0;
        		}//end compare
        			}//end collections
        					);
//        				}//end treasure for
        			}//end creature for
        		}//end party for

        		displayCave();
        			
	
        	}//end sortArtifact


		/*
	 	 * Display the cave and its attributes
	 	 */
		public void displayCave () {
			 	jTextA.append ("" + cave);

			 	createNodes();
			 	model.reload(top);

		    } // end method readFile
		
		
			/*
			 * Search - switches to methods for searching
			 */
		  public void search (String type, String target) {
			  jTextA.setText(null);
			  if (target.matches("[a-z].*$")){
				  target = target.substring(0, 1).toUpperCase() + target.substring(1);
			  }
			  	switch(type){
			  		case "Name":
			  			searchByName(target);
			  			break;
			  		case "Type":
			  			searchByType(target);
			  			break;
			  		case "Index":
			  			searchByIndex(target);
			  			break;
			  		case "Party":
			  			searchByParty(target);
			  			break;
			  		case "Creature":
			  			searchByCreature(target);
			  			break;
			  		case "Artifact":
			  			searchByArtifact(target);
			  			break;
			  		case "Treasure":
			  			searchByTreasure(target);
			  			break;
			  	
			  	}
		    } // end method readFile
		  
		/**
		 * searchBy methods - all take in search target as parameter to conduct search
		 * @param target
		 */
	 private void searchByCreature(String target) {
		 jTextA.append("Search Creatures \n");
		 for(Creature creature: cave.creatures){
				if(creature.attributesToString().contains(target)){
					jTextA.append("" + creature.attributesToString());
					jTextA.append("\n");
				}
			}
		
		}//end searchByCreature
			
			


	private void searchByParty(String target) {
		jTextA.append("Search Parties \n");
		for(Party party: cave.parties){
			if(party.toString().contains(target)){
				jTextA.append("" + party);
				jTextA.append("\n");
			}
		}
			
	}//end searchByParty

	private void searchByIndex(String target) {
			try{
				int intTarget = Integer.parseInt(target);
					
				for(Artifact artifact: cave.artifacts){
					if(artifact.getIndex() == intTarget){
						jTextA.append("" + artifact.attributesToString());
						jTextA.append("\n");
					}
				}
				
				for(Treasure treasure: cave.treasures){
					if(treasure.getIndex() == intTarget){
						jTextA.append("" + treasure.attributesToString());
						jTextA.append("\n");
					}
				}
				for(Creature creature: cave.creatures){
					if(creature.getIndex() == intTarget){
						jTextA.append("" + creature.attributesToString());
						jTextA.append("\n");
					}
				}
				
				for(Party party: cave.parties){
					if(party.getIndex() == intTarget){
						jTextA.append("" + party.toString());
					}
				}
				}
			catch(NumberFormatException e){
				jTextA.append("Please enter an integer for Index searches \n");
			}
			
		}//end searchByString

	private void searchByArtifact(String target) {
		jTextA.append("Search Artifacts \n");
		for(Artifact artifact: cave.artifacts){
			 if(artifact.attributesToString().contains(target)){
				 jTextA.append("" + artifact.attributesToString());
				 jTextA.append("\n");
			 }
		 }
		
	}//end searchByArtifact

	private void searchByTreasure(String target) {
		jTextA.append("Search Treasures \n");
		for(Treasure treasure: cave.treasures){
			if(treasure.attributesToString().contains(target)){
				jTextA.append("" + treasure.attributesToString());
				jTextA.append("\n");
			}
		}
		
	}//end searchByTreasure

	private void searchByType(String target) {
		for(Artifact artifact: cave.artifacts){
			if(artifact.getType().contains(target)){
				jTextA.append("Artifact: " + artifact.getType() + "\n    Name: " 
																+artifact.getName()
																+ "\n    Index: "
																+ artifact.getIndex());
				jTextA.append("\n");
			}
		}
		
		for(Treasure treasure: cave.treasures){
			if(treasure.getType().contains(target)){
				jTextA.append("Treasure: " + treasure.getType() + "\n    name: " 
																+treasure.getName()													+ "\n    Index: "
																+ "\n    Index: "
																+ treasure.getIndex());
				jTextA.append("\n");
			}
		}
		for(Creature creature: cave.creatures){
			if(creature.getType().contains(target)){
				jTextA.append("Creature: " + creature.getType() +"\n    name: " 
																+ creature.getName()
																+ "\n    Index: "
																+ creature.getIndex());

				jTextA.append("\n");
			}
		}
			
	}//end searchByType

	private void searchByName(String target) {
		for(Artifact artifact: cave.artifacts){
			if(artifact.getName().contains(target)){
				jTextA.append("" + artifact.attributesToString());
				jTextA.append("\n");
			}
		}
		for(Creature creature: cave.creatures){
			if(creature.getName().contains(target)){
				jTextA.append("" + creature.attributesToString());
				jTextA.append("\n");
			}
		}
		
			for(Party parties: cave.parties){
				if(parties.getName().contains(target)){
					jTextA.append("" + parties.toString());
					jTextA.append("\n");
				}
			}
			
	}//end searchByName

	/**
	 * get file to read
	 * @return
	 */
	public File getFile(){
		 
		 	File fileChoice = null;
			JFileChooser chooser = new JFileChooser(".");
			
			FileNameExtensionFilter filter;
			filter = new FileNameExtensionFilter("txt", "txt");
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				fileChoice = chooser.getSelectedFile();
				jTextA.append("File Chosen: " + fileChoice.getName() + "\n");
			}//end if
			else if(returnVal == JFileChooser.CANCEL_OPTION){
				jTextA.append("Cancel was selected\n");
				return null;
			}
			return fileChoice;
			
		}//end Scanner getScanner
	/**
	 * read file - has switches for each class (party, creature, 
	 * @throws FileNotFoundException
	 */
	 @SuppressWarnings("resource")
	public void readFile() throws FileNotFoundException{
		 		String inline;
		 		Scanner line;
		 		
	        	jTextA.append("Read File Button Pressed\n");
	        	
	        	jTextA.setText(null);
        		top.removeAllChildren();
	        	runDisplay.removeAll();
	        	
	        	try{
	        		Scanner input = new Scanner (getFile());
	        	
	        		cave = new Cave();
	        	
	        	while (input.hasNext()){
	        		inline = input.nextLine().trim();
	        		displayFile.append(inline + "\n");
	        		if(inline.length()==0)
	        			continue;
	        		
	        		line = new Scanner(inline).useDelimiter("\\s*:\\s*");

	        		switch(inline.charAt(0)){
	        			case 'p': addParty(line);
	        				break;
	        			case 'c': addCreature(line);
        					break;
	        			case 't': addTreasure(line);
        					break;
	        			case 'a': addArtifact(line);
        					break;
	        			case 'j': addJob(line);
        					break;
	        		}//end switch
	        		
	        	}//end while input
	        	
	        	}
	        	//if no file is selected then null will be returned and the user will choose again
	        	catch(NullPointerException e){
	        		jTextA.append("No File Was Selected");
	        		
	        	}
	        	
	        }
	 /**
	  * Methods adding party, creatures, treasures, artifacts
	  * @param Scanner line
	  */
	 private void addParty(Scanner line) {
		Party party = new Party();
		//	    p:<index>:<name>
		line.next(); //get rid of p:
		party.setIndex(line.nextInt());
		party.setName(line.next());
		cave.partyHash.put(party.index, party);
		cave.addParty(party);
		
	}

	private void addCreature(Scanner line) {
		Creature creature = new Creature();
		int creaturePartyIndex;
//	    c:<index>:<type>:<name>:<party>:<empathy>:<fear>:<carrying capacity>[:<age>:<height>:<weight>]
		
		
		line.next();//get rid of c:
		creature.setIndex(line.nextInt());
		creature.setType(line.next());
		creature.setName(line.next());
		creaturePartyIndex = line.nextInt();
		
//		partyMap.get(creature.getPartyByIndex()).getCreatures().add(creature).
		Party party = (Party) cave.partyHash.get(creaturePartyIndex);
		cave.creatureHash.put(creature.index, creature);
		if(party ==null){
			cave.freeCreature(creature);
		}
		else{
			cave.addCreature(creature);
			party.addCreature(creature);
			creature.setParty(party);
		}
		
		
		creature.setEmpathy(line.nextInt());
		creature.setFear(line.nextInt());
		creature.setCapacity(line.nextInt());
		
		
		if (line.hasNext()){
			creature.setAge(line.nextDouble());
		}
		
		if (line.hasNext()){
			creature.setHeight(line.nextDouble());
		}
		
		if (line.hasNext()){
			creature.setWeight(line.nextDouble());
			
		}
		
	}

	private void addTreasure(Scanner line) {
		
//	    t:<index>:<type>:<creature>:<weight>:<value>
		Treasure treasure = new Treasure();
		int treasureCreatureIndex = 0;
		
		line.next();//get rid of t:
		treasure.setIndex(line.nextInt());
		treasure.setType(line.next());
		treasureCreatureIndex = line.nextInt();
		
		Creature creature = (Creature) cave.creatureHash.get(treasureCreatureIndex);
		
		treasure.setWeight(line.nextDouble());
		treasure.setValue(line.nextDouble());
		
		if (creature == null){
			cave.freeTreasure(treasure);
		}
		else{
			creature.addTreasure(treasure);
			treasure.addCreature(creature);
			cave.addTreasures(treasure);
		}
		
		
		
		
	}

	private void addArtifact(Scanner line) {
//		 a:<index>:<type>:<creature>[:<name>]
		Artifact artifact = new Artifact();
		int artifactCreatureIndex;
		
		line.next();//get rid of t:
		artifact.setIndex(line.nextInt());
		artifact.setType(line.next());
		artifactCreatureIndex = line.nextInt();
		Creature creature = (Creature) cave.creatureHash.get(artifactCreatureIndex);
		
		if (line.hasNext()){
			artifact.setName(line.next());
		}
		
		if (creature == null){
			cave.freeArtifact(artifact);
		}
		else{
			creature.addArtifact(artifact);
			artifact.addCreature(creature);
			cave.addArtifacts(artifact);
		}
		
	}
	
	private void addJob(Scanner line) {
//	    j:<index>:<name>:<creature index>:<time>:[:<required artifact type>:<number>]*

		new Job(cave.creatureHash, runDisplay, line);
		
		
		
	}


	/**
	 * Main method starting instance of sorcerersCave
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main (String [] args) {
        new SorcerersCave ();
    } // end main
	
	
	
} // end class SorcerersCave 