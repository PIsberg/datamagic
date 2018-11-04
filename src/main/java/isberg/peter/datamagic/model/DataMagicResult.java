package isberg.peter.datamagic.model;

import isberg.peter.datamagic.enums.DataFormatType;

public class DataMagicResult {

	private String orginalData;
	private String convertedData;
	private DataFormatType dataFormatType;

	public String getOrginalData() {
		return orginalData;
	}

	public void setOrginalData(String orginalData) {
		this.orginalData = orginalData;
	}

	public String getConvertedData() {
		return convertedData;
	}

	public void setConvertedData(String convertedData) {
		this.convertedData = convertedData;
	}

	public DataFormatType getDataFormatType() {
		return dataFormatType;
	}

	public void setDataFormatType(DataFormatType dataFormatType) {
		this.dataFormatType = dataFormatType;
	}
	
	

}
