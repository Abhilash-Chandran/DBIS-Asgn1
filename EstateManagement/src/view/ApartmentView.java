package view;

import javafx.beans.property.SimpleStringProperty;

public class ApartmentView {

	private final SimpleStringProperty floor;
    private final SimpleStringProperty rent;
    private final SimpleStringProperty rooms;
    private final SimpleStringProperty balcony;
    private final SimpleStringProperty buIKitchen;
    
    
	public ApartmentView(String floor, String rent, String rooms, String balcony, String buIKitchen) {
        this.floor = new SimpleStringProperty(floor);
        this.rent = new SimpleStringProperty(rent);
        this.rooms = new SimpleStringProperty(rooms);
        this.balcony = new SimpleStringProperty(balcony);
        this.buIKitchen = new SimpleStringProperty(buIKitchen);
    }

	public String getFloor() {
		return floor.get();
	}

	public String getRent() {
		return rent.get();
	}

	public String getRooms() {
		return rooms.get();
	}

	public String getBalcony() {
		return balcony.get();
	}

	public String getBuIKitchen() {
		return buIKitchen.get();
	}

}
