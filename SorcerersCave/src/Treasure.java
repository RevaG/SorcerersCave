/**
 * class for creating treasures
 * @author Revani Govender
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