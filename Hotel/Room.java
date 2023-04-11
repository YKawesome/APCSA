package Hotel;

public class Room {
	//Instance Variables
	private int roomNumber;
	private int daysRented;
	private String roomType;
	private String occupantName;
	
	//Constructor
	public Room(int roomNumber, String roomType) {
		this.roomNumber = roomNumber;
		this.daysRented = 0;
		this.occupantName = null;
		this.roomType = roomType.equals("single king") || roomType.equals("suite") ? roomType : "double queen";
	}
	
	//Getters
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getDaysRented() {
		return daysRented;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public String getOccupantName() {
		return occupantName;
	}
	
	//Setters
	public boolean setOccupant(String guestName, int daysStaying) {
		if(occupantName == null) {
			occupantName = guestName;
			daysRented = daysStaying;
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void advanceDay() {
		daysRented--;
		
		if(daysRented<=0) {
			occupantName = null;
			daysRented = 0;
		}
	}

	//toString
	public String toString() {
		String status = occupantName == null ? "free" : String.format("rented to %s", occupantName);
		return String.format("Room %d: %s – %s", roomNumber, roomType, status);
	}
}
