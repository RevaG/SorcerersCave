import java.util.ArrayList;

/**
 * extends CaveElement - contains parties
 * @author Revani Govender
 *
 */
public class Party extends CaveElement {
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