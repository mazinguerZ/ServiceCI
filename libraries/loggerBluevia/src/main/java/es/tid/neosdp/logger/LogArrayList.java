package es.tid.neosdp.logger;

import java.util.ArrayList;


/**
 * Class that extends ArrayList<String> overriding toString()
 * 
 * @author rps
 *
 */
public class LogArrayList extends ArrayList<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4345136902376065589L;

	@Override
	public String toString() {
		Object[] array = super.toArray();
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Object ele: array) {
			if (!first) sb.append('\n');
			else first = false;
			sb.append(ele.toString());			
		}
		return sb.toString();
	}
}
