package application;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import view.EstateView;
import db.model.ViewEstate;

public class EstateController {
	
	Stage prevStage;

	@FXML
	Label message;
	
	@FXML
	TextField city;
	
	@FXML
	TableView<EstateView> estateTable;
	
	@FXML
	TableColumn<EstateView, String> colCity;
	
	@FXML
	TableColumn<EstateView, String> colPostCode;
	
	@FXML
	TableColumn<EstateView, String> colStreet;
	
	@FXML
	TableColumn<EstateView, String> colStreetNo;
	
	@FXML
	TableColumn<EstateView, String> colSquareArea;
	
	public TextField getCity() {
		return city;
	}

	public void setCity(TextField city) {
		this.city = city;
	}

	public TableView<EstateView> getEstateTable() {
		return estateTable;
	}

	public void setEstateTable(TableView<EstateView> estateTable) {
		this.estateTable = estateTable;
	}

	public TableColumn<EstateView, String> getColCity() {
		return colCity;
	}

	public void setColCity(TableColumn<EstateView, String> colCity) {
		this.colCity = colCity;
	}

	public TableColumn<EstateView, String> getColPostCode() {
		return colPostCode;
	}

	public void setColPostCode(TableColumn<EstateView, String> colPostCode) {
		this.colPostCode = colPostCode;
	}

	public TableColumn<EstateView, String> getColStreet() {
		return colStreet;
	}

	public void setColStreet(TableColumn<EstateView, String> colStreet) {
		this.colStreet = colStreet;
	}

	public TableColumn<EstateView, String> getColStreetNo() {
		return colStreetNo;
	}

	public void setColStreetNo(TableColumn<EstateView, String> colStreetNo) {
		this.colStreetNo = colStreetNo;
	}

	public TableColumn<EstateView, String> getColSquareArea() {
		return colSquareArea;
	}

	public void setColSquareArea(TableColumn<EstateView, String> colSquareArea) {
		this.colSquareArea = colSquareArea;
	}

	public Label getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = new Label(message);
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
	public void initialize(){
		searchByCity(null);
	}

	@FXML
	public void searchByCity(ActionEvent evt){
		List<ViewEstate> vwEstates = new ViewEstate().searchEstates(getCity().getText(),EstUtility.getCurrentAgent().getId());
		ObservableList<EstateView> estateOblist = convertEstates(vwEstates);
		configureEstateTableColumns();
		getEstateTable().setItems(estateOblist);	
	}
	
	public ObservableList<EstateView> convertEstates(List<ViewEstate> estateList) {
		ObservableList<EstateView> estateOblist = FXCollections.observableArrayList();
		for (ViewEstate estate : estateList) {
			estateOblist.add(new EstateView(estate.getEagId()+"",estate.getCity(),estate.getPostalCode()+"",estate.getStreet(),estate.getStreetNo()+"",estate.getSquareArea()+""));
		}
		return estateOblist;
	}
	
	public void configureEstateTableColumns() {
		getColCity().setCellValueFactory(new PropertyValueFactory<EstateView,String>("city"));
		getColPostCode().setCellValueFactory(new PropertyValueFactory<EstateView,String>("postalCode"));
		getColSquareArea().setCellValueFactory(new PropertyValueFactory<EstateView,String>("squareArea"));
		getColStreet().setCellValueFactory(new PropertyValueFactory<EstateView,String>("street"));
		getColStreetNo().setCellValueFactory(new PropertyValueFactory<EstateView,String>("streetNumber"));
	}
}
