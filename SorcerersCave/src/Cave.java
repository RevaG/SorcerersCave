// File: Cave.java
// Due Date: Feb 22, 2014
// Author: Revani Govender
// Purpose: the Sorcerer's Cave project game data
// These classes contain CaveElements, Party, Creature, Artifact, and Treasure


import java.util.ArrayList;
import java.util.HashMap;


/**
 * class Cave - holds all the objects that are created
 * @author Revani Govender
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













