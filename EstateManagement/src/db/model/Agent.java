package db.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

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

	public void updateAgent() {
		String query = "UPDATE ESTATE_AGENT set name = ? ,address = ?, login = ?, password = ?)";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		try {
			pst.setString(1, this.getName());
			pst.setString(2, this.getAddress());
			pst.setString(3, this.getLogin());
			pst.setString(4, this.getPassword());

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAgent() {
		String query = "DELETE ESTATE_AGENT where login = ?)";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		try {
			pst.setString(1, this.getLogin());

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
			pst.setString(1, this.getLogin());
			ResultSet rs = pst.executeQuery();
			Agent agent;
			if (rs != null) {

				while (rs.next()) {
					agent = new Agent();
					agent.setName(rs.getString(1));
					agent.setName(rs.getString(2));
					agent.setName(rs.getString(3));
					agent.setName(rs.getString(4));
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
}
