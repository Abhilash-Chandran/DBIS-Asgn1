package view;

import javafx.beans.property.SimpleStringProperty;

public class ContractView {

	private final SimpleStringProperty contractNo;
	private final SimpleStringProperty cntDate;
    private final SimpleStringProperty place;
    private final SimpleStringProperty type;
    
	public ContractView(String contractNo, String cntDate, String place, String type) {
		this.contractNo = new SimpleStringProperty(contractNo);
		this.cntDate = new SimpleStringProperty(cntDate);
        this.place = new SimpleStringProperty(place);
        this.type = new SimpleStringProperty(type);
    }
	
	
	public String getCntDate() {
		return cntDate.get();
	}
	public String getPlace() {
		return place.get();
	}
	public String getContractNo() {
		return contractNo.get();
	}
	
	public String geType() {
		return type.get();
	}
}
