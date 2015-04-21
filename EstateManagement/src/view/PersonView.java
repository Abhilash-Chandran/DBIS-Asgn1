package view;

import javafx.beans.property.SimpleStringProperty;

public class PersonView {

	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty firstName;
    private final SimpleStringProperty address;
    
    
	public PersonView(String id, String firstName,String name, String address) {
		this.name = new SimpleStringProperty(name);
		this.firstName = new SimpleStringProperty(firstName);
        this.address = new SimpleStringProperty(address);
        this.id = new SimpleStringProperty(id);
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

	public String getId() {
		return id.get();
	}
	

}
