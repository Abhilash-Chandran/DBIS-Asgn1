package view;

import javafx.beans.property.SimpleStringProperty;

public class EstateView {

	private final SimpleStringProperty eagId;
    private final SimpleStringProperty city;
    private final SimpleStringProperty postalCode;
    private final SimpleStringProperty street;
    private final SimpleStringProperty streetNumber;
    private final SimpleStringProperty squareArea;
    
	public EstateView(String eagId, String city, String postalCode, String street, String streetNumber, String squareArea) {
        this.eagId = new SimpleStringProperty(eagId);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.street = new SimpleStringProperty(street);
        this.streetNumber = new SimpleStringProperty(streetNumber);
        this.squareArea = new SimpleStringProperty(squareArea);
    }

	public String getEagId() {
		return eagId.get();
	}

	public String getCity() {
		return city.get();
	}

	public String getPostalCode() {
		return postalCode.get();
	}

	public String getStreet() {
		return street.get();
	}

	public String getStreetNumber() {
		return streetNumber.get();
	}

	public String getSquareArea() {
		return squareArea.get();
	}
	

}
