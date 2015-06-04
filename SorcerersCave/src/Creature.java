import java.util.ArrayList;

/**
 * Contains arrays for treasure and artifacts 
 * Used to create creatures
 * @author Revani Govender
 *
 */
public class Creature extends CaveElement{
	
	

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