/**
 * class CaveElement - provides super. methods for name and index
 * @author Revani
 *
 */
public class CaveElement {
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

