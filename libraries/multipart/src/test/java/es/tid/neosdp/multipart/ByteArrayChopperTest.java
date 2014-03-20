/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.multipart;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

public class ByteArrayChopperTest {

	String multipart;
	String part1body;
	String part2;
	String boundary;
	
	byte[] multipartBytes;
	byte[] newPartBytes;
	byte[] newMultipartBytes;
	
    @Before
    public void setUp() {
    	boundary = "--URFNfBE4vb9UxaPOU9e_bBkq1WiwQroju3XgnN";
		try {
			multipartBytes = getFileContentAsBytes("multipart.txt");
			newPartBytes = getFileContentAsBytes("newPart.txt");
			newMultipartBytes = getFileContentAsBytes("newMultipart.txt");
		} catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
    }


	@Test
	public void test(){
		
		byte[] boundaryBytes = boundary.getBytes();
		ArrayList<Integer> indexes = ByteArrayChopper.getIndexes(multipartBytes, boundaryBytes);
				
		byte[] name = "name=\"root-fields\"".getBytes();
		indexes = ByteArrayChopper.getIndexesWithName(multipartBytes, boundaryBytes, name);
		int start = indexes.get(0);
		int end = indexes.get(1);
		
		byte[] rfPart = ArrayUtils.subarray(multipartBytes, start, end);

		byte[] newFileBytes = ByteArrayChopper.replacePart(multipartBytes, start, end, newPartBytes);
		
		assertTrue(newFileBytes.length == newMultipartBytes.length);
		assertTrue(Arrays.equals(newFileBytes, newMultipartBytes));	
	}

	
	byte[] getFileContentAsBytes(String fileName)throws IOException {
		InputStream is = ByteArrayChopperTest.class.getResourceAsStream("/" + fileName);
		byte[] bytes = IOUtils.toByteArray(is);
		is.close();
		return bytes;
	}
}
