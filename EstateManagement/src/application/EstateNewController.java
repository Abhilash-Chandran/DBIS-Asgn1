package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EstateNewController {

	@FXML
	Label message;
	
	@FXML
	TextField city;

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

	@FXML
	ChoiceBox<String> estateType;
	
	@FXML
	ChoiceBox<String> balcony;
	
	@FXML
	ChoiceBox<String> kitchen;
	
	@FXML
	ChoiceBox<String> garden;

	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public void initialize() {
		ObservableList<String> estates = FXCollections.observableArrayList("House","Apartment");
		ObservableList<String> yesno = FXCollections.observableArrayList("Yes","No");
		
		getEstateType().setItems(estates);
		getBalcony().setItems(yesno);
		getGarden().setItems(yesno);
		getKitchen().setItems(yesno);
		setMessage(new Label("TEST LABEL"));
	}

	public ChoiceBox<String> getBalcony() {
		return balcony!=null?balcony:new ChoiceBox<String>() ;
	}

	public void setBalcony(ChoiceBox<String> balcony) {
		this.balcony = balcony;
	}

	public ChoiceBox<String> getKitchen() {
		return kitchen!=null?kitchen:new ChoiceBox<String>();
	}

	public void setKitchen(ChoiceBox<String> kitchen) {
		this.kitchen = kitchen;
	}

	public ChoiceBox<String> getGarden() {
		return garden!=null?garden:new ChoiceBox<String>();
	}

	public void setGarden(ChoiceBox<String> garden) {
		this.garden = garden;
	}

	@FXML
	public void save(ActionEvent evt) {
		// code to be written for saving
	}

	public ChoiceBox<String> getEstateType() {
		return estateType!=null?estateType:new ChoiceBox<String>();
	}

	public void setEstateType(ChoiceBox<String> estateType) {
		this.estateType = estateType;
	}

	@FXML
	public void clear(ActionEvent event) {
		System.out.println("value is : " + getEstateType().getSelectionModel().getSelectedItem() + " blahh");
	}

	@FXML
	public void cancel(ActionEvent event) {
		new EstUtility().cancel();
	}

}
