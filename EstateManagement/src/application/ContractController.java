package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ContractController {

	@FXML
	TextField searchName;
	
	@FXML
	Label message;
	
	@FXML
	DatePicker dateCnt;
	
	@FXML
	TextField place;
	
	@FXML
	DatePicker startDate;
	
	@FXML
	TextField duration;
	
	@FXML
	TextField addOnCost;
	
	@FXML
	TextField noOfInst;
	
	@FXML
	TextField intRate;
	
	public DatePicker getDateCnt() {
		return dateCnt;
	}

	public void setDateCnt(DatePicker dateCnt) {
		this.dateCnt = dateCnt;
	}

	public TextField getPlace() {
		return place;
	}

	public void setPlace(TextField place) {
		this.place = place;
	}

	public DatePicker getStartDate() {
		return startDate;
	}

	public void setStartDate(DatePicker startDate) {
		this.startDate = startDate;
	}

	public TextField getDuration() {
		return duration;
	}

	public void setDuration(TextField duration) {
		this.duration = duration;
	}

	public TextField getAddOnCost() {
		return addOnCost;
	}

	public void setAddOnCost(TextField addOnCost) {
		this.addOnCost = addOnCost;
	}

	public TextField getNoOfInst() {
		return noOfInst;
	}

	public void setNoOfInst(TextField noOfInst) {
		this.noOfInst = noOfInst;
	}

	public TextField getIntRate() {
		return intRate;
	}

	public void setIntRate(TextField intRate) {
		this.intRate = intRate;
	}

	@FXML
	ChoiceBox<String> contractType;

	public ChoiceBox<String> getContractType() {
		return contractType!=null?contractType:new ChoiceBox<String>();
	}

	public void setContractType(ChoiceBox<String> contractType) {
		this.contractType = contractType;
	}

	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public TextField getSearchName() {
		return searchName;
	}

	public void setSearchName(TextField searchName) {
		this.searchName = searchName;
	}

	public void initialize() {
		ObservableList<String> contracts = FXCollections.observableArrayList("Purchase","Tenancy");
		getContractType().setItems(contracts);
	}
	
	@FXML
	public void searchByName(ActionEvent evt){
		//to-do search code.
	}
	
	@FXML
	public void clear(ActionEvent event) {
		new EstUtility().cancel();
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		new EstUtility().cancel();
	}
	
	@FXML
    public void logout(ActionEvent evt){
		new EstUtility().navigate("LoginPage.fxml", "Estate Management Login");
	}
	
	@FXML
	public void viewEstates(ActionEvent event){
		new EstUtility().navigate("Estate.fxml", "Estate Management");	
	}
	
	@FXML
	public void signContract(ActionEvent evt){
		new EstUtility().navigate("ContractNew.fxml", "Contract Management");
	}
	
	@FXML
	public void createCustomer(ActionEvent event) {
		new EstUtility().navigate("Person.fxml", "Person Management");
	}
}
