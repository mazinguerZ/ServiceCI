/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.multipart;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import com.eaio.stringsearch.BoyerMooreHorspool;

/**
 * ByteArrayChopper. Library to chop a multipart byte[]
 * 
 * @author rps
 *
 */
public class ByteArrayChopper {
	
	/**
	 * Get an ArrayList containing the indexes of pattern matchings in data byte[]
	 * 
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static ArrayList<Integer> getIndexes(byte[] data, byte[] pattern) {
		BoyerMooreHorspool searchAlgorithm = new BoyerMooreHorspool();
		// To speed up the search process, the multipart pattern is preprocessed
		Object preProcess = searchAlgorithm.processBytes(pattern);
		
		int startIndex = 0;
		int endIndex = data.length;
		
		// Create a list with the index for the beginning of the parts
		ArrayList<Integer> multipartIndexList = new ArrayList<Integer>();
		startIndex = searchAlgorithm.searchBytes(data, startIndex, endIndex, pattern, preProcess);
		if (startIndex != -1)
			multipartIndexList.add(startIndex);
		// Iterate by the message content array until the pattern is not matched anymore
		while (startIndex != -1) {
			int nextIndex = searchAlgorithm.searchBytes(data, startIndex+1, endIndex, pattern, preProcess);
			if (nextIndex != -1)
				multipartIndexList.add(nextIndex);
			startIndex = nextIndex;	
		}
		return multipartIndexList;
	}
	
	/**
	 * Get the first index containing the pattern matchings in data byte[]
	 * 
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static int getFirstIndex(byte[] data, byte[] pattern) {
		BoyerMooreHorspool searchAlgorithm = new BoyerMooreHorspool();
		// To speed up the search process, the multipart pattern is preprocessed
		Object preProcess = searchAlgorithm.processBytes(pattern);
		int startIndex = 0;
		int endIndex = data.length;
		startIndex = searchAlgorithm.searchBytes(data, startIndex, endIndex, pattern, preProcess);
		return startIndex;
	}
	
	/**
	 * Get an ArrayList containing start and end indexes of boundary matchings in data
	 * delimiting a part that contains name
	 * 
	 * @param data
	 * @param boundary
	 * @param name
	 * @return
	 */
	public static ArrayList<Integer> getIndexesWithName(byte[] data, byte[] boundary, byte[] name) {
		BoyerMooreHorspool searchAlgorithm = new BoyerMooreHorspool();
		// To speed up the search process, the multipart pattern is preprocessed
		Object preProcessB = searchAlgorithm.processBytes(boundary);
		Object preProcessN = searchAlgorithm.processBytes(name);
		
		int startIndex = 0;
		int endIndex = data.length;
		
		// Create a list with the index for the beginning of the parts
		ArrayList<Integer> multipartIndexList = new ArrayList<Integer>();
		startIndex = searchAlgorithm.searchBytes(data, startIndex, endIndex, boundary, preProcessB);

		// Iterate by the message content array until the pattern is not matched anymore
		while (startIndex != -1) {
			int nextIndex = searchAlgorithm.searchBytes(data, startIndex+1, endIndex, boundary, preProcessB);
			if (nextIndex != -1) {
				if (searchAlgorithm.searchBytes(data, startIndex+1, endIndex, name, preProcessN) != -1) {
					multipartIndexList.add(startIndex);
					multipartIndexList.add(nextIndex);
					break;
				}
			} 
			startIndex = nextIndex;	
		}
		return multipartIndexList;
	}
	
	/**
	 * Replaces a part in a byte[] beginning with "start" and ending with "end"
	 * 
	 * @param data byte[]
	 * @param start
	 * @param end
	 * @param newPart
	 * @return
	 */
	public static byte[] replacePart(byte[] data, int start, int end, byte[] newPart) {
		byte[] ret = ArrayUtils.subarray(data, 0, start);	
		ret = ArrayUtils.addAll(ret, newPart);
		ret = ArrayUtils.addAll(ret, ArrayUtils.subarray(data, end, data.length));
		return ret;
	}
	
	/**
	 * Insert a new part in a multipart message in insertionPoint parameter index
	 * @param data complete data where insert new part
	 * @param insertionPoint index into data where insert new part
	 * @param newPart byte content of the new part to add
	 * @return complete new data with the new part added to the multipart
	 */
	public static byte[] insertPart(byte[] data, int insertionPoint, byte[] newPart){
		return replacePart(data,insertionPoint,insertionPoint,newPart);
	}	
	
	/**
	 * Get a part of a byte[]. Indexes ArrayList must contain two integers, 
	 * start and end position of the sub-array to be returned.
	 * 
	 * @param data byte[]
	 * @param indexes
	 * @return
	 */
	public static byte[] getPart(byte[] data, ArrayList<Integer> indexes) {
		int rfStart = indexes.get(0);
		int rfEnd = indexes.get(1);
		return ArrayUtils.subarray(data, rfStart, rfEnd);	
	}
}