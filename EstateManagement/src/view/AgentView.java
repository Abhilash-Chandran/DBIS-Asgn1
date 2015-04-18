package view;

import javafx.beans.property.SimpleStringProperty;

public class AgentView {

	private final SimpleStringProperty name;
    private final SimpleStringProperty address;
    private final SimpleStringProperty login;
    private final SimpleStringProperty password;
    
	public AgentView(String name, String address, String login, String password) {
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }
	
	
	public String getName() {
		return name.get();
	}
	public String getAddress() {
		return address.get();
	}
	public String getLogin() {
		return login.get();
	}
	public String getPassword() {
		return password.get();
	}
	

}
