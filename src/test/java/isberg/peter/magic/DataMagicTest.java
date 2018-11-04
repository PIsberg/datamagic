package isberg.peter.magic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import isberg.peter.datamagic.DataMagic;
import isberg.peter.datamagic.exceptions.EmptyInputData;
import isberg.peter.datamagic.model.DataMagicResult;
import sun.misc.BASE64Encoder;

public class DataMagicTest {

	private DataMagic classUnderTest;

	private BASE64Encoder base64Encoder = new BASE64Encoder();

	private long randomness;

	@Before
	public void setup() {
		classUnderTest = new DataMagic();
		randomness = System.nanoTime();
	}

	@Test
	public void doMagicBase64() throws EmptyInputData {
		// Given
		String data = "hello magic base64 world" + randomness;
		String base64Data = base64Encoder.encode(data.getBytes());

		// When
		DataMagicResult magicResult = classUnderTest.doMagic(base64Data);

		// Then
		assertEquals(data, magicResult.getConvertedData());
	}
	
	@Ignore // work in progress
	@Test
	public void doMagicBinary() throws EmptyInputData {
		// Given
		//hello magic binary world
		String binaryData = "�]t�M4�]t�]5�]t�]4�]t�]4�]t�]u�Mt�M4�]t�]5�]t�M5�]t�]u�]t�M5�]t�Mu�Mt�M4�]t�Mt�]t�M5�]t�]t�]t�M5�]u�Mt�]u�M5�Mt�M4�]u�]u�]t�]u�]u�Mt�]t�]4�]t�]4";

		// When
		DataMagicResult magicResult = classUnderTest.doMagic(binaryData);

		// Then
		assertEquals("hello magic binary world", magicResult.getConvertedData());
	}
}
