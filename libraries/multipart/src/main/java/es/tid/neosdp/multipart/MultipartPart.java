/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.multipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.ArrayUtils;

/**
 * MultipartPart objects stores each multipart part data 
 * 
 * @author rps
 * @author Daniel Munoz Rivas daniel.munoz@amaris.com
 */

public class MultipartPart {

	private static final String PART_DEFAULT_CHARSET = "UTF-8";
	private static final String CONTENT_TYPE_LABEL = "CONTENT-TYPE:";
	private static final String CHARSET_LABEL = "CHARSET=";
	private static final String CONTENT_TRANSFER_ENCODING_LABEL = "CONTENT-TRANSFER-ENCODING:";
	private static final String DEFAULT_CONTENT_ENCODING = PART_DEFAULT_CHARSET;
	
	private final static Logger logger = Logger.getLogger(MultipartPart.class.getName());
	
	Map<String, String> headers;
	StringBuilder headersSB;
	ByteArrayOutputStream bodyBytes;

	/**
	 * Charset included in content-type header for this part. Null if content-type does not include any charset
	 */
	private String charset;
	
	
	/**
	 * Constructor. Builds a multipart taking content as byte array. This way of building the part is not charset dependant
	 * @param partData byte array with complete content for the part
	 * @param contentEncoding encoding read for complete multipart message. UTF-8 is taken as default if not present any encoding value
	 * @throws IOException
	 */
	public MultipartPart(byte[] partData, String contentEncoding) throws IOException{
		
		try{
			//assign default charset to charset var
			charset=PART_DEFAULT_CHARSET;
			//FIXME String partContentTransferEncoding=PART_DEFAULT_CONTENT_TRANSFER_ENCODING;
			//create string buffer to store part content while it is been generated in a String
			headersSB = new StringBuilder();
			bodyBytes = new ByteArrayOutputStream();
			headers = new HashMap<String, String>();
			if ((contentEncoding==null)||(contentEncoding.length()==0)){
				contentEncoding=DEFAULT_CONTENT_ENCODING;
			}
			//split byte data into lines
			byte[] lineSeparatorBytes=Constants.NEWLINE_DELIMITER.getBytes();
			ArrayList<Integer> indexesArray=ByteArrayChopper.getIndexes(partData, lineSeparatorBytes);
			if (indexesArray!=null){
				int indexesArraySize=indexesArray.size();
				if (indexesArraySize>0){
					int startIndex=-1;
					int endIndex=-1;
					//take first lines as headers until find a blank line
					boolean isHeaderLine=true;
					for (Integer i : indexesArray){
						startIndex=endIndex+1;
						endIndex=i.intValue();
						byte[] lineAsBytes=ArrayUtils.subarray(partData, startIndex, endIndex);
						String lineAsString=new String(lineAsBytes,contentEncoding);
						if (isHeaderLine){
							String lineToUpper=lineAsString.toUpperCase();
							if (lineToUpper.startsWith(CONTENT_TYPE_LABEL)){
								int indexOfCharsetLabel=lineToUpper.indexOf(CHARSET_LABEL);
								if (indexOfCharsetLabel!=-1){
									int charsetLabelEnd=indexOfCharsetLabel + CHARSET_LABEL.length();
									charset=lineAsString.substring(charsetLabelEnd,lineAsString.length()).trim();
								}
								addHeader(lineAsString);
							}
							else if (lineToUpper.startsWith(CONTENT_TRANSFER_ENCODING_LABEL)){
								//FIXME partContentTransferEncoding=lineAsString.substring(CONTENT_TRANSFER_ENCODING_LABEL.length()).trim();
								addHeader(lineAsString);
							}
							//take the case the delimiter for new line is \r\n. In this case, the blank line will have \r as content
							else if ((lineAsString.length()==0)||(lineAsString.equals("\r"))){
								isHeaderLine=false;
								//next lines to read are the content.
								//headersSB.append(lineAsString).append(Constants.NEWLINE_DELIMITER);
							}
							else if (!lineAsString.startsWith("--")) {
								//add header
								addHeader(lineAsString);
							}
						}else{
							//add line bytes to body bytes
							bodyBytes.write(lineAsBytes);
							bodyBytes.write(lineSeparatorBytes);
						}
					}
				}
			}
			
			//fill Content-Type header if not present in this part. 
			//It will be treated to guess its content between json or xml by regarding body first char to be { or any other
			fillContentTypeIfNull(contentEncoding);
			
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error parsing a multipart part", e);
		}
	}

	
	/**
	 * Fills content type header if not present yet. The value for this header will be application/json if content starts with { or
	 * application/xml otherwise
	 * @throws UnsupportedEncodingException 
	 */
	private void fillContentTypeIfNull(String contentEncoding) throws UnsupportedEncodingException{
		String currentContentType=this.getContentHeader("Content-Type");
		if ((currentContentType==null)||(currentContentType.length()==0)){
			//evaluate body to see if startswith {
			String body = bodyBytes.toString(contentEncoding);
			if ((body!=null)&&(body.startsWith("{"))){
				this.addHeader("Content-Type: application/json");
			}else{
				this.addHeader("Content-Type: application/xml");
			}
		}
	}
	
	/**
	 * Constructor
	 * 
	 * @param part Part string
	 * @throws IOException 
	 */
	public MultipartPart(String part) throws IOException {
		bodyBytes = new ByteArrayOutputStream();

		String[] lines = part.split(Constants.NEWLINE_DELIMITER);
		boolean isHeader = true;
		//boolean isFirstLine = true;
		headers = new HashMap<String, String>();
		//headerLines = new Vector<String>();
		for (String line: lines) {
			if (isHeader) {
				//if (logger != null) logger.debug("line.length: " + line.length());
				if (line.length() <= 1) {
					//if (isFirstLine) isFirstLine = false;
					//else
					isHeader = false;
					continue;
				} else {
					if (line.startsWith("--")) continue;
					addHeader(line);
				}				
			} else {
				bodyBytes.write(line.getBytes());
				bodyBytes.write(Constants.NEWLINE_DELIMITER.getBytes());
			}
		}		
	}
	
	/**
	 * Constructor
	 * 
	 * @param headers 
	 * @param body
	 * @throws IOException 
	 */
	public MultipartPart(String[] header_lines, ByteArrayOutputStream bodyBytes) throws IOException {
		this.headers = new HashMap<String, String>();
		headersSB = new StringBuilder();
		for (String line: header_lines) {
			headersSB.append(line + Constants.NEWLINE_DELIMITER);
			addHeader(line);
		}
		
		bodyBytes.write(bodyBytes.toByteArray());
	}

	/**
	 * Get the content header with name "name" of the MultipartPart 
	 * 
	 * @param name
	 * @return
	 */
	public String getContentHeader(String name) {
		return headers.get(name.toUpperCase());
	}
	
	/**
	 * Get part body without content headers
	 * @return
	 */
	public  ByteArrayOutputStream getBody() {
		return this.bodyBytes;
	}

	/**
	 * Get part body without content headers in String representation
	 * @return 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public  String getBodyAsString() throws UnsupportedEncodingException {
		return bodyBytes.toString(charset);
	}
	
	public String getCharset(){
		return charset;
	}
	
	/**
	 * Get full part body (with content headers)
	 * @return
	 */
	public String toString() {
		String headersAndBody = headersSB.toString();
		try {
			headersAndBody += bodyBytes.toString(charset);
        } catch (UnsupportedEncodingException e) {
        	logger.log(Level.WARNING, "Error transform body bytes to String", e);
        }
		return headersAndBody;
	}
	
	void addHeader(String header_line) {
		logger.fine("Adding Multipart header: " + header_line);
		String[] header = header_line.split(Constants.HEADER_DELIMITER);
		//add header if : separator character has been found
		if ((header!=null)&&(header.length>1)){
			headers.put(header[0].toUpperCase(), header[1].trim());
			headersSB.append(header_line + Constants.NEWLINE_DELIMITER);
		}
	}

	public void removeHeader(String header_name) {
		logger.fine("Removing Multipart header: " + header_name);
		
		if ((header_name!=null)&&(headers.remove(header_name.toUpperCase())!=null)){
			
			int startIndexHeaderLine = headersSB.indexOf(header_name);
			int endIndexHeaderLine = headersSB.indexOf(Constants.NEWLINE_DELIMITER,startIndexHeaderLine) + 1;
			headersSB.delete(startIndexHeaderLine, endIndexHeaderLine);
		}
	}
	
	public void replaceBoundary(String oldBoundary,String newBoundary){
		logger.fine("Replacing boundary from '" + oldBoundary + "' to '" + newBoundary + "'" );
		String aux = headersSB.toString();
		headersSB = new StringBuilder(aux.replaceFirst(Constants.BOUNDARY_PREFIX + oldBoundary, Constants.BOUNDARY_PREFIX + newBoundary));
	}

    public StringBuilder getHeadersSB() {
    
    	return headersSB;
    }	
	
}
