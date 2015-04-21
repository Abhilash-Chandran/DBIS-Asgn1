package application;

import java.util.List;

import db.model.Person;
import db.model.ViewEstate;
import view.ContractView;
import view.PersonView;
import view.PersonView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContractController {

	@FXML
	TextField searchName;
	
	@FXML
	TextField contractNumb;
	
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
	
	@FXML
	Label startDateLb;
	
	@FXML
	Label durationLb;
	
	@FXML
	Label additionalCostLb;
	
	@FXML
	Label noOfInstLb;

	@FXML
	Label intRateLB;
	
	/*table for person.*/
	@FXML
	TableView<PersonView> persTable;
	
	@FXML
	TableColumn<PersonView, String> colFirstName;
	
	@FXML
	TableColumn<PersonView, String> colName;
	
	@FXML
	TableColumn<PersonView, String> colAddress;
	//end person table
	
	/*table for Contracts Vew.*/
	@FXML
	TableView<ContractView> contTable;
	
	@FXML
	TableColumn<ContractView, String> colContnumber;
	
	@FXML
	TableColumn<ContractView, String> colContDate;
	
	@FXML
	TableColumn<ContractView, String> colContPlace;
	
	@FXML
	TableColumn<ContractView, String> colContType;
	//end contract table
	
	public Label getStartDateLb() {
		return startDateLb;
	}

	public void setStartDateLb(String lb) {
		this.startDateLb = new Label(lb);
	}

	public Label getDurationLb() {
		return durationLb;
	}

	public void setDurationLb(String lb) {
		this.durationLb = new Label(lb);
	}

	public Label getAdditionalCostLb() {
		return additionalCostLb;
	}

	public void setAdditionalCostLb(String lb) {
		this.additionalCostLb = new Label(lb);
	}

	public Label getNoOfInstLb() {
		return noOfInstLb;
	}

	public void setNoOfInstLb(String lb) {
		this.noOfInstLb = new Label(lb);
	}

	public Label getIntRateLB() {
		return intRateLB;
	}

	public void setIntRateLB(String lb) {
		this.intRateLB = new Label(lb);
	}

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

	public void setMessage(String message) {
		this.message = new Label(message);
	}

	public TextField getSearchName() {
		return searchName;
	}

	public void setSearchName(TextField searchName) {
		this.searchName = searchName;
	}

	public TextField getContractNumb() {
		return contractNumb;
	}

	public void setContractNumb(TextField contractNumb) {
		this.contractNumb = contractNumb;
	}

	public TableView<PersonView> getPersTable() {
		return persTable;
	}

	public void setPersTable(TableView<PersonView> persTable) {
		this.persTable = persTable;
	}

	public TableColumn<PersonView, String> getColFirstName() {
		return colFirstName;
	}

	public void setColFirstName(TableColumn<PersonView, String> colFirstName) {
		this.colFirstName = colFirstName;
	}

	public TableColumn<PersonView, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<PersonView, String> colName) {
		this.colName = colName;
	}

	public TableColumn<PersonView, String> getColAddress() {
		return colAddress;
	}

	public void setColAddress(TableColumn<PersonView, String> colAddress) {
		this.colAddress = colAddress;
	}

	public TableView<ContractView> getContTable() {
		return contTable;
	}

	public void setContTable(TableView<ContractView> contTable) {
		this.contTable = contTable;
	}

	public TableColumn<ContractView, String> getColContnumber() {
		return colContnumber;
	}

	public void setColContnumber(TableColumn<ContractView, String> colContnumber) {
		this.colContnumber = colContnumber;
	}

	public TableColumn<ContractView, String> getColContDate() {
		return colContDate;
	}

	public void setColContDate(TableColumn<ContractView, String> colContDate) {
		this.colContDate = colContDate;
	}

	public TableColumn<ContractView, String> getColContPlace() {
		return colContPlace;
	}

	public void setColContPlace(TableColumn<ContractView, String> colContPlace) {
		this.colContPlace = colContPlace;
	}

	public TableColumn<ContractView, String> getColContType() {
		return colContType;
	}

	public void setColContType(TableColumn<ContractView, String> colContType) {
		this.colContType = colContType;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public void setStartDateLb(Label startDateLb) {
		this.startDateLb = startDateLb;
	}

	public void setDurationLb(Label durationLb) {
		this.durationLb = durationLb;
	}

	public void setAdditionalCostLb(Label additionalCostLb) {
		this.additionalCostLb = additionalCostLb;
	}

	public void setNoOfInstLb(Label noOfInstLb) {
		this.noOfInstLb = noOfInstLb;
	}

	public void setIntRateLB(Label intRateLB) {
		this.intRateLB = intRateLB;
	}

	public void initialize() {
		ObservableList<String> contracts = FXCollections.observableArrayList("Purchase","Tenancy");
		getContractType().setItems(contracts);
		searchPerson();
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
	
	@FXML
	public void editCont(ActionEvent evt){
		//to-do
	}

	@FXML
	public void searchByName(ActionEvent evt){
		searchPerson();
	}
	
	public void searchPerson(){
		List<Person> persons = new Person().searchPerson(getSearchName().getText());
		getPersTable().setItems(convertPersons(persons));
		configurePersonTableColumns();
	}
	
	@FXML
	public void searchByContNumb(ActionEvent evt){
		//to-do search code.
	}
	
	public ObservableList<PersonView> convertPersons(List<Person> estateList) {
		ObservableList<PersonView> estateOblist = FXCollections.observableArrayList();
		for (Person estate : estateList) {
			estateOblist.add(new PersonView(estate.getId()+"",estate.getFirstName(),estate.getName(),estate.getAddress()));
		}
		return estateOblist;
	}
	
	public void configurePersonTableColumns() {
		getColFirstName().setCellValueFactory(new PropertyValueFactory<PersonView,String>("firstName"));
		getColName().setCellValueFactory(new PropertyValueFactory<PersonView,String>("name"));
		getColAddress().setCellValueFactory(new PropertyValueFactory<PersonView,String>("address"));
		
	}
}
