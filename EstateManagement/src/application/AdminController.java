package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import db.model.Agent;

public class AdminController {
	
	@FXML
	int id;

	@FXML
	TextField login;

	@FXML
	TextField password;
	
	@FXML
	TextField name;
	
	@FXML
	TextField address;
	
	@FXML
	TableView<Agent> agentTable;
	
	@FXML
	TableColumn<Agent, String> colName;
	
	@FXML
	TableColumn<Agent, String> colAddress;

	@FXML
	TableColumn<Agent, String> colLogin;

	@FXML
	TableColumn<Agent, String> colPwd;
	
	@FXML
	Label message;
	
	public TableView<Agent> getAgentTable() {
		return agentTable;
	}

	public void setAgentTable(TableView<Agent> agentTable) {
		this.agentTable = agentTable;
	}
	
	public TextField getLogin() {
		return login;
	}

	public void setLogin(TextField login) {
		this.login = login;
	}

	public TextField getPassword() {
		return password;
	}

	public void setPassword(TextField password) {
		this.password = password;
	}
	
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
			Agent agent = new Agent();
			agent.setName(getName().getText());
			agent.setAddress(getAddress().getText());
			agent.setLogin(getLogin().getText());
			agent.setPassword(getPassword().getText());
			agent.saveAgent();
			setMessage(new Label("Save Successfull."));
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void refreshSearch(ActionEvent evt){
		List<Agent> agentList = (new Agent()).searchAgent();
		ObservableList<Agent> agentOblist = FXCollections.observableArrayList(agentList);
		setAgentTable(new TableView<Agent>(agentOblist));
	}
	
	@FXML
	public void logout(ActionEvent event){
		new EstUtility().navigate("LoginPage.fxml", "Estate Management Login"); 
	}
	
	public ObservableList<Agent> convert(List<Agent> agentList){
		ObservableList<Agent> agentOblist;
		List<Admin> agents = new ArrayList<Agent>();
		for(Agent agent: agentList){
			A
		}
	}
}
