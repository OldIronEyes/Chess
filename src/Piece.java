//Vijay Challa, Ronnie Jebara

import java.util.ArrayList;

public abstract class Piece {
	private Boolean isWhite;
	private char name;
	private int[] location;
	
	public abstract ArrayList<int[]> getMoveset(Board board);

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] Location) {
		this.location = Location;
	}

	public Boolean getIsWhite() {
		return isWhite;
	}

	public void setIsWhite(Boolean isWhite) {
		this.isWhite = isWhite;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		if(this.isWhite) {
			this.name = Character.toUpperCase(name);
		} else {
			this.name = Character.toLowerCase(name);
		}
	}

}
