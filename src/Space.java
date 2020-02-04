
public class Space {
	private Piece occupying;
	private int[] location;
	private char color;
	
	public Space(Piece Occupying, int[] Location, char Color) {
		this.occupying = Occupying;
		this.location = Location;
		this.color = Color;
	}
	
	public void display() {
		char filler;
		
		if(this.occupying != null) {
			filler = occupying.getName();
		} else {
			filler = this.color;
		}
		
		System.out.print("[" + filler + "]");
	}

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}
	
	public Piece getOccupying() {
		return this.occupying;
	}
	
	public void setOccupying(Piece newOccupying) {
		this.occupying = newOccupying;
	}

	public void setColor(char Color) {
		this.color = Color;
	}
	
	public char getColor() {
		return this.color;
	}

}
