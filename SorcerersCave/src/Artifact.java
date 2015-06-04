
/**
 * class for creating artifacts
 * @author Revani Govender
 *
 */
public class Artifact extends CaveElement {
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