package Hotel;

public class Hotel {
	//Instance Variables
	private String hotelName;
	public Room[] rooms;
	private int totalRooms;
	
	//Constructor
	public Hotel(String hotelName, int totalRooms, int totalFloors) {
		this.hotelName = hotelName;
		this.totalRooms = totalRooms;
		this.rooms = new Room[totalRooms];
		
		int roomsPerFloor = totalRooms / totalFloors;
		int roomIncrement = 100 / roomsPerFloor;
		
		
		for(int currFloor = 1; currFloor <= totalFloors; currFloor++) {
			int numSuite = 0;
			int numKing = 0;
			
			for(int i = roomsPerFloor-1; i >= 0 ; i--) {
				if(numSuite == 0) {
					rooms[i + (currFloor - 1) * roomsPerFloor] = new Room(currFloor * 100 + i * roomIncrement, "suite");
					numSuite++;
				}
				else if(numKing < 4) {
					rooms[i + (currFloor - 1) * roomsPerFloor] = new Room(currFloor * 100 + i * roomIncrement, "single king");
					numKing++;
				}
				else {
					rooms[i + (currFloor - 1) * roomsPerFloor] = new Room(currFloor * 100 + i * roomIncrement, "");
				}
			}
		}
	}
	
	
	//Getters
	public int getTotalRooms() {
		return totalRooms;
	}
	
	public int getNumberOccupied() {
		int count = 0;
		
		for(Room r: rooms) {
			if(r.getOccupantName() != null) {
				count++;
			}
		}
		
		return count;
	}
	
	public double getOccupancyRate() {
		double value = (double)getNumberOccupied() / getTotalRooms();
		value = (double)Math.round(value * 100d) / 100d;
//		System.out.println());
		return value;
	}
	
	//Other
	public boolean rentRoom(String roomType, String renterName, int numDays) {
		for(Room r: rooms) {
			if(r.getOccupantName() == null && r.getRoomType().equals(roomType)) {
				r.setOccupant(renterName, numDays);
				return true;
			}
		}
		return false;
	}
	
	public void advanceDay() {
		for(Room r: rooms) {
			r.advanceDay();
		}
	}
	
	public void printRooms() {
		for(Room r: rooms) {
			System.out.println(r.toString());
		}
	}
	
	//toString
	public String toString() {
		return String.format("The %s Hotel: %d%% occupied", hotelName, (int)(getOccupancyRate()*100));
	}
	
	
	
	
	
	
}
