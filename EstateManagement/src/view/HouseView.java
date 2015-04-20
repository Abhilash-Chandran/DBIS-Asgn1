package view;

import javafx.beans.property.SimpleStringProperty;

public class HouseView {

	private final SimpleStringProperty floors;
    private final SimpleStringProperty price;
    private final SimpleStringProperty garden;
    
	public HouseView(String floors, String price, String garden) {
        this.floors = new SimpleStringProperty(floors);
        this.price = new SimpleStringProperty(price);
        this.garden = new SimpleStringProperty(garden);
    }

	public String getFloors() {
		return floors.get();
	}

	public String getPrice() {
		return price.get();
	}

	public String getGarden() {
		return garden.get();
	}
}
