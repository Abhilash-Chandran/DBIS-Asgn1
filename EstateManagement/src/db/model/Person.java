package db.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void updatePerson(int id) {
		String query = "UPDATE PERSON set firstName = ? ,name = ?, address = ? WHERE id = ?";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		try {
			pst.setString(1, this.getFirstName());
			pst.setString(2, this.getName());
			pst.setString(3, this.getAddress());

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Person> searchPerson(String name){
		String query = "SELECT * FROM PERSON";
		if(name != null && !name.isEmpty()){
			query = query + " where name = ?";
		}
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		List<Person> persontList = new ArrayList<Person>();
		try {
			if(name != null && !name.isEmpty()){
				pst.setString(1, name);
			}
			ResultSet rs = pst.executeQuery();
			Person person;
			if (rs != null) {

				while (rs.next()) {
					person = new Person();
					person.setName(rs.getString(3));
					person.setAddress(rs.getString(4));
					person.setFirstName(rs.getString(2));
					person.setId(rs.getInt(1));
					persontList.add(person);
				}
			}
			EstUtility.handleDbStuffs(null, pst, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persontList;
	}
	
	public void deletePerson(int id) {
		String query = "DELETE FROM PERSON where id = ?";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, false);

		try {
			pst.setInt(1, id);

			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
