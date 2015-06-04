// File: Cave.java
// Due Date: Feb 22, 2014
// Author: Revani Govender
// Purpose: the Sorcerer's Cave project game data
// These classes contain CaveElements, Party, Creature, Artifact, and Treasure


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


/**
 * class Cave - holds all the objects that are created
 * @author Revani
 *
 */
public class Cave {
	HashMap<Integer, Creature> creatureHash = new HashMap<Integer, Creature>();
	HashMap<Integer, Party> partyHash = new HashMap<Integer, Party>();
	ArrayList<Party> parties = new ArrayList<Party>();
	ArrayList<Creature> creatures = new ArrayList<Creature>();
	ArrayList<Treasure> treasures = new ArrayList<Treasure>();
	ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
	ArrayList<Job> jobs = new ArrayList<Job>();
	
	ArrayList<Treasure> freeTreasure = new ArrayList <Treasure>();
	ArrayList<Creature> freeCreature = new ArrayList <Creature>();
	ArrayList<Artifact> freeArtifact = new ArrayList <Artifact>();
	public String toString () {
        String st = "Cave.toString:\nThe Parties\n";
        for (Party p: getParties()) 
            st += p + "\n";
        st += "\n+++++++\nItems Not associated with any creature:\n";
        for (CaveElement e1: freeCreature)
            st += "Free Creatures: \n" + e1 + "\n";
        for (CaveElement e2: freeTreasure)
            st += "Free Treasures: " + e2 + "\n";
        for (CaveElement e3: freeArtifact)
            st += "Free Artifacts: " + e3 + "\n";
        
        
        return st;
    } // end toString method
	
	public ArrayList<Creature> getCreatures() {
		return creatures;
	}

	public void setCreatures(ArrayList<Creature> creatures) {
		this.creatures = creatures;
	}
	public void addParty(Party party){
		getParties().add(party);
	}

	public void freeTreasure(Treasure treasure) {
		freeTreasure.add(treasure);
		treasures.add(treasure);
		
	}
	
	public void freeCreature(Creature creature){
		freeCreature.add(creature);
		creatures.add(creature);
	}
	
	public void freeArtifact(Artifact artifact){
		freeArtifact.add(artifact);
		artifacts.add(artifact);
	}

	public ArrayList<Party> getParties() {
		return parties;
	}

	public void setParties(ArrayList<Party> parties) {
		this.parties = parties;
	}

	public Party getParty(Party party) {
			
		return party;
	}

	public void addCreature(Creature creature) {
		creatures.add(creature);
		
	}
	public void addTreasures(Treasure treasure) {
		treasures.add(treasure);
		
	}
	public void addArtifacts(Artifact artifact) {
		artifacts.add(artifact);
		
	}
}//end class Cave
/**
 * class CaveElement - provides super. methods for name and index
 * @author Revani
 *
 */
class CaveElement {
	
	String name = "";
	int index = 0;
	
	public String toString(){
		return "CaveElement: " + name;
	}//end toString

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}//end class CaveElement

/**
 * extends CaveElement - contains parties
 * @author Revani
 *
 */
class Party extends CaveElement {
	ArrayList<Creature> members = new ArrayList<Creature>();
	
	public Party() {
	}
	
	public void addCreature(Creature creature){
		members.add(creature);
		
	}
	public ArrayList<Creature> getPartyMembers() {
		return members;
	}

	public void setPartyMembers(ArrayList<Creature> partyMembers) {
		this.members = partyMembers;
	}

	
	
	public String toString(){
		String st = name + " Members:\n"
				+ "Index: " + index + "\n";
		for(Creature creatures: members)
			st += "          " + creatures + "\n";
		return st;
	}//end toString

}//end class Party
/**
 * Contains arrays for treasure and artifacts 
 * Used to create creatures
 * @author Revani
 *
 */
class Creature extends CaveElement{
	
	

	ArrayList <Treasure> treasures = new ArrayList <Treasure> ();
    ArrayList <Artifact> artifacts = new ArrayList <Artifact> ();
    ArrayList <Job> jobs = new ArrayList <Job> ();
    private String type;
    Party party = null;
    private double empathy;
    private double fear;
    private double capacity;
    private double age;
	private double height;
    private double weight;
	boolean busyFlag = false;
    
    
    public Creature(String n) {
		name = n;
	}
    
    public Creature() {
		
	}
    
    public ArrayList<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
	
	public void addJob(Job job){
		jobs.add(job);
	}
    
    public ArrayList<Treasure> getTreasures() {
		return treasures;
	}

    public void addTreasure(Treasure treasure){
		treasures.add(treasure);
		
	}
    
    public void addArtifact(Artifact artifact){
    	artifacts.add(artifact);
    }
    

	public ArrayList<Artifact> getArtifacts() {
		return artifacts;
	}

	public void setArtifacts(ArrayList<Artifact> artifacts) {
		this.artifacts = artifacts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public double getEmpathy() {
		return empathy;
	}

	public void setEmpathy(double empathy) {
		this.empathy = empathy;
	}

	public double getFear() {
		return fear;
	}

	public void setFear(double fear) {
		this.fear = fear;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
    public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	/*
	 * print individual attributes of the object creature
	 */
	public String attributesToString(){
		String st = "     " + name + "\n"
				+"                    Index: " + index + "\n"
				+"                    Type: " + getType() + "\n"
				+"                    Empathy: " + getEmpathy() + "\n"
				+"                    Fear: " + getFear() + "\n"
				+"                    Carrying Capacity: " + getCapacity() + "\n"
				+"                    Age: " + getAge() + "\n"
				+"                    Height: " + getHeight() + "\n"
				+"                    Weight: " + getWeight() + "\n";
				
		
		try{party.getName();
			st += "                    Party: " + party.getName() + "\n";
		}
			catch (NullPointerException e){
			st += "                    No Party \n";
		}

		for (Artifact artifact: artifacts) 
			if (artifact.getType().equals(null)){
			}
			else{
				if (artifacts.indexOf(artifact) == 0 ){
					st += "                    Artifacts:\n";
				}
				st += "" + artifact + "\n";
			}
	
       
        for (Treasure treasure: treasures) 
        	if(treasure.getType().equals(null)){
        	}
        	else{ 
        		if (treasures.indexOf(treasure) == 0 ){
        			st += "                    Treasures:\n";
        		}
            st += "" + treasure + "\n";
        	}
        return st;
		
	}
	
	public String toString () {
        String st = "     " + name + "; Index: " + index + "\n"
				+"                    Type: " + getType()
				+"; Empathy: " + getEmpathy()
				+"; Fear: " + getFear()
				+"; Carrying Capacity: " + getCapacity() + "\n"
				+"                    Age: " + getAge()
				+"; Height: " + getHeight()
				+"; Weight: " + getWeight() + "\n\n";
				
        for (Artifact artifact: artifacts) 
			if (artifact.getType().equals(null)){
			}
			else{
				if (artifacts.indexOf(artifact) == 0 ){
					st += "                    Artifacts:\n";
				}
				st += "" + artifact + "\n";
			}
	
       
        for (Treasure treasure: treasures) 
        	if(treasure.getType().equals(null)){
        	}
        	else{ 
        		if (treasures.indexOf(treasure) == 0 ){
        			st += "                    Treasures:\n";
        		}
            st += "" + treasure + "\n";
        	}
//        
        for (Job job: jobs) {

            st += "" + job;
            
        	}
    
        return st;
    } // end method toString

	
    
}//end class Creature

/**
 * class for creating treasures
 * @author Revani
 *
 */
class Treasure extends CaveElement{
	
	private int treasureCreatureIndex;
	private double weight;
	private Creature creature;
	
	double value;
	String type;
	
	public Creature getCreature() {
		return creature;
	}

	public void addCreature(Creature creature) {
		this.creature = creature;
	}


	
	public Treasure (String n) {
		name = n;
	}
    
    public Treasure() {
		
		
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTreasureCreatureIndex() {
		return treasureCreatureIndex;
	}

	public void setTreasureCreatureIndex(int treasureCreatureIndex) {
		this.treasureCreatureIndex = treasureCreatureIndex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	/*
	 * Print individual attributes of treasure
	 */
	public String attributesToString(){
		String st = "     " + name + "\n"
				+"                    Index: " + getIndex() + "\n"
				+"                    Type: " + getType() + "\n"
				+"                    Weight: " + getWeight() + "\n"
				+"                    Value: " + getValue()+ "\n";
		
		try{creature.getName();
		st += "                    Creature: " + creature.getName() + "\n";
	}
		catch (NullPointerException e){
		st += "                    No Creature \n";
	}
				
				return st;
		
	}
	public String toString () {
    	return "                         " + type + ": " + value;
    } // end method toString
}//end class Treasure

/**
 * class for creating artifacts
 * @author Revani
 *
 */
class Artifact extends CaveElement {
//	String artifactName;
	private Creature creature;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Artifact (String n) {
		name = n;
	}//end constructor

	public Creature getCreature() {
		return creature;
	}

	public void addCreature(Creature creature) {
		this.creature = creature;
	}

	public Artifact() {

	}
	/*
	 * print attributes of artifact
	 */
	public String attributesToString(){
		String st = "     " + name + "\n"
				+"                    Index: " + getIndex() + "\n"
				+"                    Type: " + getType() + "\n";
		
		try{creature.getName();
		st += "                    Creature: " + creature.getName() + "\n";
		}
		catch (NullPointerException e){
		st += "                    No Creature \n";
		}
				
				return st;
		
	}

	public String toString () {
        return "                         " + type + ": "+name;
    } // end toString
    
}//end class Artifact

class Job extends CaveElement implements Runnable {
	private Creature creature;
	private double jobTime;
	
	int jobCreatureIndex;
	JProgressBar progressBar = new JProgressBar();
	JPanel parent;
	
	JButton jButtonStop = new JButton( "Stop");
	JButton jButtonCancel = new JButton( "Cancel");
	boolean goFlag = true; 
	boolean noKillFlag = true;
	Status status = Status.SUSPENDED;
	
	static Random run = new Random();
	
	enum Status{RUNNING, SUSPENDED, WAITING, DONE, CANCELED};
	
	
	
	public Job(HashMap<Integer, Creature> creatureHash, JPanel runDisplay,
			Scanner line) {
		line.next();//get rid of j:
		index = line.nextInt();
		name = line.next();
		jobCreatureIndex = line.nextInt();
		Creature creature = (Creature) creatureHash.get(jobCreatureIndex);
		
		jobTime = line.nextDouble();
		
		addCreature(creature);
		creature.addJob(this);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		

		
		runDisplay.setLayout(new GridLayout (0, 5, 2, 5));
		runDisplay.add(new JLabel (creature.name, SwingConstants.CENTER));
		runDisplay.add(progressBar);
		runDisplay.add(new JLabel(name, SwingConstants.CENTER));
				 
		 runDisplay.add(jButtonStop);
		 runDisplay.add(jButtonCancel);
		 
		 jButtonStop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleGoFlag();
			}
		 });
		 
		 jButtonCancel.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					setKillFlag();
					toggleGoFlag();
				}
			 });
		 
		    new Thread (this).start();

	}
	
	
	public void toggleGoFlag() {
		goFlag = !goFlag;
	}
	
	public void setKillFlag() {
		noKillFlag = false;
			status = Status.CANCELED;
			jButtonCancel.setBackground(Color.RED);
		
					
	}
	
	public void showStatus(Status status){
		switch(status){
		case RUNNING:
			jButtonStop.setBackground(Color.GREEN);
			jButtonStop.setText("Running");
			break;
		case SUSPENDED:
			
			jButtonStop.setBackground(Color.YELLOW);
			jButtonStop.setText("Suspended");
			break;
		case WAITING:
			jButtonStop.setBackground(Color.ORANGE);
			jButtonStop.setText("Waiting Turn");
			break;
		case DONE:
			jButtonStop.setBackground(Color.RED);
			jButtonStop.setText("Done");
			break;
		case CANCELED:
			jButtonCancel.setBackground(Color.RED);
			jButtonCancel.setText("Canceled");
			jButtonStop.setText("Canceled");
			progressBar.setValue(0);
			progressBar.setForeground(Color.RED);
			break;
			
		}//end switch
	}
	
	public void run() {
		long time = System.currentTimeMillis();
		long startTime = time;
		long stopTime = (long) (time + 1000 * jobTime);
		double duration = stopTime - time;
		
		synchronized (creature) { // party since looking forward to P4 requirements
		      while (creature.busyFlag) {
		        showStatus (Status.WAITING);
		        try {
		          creature.wait();
		        }
		        catch (InterruptedException e) {
		        } // end try/catch block
		      } // end while waiting for worker to be free
		      creature.busyFlag = true;
		    } // end sychronized on worker

		    while (time < stopTime && noKillFlag) {
		      try {
		        Thread.sleep (100);
		      } catch (InterruptedException e) {}
		      if (goFlag) {
		        showStatus (Status.RUNNING);
		        time += 100;
		        progressBar.setValue ((int)(((time - startTime) / duration) * 100));
		      } else {
		        showStatus (Status.SUSPENDED);
		      } // end if stepping
		    
		    if(!noKillFlag){
		    	showStatus(Status.CANCELED);
		    }
		    
		    } // end runninig
		    if (progressBar.getValue() == 100){
		    	//progressBar.setValue (100);
		    	showStatus (Status.DONE);
		    }
		    
		    synchronized (creature) {
		      creature.busyFlag = false; 
		      creature.notifyAll ();
		    }
		
	}
	
	public Job (String n) {
		name = n;
	}//end constructor

	public Creature getCreature() {
		return creature;
	}

	public void addCreature(Creature creature) {
		this.creature = creature;
	}

	public Job() {

	}
	
	

	public long getJobTime() {
		return (long) jobTime;
	}

	public void setJobTime(double d) {
		this.jobTime = d;
	}
	/*
	 * print attributes of job
	 */
	public String attributesToString(){
		String st = "     " + name + "\n"
				+"                    Name: " + getName() + "\n"
				+"                    Time: " + getJobTime() + "\n";
		
		try{creature.getName();
		st += "                    Creature: " + creature.getName() + "\n";
		}
		catch (NullPointerException e){
		st += "                    No Creature \n";
		}
				
				return st;
		
	}

	public String toString () {
		String st ="                    Job: " + getName() + "\n";

				
				return st;
    } // end toString


    
}//end class Job

