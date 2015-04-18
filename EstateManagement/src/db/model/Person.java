package db.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.EstUtility;

public class Person {

	public Person() {

	}

	int id;
	
	String firstName;
	
	String Name; //Last name
	
	String Address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	public void savePerson(){
		String query = "Insert INTO PERSON (First_name,name,address) values (?,?,?)";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);
		
		try {
			pst.setString(1, this.getFirstName());
			pst.setString(2, this.getName());
			pst.setString(3, this.getAddress());
			
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
