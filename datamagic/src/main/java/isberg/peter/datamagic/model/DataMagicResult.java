package isberg.peter.datamagic.model;

import isberg.peter.datamagic.enums.DataFormatType;

public class DataMagicResult {

	private String orginalData;
	private String cleartextData;
	private DataFormatType dataFormatType;

	public String getOrginalData() {
		return orginalData;
	}

	public void setOrginalData(String orginalData) {
		this.orginalData = orginalData;
	}

	public String getCleartextData() {
		return cleartextData;
	}

	public void setCleartextData(String cleartextData) {
		this.cleartextData = cleartextData;
	}

	public DataFormatType getDataFormatType() {
		return dataFormatType;
	}

	public void setDataFormatType(DataFormatType dataFormatType) {
		this.dataFormatType = dataFormatType;
	}
	
	

}
