package db.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.EstUtility;

public class Agent {

	public Agent() {

	}

	int id;

	String name;

	String address;

	String login;

	String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void saveAgent() {
		String query = "Insert INTO ESTATE_AGENT(name,address,login,password) values (?,?,?,?)";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		try {
			pst.setString(1, this.getName());
			pst.setString(2, this.getAddress());
			pst.setString(3, this.getLogin());
			pst.setString(4, this.getPassword());

			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateAgent(String login) {
		String query = "UPDATE ESTATE_AGENT set name = ? ,address = ?, login = ?, password = ? where login = ? ";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		try {
			pst.setString(1, this.getName());
			pst.setString(2, this.getAddress());
			pst.setString(3, this.getLogin());
			pst.setString(4, this.getPassword());
			pst.setString(5, login);

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAgent(String login) {
		String query = "DELETE FROM ESTATE_AGENT where login = ?";
		PreparedStatement pst = EstUtility
				.PreparedStatementSearch(query, false);

		try {
			pst.setString(1, login);

			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Agent> searchAgent() {
		String query = "SELECT * FROM ESTATE_AGENT";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);
		List<Agent> agentList = new ArrayList<Agent>();
		try {
			ResultSet rs = pst.executeQuery();
			Agent agent;
			if (rs != null) {

				while (rs.next()) {
					agent = new Agent();
					agent.setName(rs.getString(2));
					agent.setAddress(rs.getString(3));
					agent.setLogin(rs.getString(4));
					agent.setPassword(rs.getString(5));
					agentList.add(agent);
				}
			}
			EstUtility.handleDbStuffs(null, pst, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agentList;
	}

	public Agent login(String userName, String password) {
		String query = "SELECT * FROM ESTATE_AGENT where login = ? and password = ?";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, false);
		Agent agent = null;
		try {
			pst.setString(1, userName);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				agent = new Agent();
				agent.setId(rs.getInt(1));
				agent.setName(rs.getString(2));
				agent.setAddress(rs.getString(3));
				agent.setLogin(rs.getString(4));
				agent.setPassword(rs.getString(5));
			}
			EstUtility.handleDbStuffs(null, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agent;
	}
}
