package db.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import application.EstUtility;

public class Apartment {
	
	public Apartment() {
		
	}
	
	int id;
	
	String city;
	
	int postalCode;
	
	String street;
	
	int streetNumber;
	
	float squareArea;
	
	int floor;
	
	float rooms;
	
	String balcony;
	
	String builtInKitchen;
	
	int eagId;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postalCode
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the streetNumber
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the squareArea
	 */
	public float getSquareArea() {
		return squareArea;
	}

	/**
	 * @param squareArea the squareArea to set
	 */
	public void setSquareArea(float squareArea) {
		this.squareArea = squareArea;
	}

	/**
	 * @return the floor
	 */
	public int getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}

	/**
	 * @return the rooms
	 */
	public float getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(float rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the balcony
	 */
	public String getBalcony() {
		return balcony;
	}

	/**
	 * @param balcony the balcony to set
	 */
	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}

	/**
	 * @return the builtInKitchen
	 */
	public String getBuiltInKitchen() {
		return builtInKitchen;
	}

	/**
	 * @param builtInKitchen the builtInKitchen to set
	 */
	public void setBuiltInKitchen(String builtInKitchen) {
		this.builtInKitchen = builtInKitchen;
	}

	/**
	 * @return the eagId
	 */
	public int getEagId() {
		return eagId;
	}

	/**
	 * @param eagId the eagId to set
	 */
	public void setEagId(int eagId) {
		this.eagId = eagId;
	}
	
	public void saveApartment() {
		String query = "Insert INTO APARTMENT(city,postalCode,street,streetNumber,squareArea,floor,rooms,balcony,builtInKitchen,eagId) values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);
		
		try {
			pst.setString(1, this.getCity());
			pst.setInt(2, this.getPostalCode());
			pst.setString(3, this.getStreet());
			pst.setInt(4, this.getStreetNumber());
			pst.setFloat(5, this.getSquareArea());
			pst.setInt(6, this.getFloor());
			pst.setFloat(7, this.getRooms());
			pst.setString(8, this.getBalcony());
			pst.setString(9, this.getBuiltInKitchen());
			pst.setInt(10, this.getEagId());

			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
	public void updateApartment(int id) {
		String query = "UPDATE APARTMENT set city = ? ,postalCode = ?, street = ?, streetNumber = ?, squareArea = ?, floor = ?, rooms = ?, balcony = ?, builtInKitchen = ?, eagId = ? WHERE id = ?";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		try {
			pst.setString(1, this.getCity());
			pst.setInt(2, this.getPostalCode());
			pst.setString(3, this.getStreet());
			pst.setInt(4, this.getStreetNumber());
			pst.setFloat(5, this.getSquareArea());
			pst.setInt(6,this.getFloor());
			pst.setFloat(7,this.getRooms());
			pst.setString(8,this.getBalcony());
			pst.setString(9,this.getBuiltInKitchen());
			pst.setInt(10,this.getEagId());

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteApartment(int id) {
		String query = "DELETE FROM APARTMENT where id = ?";
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
	
	public List<Apartment> searchApartment() {
		String query = "SELECT * FROM APARTMENT";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);
		List<Apartment> apartmentList = new ArrayList<Apartment>();
		try {
			ResultSet rs = pst.executeQuery();
			Apartment apartment;
			if (rs != null) {

				while (rs.next()) {
					apartment = new Apartment();
					apartment.setId(rs.getInt(1));
					apartment.setCity(rs.getString(2));
					apartment.setPostalCode(rs.getInt(3));
					apartment.setStreet(rs.getString(4));
					apartment.setStreetNumber(rs.getInt(5));
					apartment.setSquareArea(rs.getFloat(6));
					apartment.setFloor(rs.getInt(7));
					apartment.setRooms(rs.getInt(8));
					apartment.setBalcony(rs.getString(9));
					apartment.setBuiltInKitchen(rs.getString(10));
					apartment.setEagId(rs.getInt(11));
					apartmentList.add(apartment);
				}
				
			}
			EstUtility.handleDbStuffs(null, pst, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apartmentList;
	}
}
