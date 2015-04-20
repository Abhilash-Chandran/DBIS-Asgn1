package application;

import db.model.Agent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	Label message;

	@FXML
	Label userName;

	@FXML
	Label password;

	@FXML
	TextField userNameTxt;

	@FXML
	PasswordField passwordTxt;

	@FXML
	Button loginButton;

	@FXML
	Button resetButton;

	@FXML
	Button adminButton;

	Stage prevStage;

	public void initialize() {
		setMessage("Welcome to Estate Manager..");
	}

	public Label getMessage() {
		return this.message != null ? this.message : new Label();
	}

	public void setMessage(String message) {
		getMessage().setText(message);
	}

	public Label getUserName() {
		return this.userName;
	}

	public void setUserName(Label userName) {
		this.userName = userName;
	}

	public Label getPassword() {
		return password;
	}

	public void setPassword(Label password) {
		this.password = password;
	}

	public TextField getUserNameTxt() {
		return userNameTxt;
	}

	public void setUserNameTxt(TextField userNameTxt) {
		this.userNameTxt = userNameTxt;
	}

	public PasswordField getPasswordTxt() {
		return passwordTxt;
	}

	public void setPasswordTxt(PasswordField passwordTxt) {
		this.passwordTxt = passwordTxt;
	}

	public Stage getPrevStage() {
		return prevStage;
	}

	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}

	@FXML
	public void login(ActionEvent event) {
		String userName = getUserNameTxt().getText();
		String password = getPasswordTxt().getText();
		Agent currentAgent = new Agent().login(userName, password);
		if(currentAgent != null){
			EstUtility.setCurrentAgent(currentAgent);
			new EstUtility().navigate("Estate.fxml", "Hi "+EstUtility.getCurrentAgent().getName() + " Welome to Estate Management.");
		}else{
			setMessage("Incorrect Login! Please try again.");
		}
	}

	@FXML
	public void reset(ActionEvent event){
		getUserNameTxt().setText("");
		getPasswordTxt().setText("");
	}
	
	@FXML
	public void admin(ActionEvent evt) {
		if ("blah".equals(getUserNameTxt().getText())  
				&& "blah".equals(getPasswordTxt().getText())) {
			new EstUtility().navigate("Admin.fxml", "Welcome Admin Mr.Blah.");
		}else{
			setMessage("Incorrect Login! Please try again.");
		}
	}
}
