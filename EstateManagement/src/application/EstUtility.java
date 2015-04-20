package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.connection.DB2ConnectionManager;
import db.model.Agent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EstUtility {

	public EstUtility() {

	}

	public static Stage prevStage;

	public static Stage currStage;

	public static Agent currentAgent;

	public static Agent getCurrentAgent() {
		return currentAgent;
	}

	public static void setCurrentAgent(Agent currentAgent) {
		EstUtility.currentAgent = currentAgent;
	}

	public static Stage getCurrStage() {
		return currStage;
	}

	public static void setCurrStage(Stage currStage) {
		EstUtility.currStage = currStage;
	}

	public static Stage getPrevStage() {
		return prevStage;
	}

	public static void setPrevStage(Stage globalState) {
		EstUtility.prevStage = globalState;
	}

	public static void hidePrev() {
		prevStage.close();
	}

	public static void hideCurr() {
		currStage.close();
	}

	/**
	 * Please make sure you call this method after every DB transactions.
	 * 
	 * @param con
	 * @param pst
	 * @param rs
	 */
	public static void handleDbStuffs(Connection con, PreparedStatement pst,
			ResultSet rs) {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != pst) {
				pst.close();
			}
			if (null != con) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * One stop connection and prepare statement dealing.
	 * 
	 * @param query
	 * @return
	 */
	public static PreparedStatement PreparedStatementSearch(String query,
			boolean forInsert) {
		try {
			if (forInsert) {
				return DB2ConnectionManager
						.getInstance()
						.getConnection()
						.prepareStatement(query,
								PreparedStatement.RETURN_GENERATED_KEYS);
			}
			return DB2ConnectionManager.getInstance().getConnection()
					.prepareStatement(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void navigate(String screen, String title) {
		try {
			EstUtility.setPrevStage(EstUtility.getCurrStage());
			EstUtility.getCurrStage().hide();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource(screen));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle(title);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			EstUtility.setCurrStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancel() {
		try {
			EstUtility.getCurrStage().close();
			EstUtility.setCurrStage(EstUtility.getPrevStage());
			EstUtility.getPrevStage().show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
