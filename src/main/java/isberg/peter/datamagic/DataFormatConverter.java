package isberg.peter.datamagic;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import isberg.peter.datamagic.enums.DataFormatType;
import sun.misc.BASE64Decoder;

public class DataFormatConverter {

	private BASE64Decoder base64Decoder = new BASE64Decoder();

	public String convert(String data, DataFormatType dataFormatType) {
		String result = null;
		switch (dataFormatType) {
		case BASE64:
			result = decodeBase64ToString(data);
			break;
		case BINARY:
			result = covertBinaryToString(data);
			break;
		case HEXADECIMAL:
			result = convertHexToString(data);
			break;
		}

		return result;
	}

	private String decodeBase64ToString(String base64Data) {
		String result = null;
		try {
			byte[] decodedBuffer = base64Decoder.decodeBuffer(base64Data);
			result = new String(decodedBuffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private String covertBinaryToString(String binaryData) {
		String result = null;
		try {
			result = new String(binaryData.getBytes(), 0, binaryData.length(), "ASCII");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private String convertHexToString(String hexData) {
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < hexData.length() - 1; i += 2) {
			String output = hexData.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);

			temp.append(decimal);
		}

		return sb.toString();
	}
}
