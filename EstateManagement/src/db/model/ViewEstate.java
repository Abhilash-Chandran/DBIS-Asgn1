package db.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.EstUtility;

public class ViewEstate {

	public ViewEstate() {
		// TODO Auto-generated constructor stub
	}
	
	int eagId;
	
	String city;
	
	int postalCode;
	
	String street;
	
	int streetNo;
	
	double squareArea;

	public int getEagId() {
		return eagId;
	}

	public void setEagId(int eagId) {
		this.eagId = eagId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public double getSquareArea() {
		return squareArea;
	}

	public void setSquareArea(double squareArea) {
		this.squareArea = squareArea;
	}
	
	public List<ViewEstate> searchEstates(String city, int agentId){
		List<ViewEstate> vwEstates = new ArrayList<ViewEstate>();
		String query = "SELECT * FROM VW_ESTATE_AGENT where eag_id = ?";
		if(null != city && !city.isEmpty()){
			query = query + " and city = ?";
		}
		PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);
		
		try {
			pst.setInt(1, agentId);
			if (null != city && !city.isEmpty()) {
				pst.setString(2, city);
			}
			ResultSet rs = pst.executeQuery();
			ViewEstate estate;
			if (rs != null) {
				while (rs.next()) {
					estate = new ViewEstate();
					estate.setEagId(rs.getInt(1));
					estate.setCity(rs.getString(2));
					estate.setPostalCode(rs.getInt(3));
					estate.setStreet(rs.getString(4));
					estate.setStreetNo(rs.getInt(5));
					estate.setSquareArea(rs.getDouble(6));
					vwEstates.add(estate);
				}
			}
			EstUtility.handleDbStuffs(null, pst, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vwEstates;
	}
}
