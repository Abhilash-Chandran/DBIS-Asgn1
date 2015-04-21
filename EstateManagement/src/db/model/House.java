/**
 * 
 */
package db.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import application.EstUtility;
/**
 * @author genieass
 *
 */
public class House {
	
	public House() {
		
	}
	
	int id;
	
	String city;
	
	int postalCode;
	
	String street;
	
	int streetNumber;
	
	float squareArea;
	
	int floor;
	
	float price;
	
	String garden;
	
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
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the garden
	 */
	public String getGarden() {
		return garden;
	}

	/**
	 * @param garden the garden to set
	 */
	public void setGarden(String garden) {
		this.garden = garden;
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

	public void saveHouse() {
		String query = "Insert INTO HOUSE(city,postalCode,street,streetNumber,squareArea,floor,price,garden,eagId) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);
		
		try {
			pst.setString(1, this.getCity());
			pst.setInt(2, this.getPostalCode());
			pst.setString(3, this.getStreet());
			pst.setInt(4, this.getStreetNumber());
			pst.setFloat(5, this.getSquareArea());
			pst.setInt(6, this.getFloor());
			pst.setFloat(7, this.getPrice());
			pst.setString(8, this.getGarden());
			pst.setInt(9, this.getEagId());

			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void updateHouse(int id) {
		String query = "UPDATE HOUSE set city = ? ,postalCode = ?, street = ?, streetNumber = ?, squareArea = ?, floor = ?, price = ?, garden = ?, eagId = ? WHERE id = ?";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

		try {
			pst.setString(1, this.getCity());
			pst.setInt(2, this.getPostalCode());
			pst.setString(3, this.getStreet());
			pst.setInt(4, this.getStreetNumber());
			pst.setFloat(5, this.getSquareArea());
			pst.setInt(6,this.getFloor());
			pst.setFloat(7,this.getPrice());
			pst.setString(8,this.getGarden());
			pst.setInt(9,this.getEagId());

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteHouse(int id) {
		String query = "DELETE FROM HOUSE where id = ?";
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
	
	public List<House> searchHouse() {
		String query = "SELECT * FROM HOUSE";
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);
		List<House> houseList = new ArrayList<House>();
		try {
			ResultSet rs = pst.executeQuery();
			House house;
			if (rs != null) {

				while (rs.next()) {
					house = new House();
					house.setId(rs.getInt(1));
					house.setCity(rs.getString(2));
					house.setPostalCode(rs.getInt(3));
					house.setStreet(rs.getString(4));
					house.setStreetNumber(rs.getInt(5));
					house.setSquareArea(rs.getFloat(6));
					house.setFloor(rs.getInt(7));
					house.setPrice(rs.getInt(8));
					house.setGarden(rs.getString(9));
					house.setEagId(rs.getInt(10));
					houseList.add(house);
				}
				
			}
			EstUtility.handleDbStuffs(null, pst, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return houseList;
	}
}
