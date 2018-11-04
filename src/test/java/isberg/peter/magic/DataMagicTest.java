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
		String binaryData = "Ó]t×M4Ó]tÓ]5Ó]t×]4Ó]t×]4Ó]t×]uÓMtÓM4Ó]t×]5Ó]tÓM5Ó]tÓ]uÓ]t×M5Ó]tÓMuÓMtÓM4Ó]tÓMtÓ]t×M5Ó]t×]tÓ]tÓM5Ó]uÓMtÓ]u×M5ÓMtÓM4Ó]uÓ]uÓ]t×]uÓ]uÓMtÓ]t×]4Ó]tÓ]4";

		// When
		DataMagicResult magicResult = classUnderTest.doMagic(binaryData);

		// Then
		assertEquals("hello magic binary world", magicResult.getConvertedData());
	}
}
