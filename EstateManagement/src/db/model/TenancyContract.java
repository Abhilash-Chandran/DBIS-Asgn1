package db.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.EstUtility;

public class TenancyContract {
	public TenancyContract(){
		
	}
		int contractno;
		
		int TC_apartment_ID;
		
		int TC_PERSON_ID;
		
		Date ContractDate;
		
		Date StartDate;
		
		int Duration;
		
		int Additional_Costs;
		
		String Place;
		
		
	public int getContractno() {
			return contractno;
		}

		public void setContractno(int contractno) {
			this.contractno = contractno;
		}

		public int getTC_apartment_ID() {
			return TC_apartment_ID;
		}

		public void setTC_apartment_ID(int tC_apartment_ID) {
			TC_apartment_ID = tC_apartment_ID;
		}

		public int getTC_PERSON_ID() {
			return TC_PERSON_ID;
		}

		public void setTC_PERSON_ID(int tC_PERSON_ID) {
			TC_PERSON_ID = tC_PERSON_ID;
		}

		public Date getContractDate() {
			return ContractDate;
		}

		public void setContractDate(Date contractDate) {
			ContractDate = contractDate;
		}

		public Date getStartDate() {
			return StartDate;
		}

		public void setStartDate(Date startDate) {
			StartDate = startDate;
		}

		public int getDuration() {
			return Duration;
		}

		public void setDuration(int duration) {
			Duration = duration;
		}

		public int getAdditional_Costs() {
			return Additional_Costs;
		}

		public void setAdditional_Costs(int additional_Costs) {
			Additional_Costs = additional_Costs;
		}

		public String getPlace() {
			return Place;
		}

		public void setPlace(String place) {
			Place = place;
		}

		public void saveContract() {
			String query = "Insert INTO TENANCYCONTRACT(ContractNo,TC_apartment_ID,TC_PERSON_ID,ContractDate,StartDate,Duration,Additional_Costs, Place) values (?,?,?,?,?,?)";
			PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

			try {
				pst.setInt(1, this.getContractno());
				pst.setInt(2, this.getTC_apartment_ID());
				pst.setInt(3, this.getTC_PERSON_ID());
				pst.setDate(4, this.getContractDate());
				pst.setDate(5, this.getStartDate());
				pst.setInt(6, this.getDuration());
				pst.setInt(7, this.getAdditional_Costs());
				pst.setString(8, this.getPlace());
				pst.execute();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void updateContract() {
			String query = "UPDATE TENANCYCONTRACT set ContractNo = ? TC_apartment_ID = ? TC_PERSON_ID = ? ContractDate = ? StartDate = ? ,Duration = ?, Additional_Costs = ?, Place = ?)";
			PreparedStatement pst = EstUtility.PreparedStatementSearch(query, true);

			try {
				pst.setInt(1, this.getContractno());
				pst.setInt(2, this.getTC_apartment_ID());
				pst.setInt(3, this.getTC_PERSON_ID());
				pst.setDate(4, this.getContractDate());
				pst.setDate(5, this.getStartDate());
				pst.setInt(6, this.getDuration());
				pst.setInt(7, this.getAdditional_Costs());
				pst.setString(8, this.getPlace());

				pst.executeUpdate();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void deleteContract(String ContractNo) {
			String query = "DELETE FROM TenancyContract where ContractNo = ?";
			PreparedStatement pst = EstUtility.PreparedStatementSearch(query, false);

			try {
				pst.setString(1, ContractNo);

				pst.execute();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			}
	

}
