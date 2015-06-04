import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


public class Job extends CaveElement implements Runnable {
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
