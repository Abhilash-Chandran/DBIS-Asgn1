package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import db.model.Person;

public class PersonController {
	
	@FXML
	int id;

	@FXML
	TextField firstName;
	
	@FXML
	TextField name;
	
	@FXML
	TextField address;
	
	@FXML
	Label message;
	
	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public TextField getFirstName() {
		return firstName;
	}

	public void setFirstName(TextField firstName) {
		this.firstName = firstName;
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public TextField getAddress() {
		return address;
	}

	public void setAddress(TextField address) {
		this.address = address;
	}

	
	@FXML
	public void clear(){
		new EstUtility().cancel();
	}
	
	@FXML
	public void save(ActionEvent event) {
		try {
			Person person = new Person();
			person.setFirstName(getFirstName().getText());
			person.setName(getName().getText());
			person.setAddress(getAddress().getText());
			person.savePerson();
			setMessage(new Label("Save Successfull."));
			Thread.sleep(2000);
			EstUtility.getCurrStage().close();
			EstUtility.setCurrStage(EstUtility.getPrevStage());
			EstUtility.getCurrStage().show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void cancel(ActionEvent event){
      new EstUtility().cancel(); 
	}
}
