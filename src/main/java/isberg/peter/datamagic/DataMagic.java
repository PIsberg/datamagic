package isberg.peter.datamagic;

import isberg.peter.datamagic.enums.DataFormatType;
import isberg.peter.datamagic.exceptions.EmptyInputData;
import isberg.peter.datamagic.model.DataMagicResult;

public class DataMagic {

	private DataFormatDetector dataFormatDetector;
	private DataFormatConverter dataFormatConverter;
	private static final int DATA_MAX_LENGTH = 20;

	public DataMagic() {
		dataFormatDetector = new DataFormatDetector();
		dataFormatConverter = new DataFormatConverter();
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @throws EmptyInputData
	 */
	public DataMagicResult doMagic(String data) throws EmptyInputData {
		if (data == null || data.isEmpty()) {
			throw new EmptyInputData("Input data is null or empty!");
		}

		// for performance reason only take a subset of the data into consideration for detection
		String subsetData;
		if(data.length() > 20) {
			subsetData = data.substring(0, DATA_MAX_LENGTH);
		}
		else {
			subsetData = data;
		}
		
		DataMagicResult dataMagicResult = new DataMagicResult();
		dataMagicResult.setOrginalData(data);
		DataFormatType dataFormatType = dataFormatDetector.detect(subsetData);
		dataMagicResult.setDataFormatType(dataFormatType);
		String convertedData = dataFormatConverter.convert(data, dataFormatType);
		dataMagicResult.setConvertedData(convertedData);

		return dataMagicResult;
	}


}
