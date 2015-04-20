package view;

import javafx.beans.property.SimpleStringProperty;

public class TenancyView {

	private final SimpleStringProperty name;
	private final SimpleStringProperty firstName;
    private final SimpleStringProperty address;
    
    
	public TenancyView(String name, String firstName, String address) {
		this.name = new SimpleStringProperty(name);
		this.firstName = new SimpleStringProperty(firstName);
        this.address = new SimpleStringProperty(address);
    }
	
	
	public String getFirstName() {
		return firstName.get();
	}
	public String getAddress() {
		return address.get();
	}
	public String getName() {
		return name.get();
	}
	

}
