package isberg.peter.datamagic;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.commons.codec.binary.Base64;

import isberg.peter.datamagic.enums.DataFormatType;

public class DataFormatDetector {

	private CharsetEncoder charsetEncoder;

	public DataFormatDetector() {
		charsetEncoder = Charset.forName("UTF-8").newEncoder();
	}

	public DataFormatType detect(String data) {

		DataFormatType result = null;
		
		boolean isBase64 = Base64.isBase64(data.getBytes(Charset.forName("UTF-8")));
		if (isBase64) {
			return DataFormatType.BASE64;
		}


		//else if(!isASCII) {
			// is binary?
			return DataFormatType.BINARY;
		//}
		
		// TODO: borked?
//		boolean isHexedecimal = isHexdecimal(data);
//		if (isHexedecimal) {
//			return DataFormatType.HEXADECIMAL;
//		}
//		// TODO: borked?
//		boolean isASCII = charsetEncoder.canEncode(data);
//		if (isASCII) {
//			return DataFormatType.ASCII;
//		}
		
		
	}

	private boolean isHexdecimal(String data) {
		boolean result = false;
		try {
			Long.parseLong(data, 16);
			result = true;
		} catch (NumberFormatException ex) {
			result = false;
		}

		return result;
	}

}
