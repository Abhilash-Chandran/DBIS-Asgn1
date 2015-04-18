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
import view.AgentView;
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
	TableView<AgentView> agentTable;

	@FXML
	TableColumn<AgentView, String> colName;

	@FXML
	TableColumn<AgentView, String> colAddress;

	@FXML
	TableColumn<AgentView, String> colLogin;

	@FXML
	TableColumn<AgentView, String> colPwd;

	@FXML
	Label message;

	public TableView<AgentView> getAgentTable() {
		return agentTable;
	}

	public void setAgentTable(TableView<AgentView> agentTable) {
		this.agentTable = agentTable;
	}

	public TextField getLogin() {
		return login;
	}

	public void setLogin(TextField login) {
		this.login = login;
	}

	public TableColumn<AgentView, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<AgentView, String> colName) {
		this.colName = colName;
	}

	public TableColumn<AgentView, String> getColAddress() {
		return colAddress;
	}

	public void setColAddress(TableColumn<AgentView, String> colAddress) {
		this.colAddress = colAddress;
	}

	public TableColumn<AgentView, String> getColLogin() {
		return colLogin;
	}

	public void setColLogin(TableColumn<AgentView, String> colLogin) {
		this.colLogin = colLogin;
	}

	public TableColumn<AgentView, String> getColPwd() {
		return colPwd;
	}

	public void setColPwd(TableColumn<AgentView, String> colPwd) {
		this.colPwd = colPwd;
	}

	public TextField getPassword() {
		return password;
	}

	public void setPassword(TextField password) {
		this.password = password;
	}

	public Label getMessage() {
		return this.message != null ? this.message : new Label();
	}

	public void setMessage(String message) {
		getMessage().setText(message);
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
	public void clear() {
		new EstUtility().cancel();
	}
	
	public void initialize(){
		search();
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
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMessage("Save Successfull.");
		search();
	}
	
	
	
	@FXML
	public void delete(ActionEvent evt) {
		String login = getAgentTable().getSelectionModel().getSelectedItem().getLogin();
		new Agent().deleteAgent(login);
		setMessage("Save Successfull.");
		search();
	}
	
	@FXML
	public void refreshSearch(ActionEvent evt) {
		search();
	}
	public void search(){
		List<Agent> agentList = (new Agent()).searchAgent();
		ObservableList<AgentView> agentOblist = convert(agentList);
		configureTableColumns();
		getAgentTable().setItems(agentOblist);	
	}

	@FXML
	public void logout(ActionEvent event) {
		new EstUtility().navigate("LoginPage.fxml", "Estate Management Login");
	}

	public ObservableList<AgentView> convert(List<Agent> agentList) {
		ObservableList<AgentView> agentOblist = FXCollections.observableArrayList();
		for (Agent agent : agentList) {
			agentOblist.add(new AgentView(agent.getName(), agent.getAddress(), agent.getLogin(), agent.getPassword()));
		}
		return agentOblist;
	}

	public void configureTableColumns() {
		getColName().setCellValueFactory(new PropertyValueFactory<AgentView,String>("name"));
		getColAddress().setCellValueFactory(new PropertyValueFactory<AgentView,String>("address"));
		getColLogin().setCellValueFactory(new PropertyValueFactory<AgentView,String>("login"));
		getColPwd().setCellValueFactory(new PropertyValueFactory<AgentView,String>("password"));
	}

	@FXML
	public void cancel(ActionEvent evt) {

	}
}
