//Vijay Challa, Ronnie Jebara

public class Space {
	private Piece occupying;
	private int[] location;
	private char color;
	
	public Space(Piece Occupying, int[] Location, char Color) {
		this.occupying = Occupying;
		this.location = Location;
		this.color = Color;
		this.occupying.setLocation(this.location);
	}
	
	public void display() {
		char filler1;
		char filler2;
		
		if(this.occupying != null) {
			if(this.occupying.getIsWhite()) {
				filler1 = 'w';
			} else {
				filler1 = 'b';
			}
			
			filler2 = this.occupying.getName();
		} else {
			filler1 = this.color;
			filler2 = this.color;
		}
		
		System.out.print(filler1);
		System.out.print(filler2);
		System.out.print(' ');
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
		this.occupying.setLocation(this.location);
	}

	public void setColor(char Color) {
		this.color = Color;
	}
	
	public char getColor() {
		return this.color;
	}

}