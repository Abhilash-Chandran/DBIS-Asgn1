package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EstateController {
	
	Stage prevStage;

	@FXML
	Label message;
	
	@FXML
	Button searchByCity;
	
	@FXML
	Button viewContracts;
	
	@FXML
	Button createEstate;
	
	@FXML
	Button createCustomer;
	
	@FXML
	Button signContract;
	
	
	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public Stage getPrevStage() {
		return prevStage;
	}

	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}

	@FXML
	public void viewContracts(ActionEvent event) {
		new EstUtility().navigate("Contract.fxml", "View Contracts");;
	}
	
	@FXML
	public void createCustomer(ActionEvent event) {
		new EstUtility().navigate("Person.fxml", "Person Management");
	}
	
	@FXML
	public void logout(ActionEvent event) {
		new EstUtility().navigate("LoginPage.fxml", "Estate Management Login");		
	}
	
	@FXML
	public void createEstate(ActionEvent event){
		new EstUtility().navigate("EstateNew.fxml", "Estate Management");
	}

	@FXML
	public void searchByCity(ActionEvent evt){
		//TO-do search code.
	}
}
