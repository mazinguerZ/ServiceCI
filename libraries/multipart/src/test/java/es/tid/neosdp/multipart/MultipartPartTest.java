package es.tid.neosdp.multipart;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

public class MultipartPartTest {

	private Logger logger=Logger.getLogger(this.getClass().toString());
	
	//this is the content encodinf for all message
	private static final String MESSAGE_CONTENT_ENCODING="UTF-8";
	private static final String BOUNDARY = "--URFNfBE4vb9UxaPOU9e_bBkq1WiwQroju3XgnN";
	
	private MultipartPart cte7bit_charsetASCII_part;
	private MultipartPart cte7bit_charsetUTF8_part;
	private byte[] cte7bit_charsetASCII_partBytes;
	private byte[] cte7bit_charsetUTF8_partBytes;
	
	@Before
	public void setUp(){
		try {
			cte7bit_charsetASCII_partBytes = getFileRootPartBytes("multipart_cte7bit_charsetASCII.txt");
			cte7bit_charsetUTF8_partBytes = getFileRootPartBytes("multipart_cte7bit_charsetUTF8.txt");
		} catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private byte[] getFileRootPartBytes(String filename) throws IOException{

		byte[] multipartBytes = getFileContentAsBytes(filename);
		
		byte[] boundaryBytes = BOUNDARY.getBytes();
		ArrayList<Integer> indexes = ByteArrayChopper.getIndexes(multipartBytes, boundaryBytes);
				
		byte[] name = "name=\"root-fields\"".getBytes();
		indexes = ByteArrayChopper.getIndexesWithName(multipartBytes, boundaryBytes, name);
		int start = indexes.get(0);
		int end = indexes.get(1);
		
		return ArrayUtils.subarray(multipartBytes, start, end);
		
	}
	
	@Test
	public void test(){
		try{
			logger.info("CTE:7bit,Charset:US-ASCII MessageBytes:"+cte7bit_charsetASCII_partBytes);
			logger.info("CTE:7bit,Charset:UTF-8 MessageBytes:"+cte7bit_charsetUTF8_partBytes);
			
			//--------------------------------------------------------
			//PROCESS Content-Transfer-Encoding: 7bit (charset-> UTF-8)
			cte7bit_charsetUTF8_part=new MultipartPart(cte7bit_charsetUTF8_partBytes,MESSAGE_CONTENT_ENCODING);
			Iterator<String> it=cte7bit_charsetUTF8_part.headers.keySet().iterator();
			while (it.hasNext()){
				String headerContent=it.next();
				assertNotNull(headerContent);
				logger.info("Header->" + it + ": " + headerContent);
			}
			logger.info("Body as string:\n"+cte7bit_charsetUTF8_part.getBody());
			assertNotNull(cte7bit_charsetUTF8_part.getBody());
			
			logger.info("CompleteMessage:\n"+cte7bit_charsetUTF8_part.toString());
			assertNotNull(cte7bit_charsetUTF8_part.toString());
			
			//---------------------------------------------------------
			//PROCESS Content-Transfer-Encoding: 7bit (charset-> US-ASCII)
			cte7bit_charsetASCII_part=new MultipartPart(cte7bit_charsetASCII_partBytes,MESSAGE_CONTENT_ENCODING);
			it=cte7bit_charsetASCII_part.headers.keySet().iterator();
			while (it.hasNext()){
				String headerContent=it.next();
				assertNotNull(headerContent);
				logger.info("Header->" + it + ": " + headerContent);
			}
			logger.info("Body as string:\n"+cte7bit_charsetASCII_part.getBody());
			assertNotNull(cte7bit_charsetASCII_part.getBody());
			
			logger.info("CompleteMessage:\n"+cte7bit_charsetASCII_part.toString());
			assertNotNull(cte7bit_charsetASCII_part.toString());
			
			
		}catch (IOException ioe){
			fail(ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	
	byte[] getFileContentAsBytes(String fileName)throws IOException {
		InputStream is = ByteArrayChopperTest.class.getResourceAsStream("/" + fileName);
		byte[] bytes = IOUtils.toByteArray(is);
		is.close();
		return bytes;
	}

}
