/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms.ob;
/**
 * Factory class to get OBSizeCalculator objects.
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 */
public enum OB {
	/**
	 * Argentina obId.
	 */
	OB_ARGENTINA("722070", new OB_Argentina(160, 70)), // GSM7 o UCS2 - Variable values 160/70
	/**
	 * Mexico obId.
	 */
	OB_MEXICO("33403", new OB_Mexico(160)),	// GSM7 - Max 160 chars
	/**
	 * UK obId.
	 */
	OB_UK("23411", new OB_UK(160)),	// GSM7 - Max 160 chars
	/**
	 * Spain obId.
	 */
	OB_SPAIN("21407", new OB_Spain(160)),	// GSM7 with extensions - Max 160 chars
	/**
	 * Germany obId.
	 */
	OB_GERMANY("26207", new OB_Germany(160)), // GSM7 adaptation for germany - Max 160 chars
	/**
	 * Colombia obId.
	 */
	OB_COLOMBIA("732123", new OB_Colombia(160, 70)), // GSM7 o UCS2 - Variable values 160/70
	/**
	 * Chile obId.
	 */
	OB_CHILE("73007", new OB_Chile(140)),	// ISO 8859-1 - Max 140 chars
	/**
	 * Brazil obId.
	 */
	OB_BRASIL("72410", new OB_Brasil(140));	// ISO 8859-1 - Max 140 chars
	/**
	 * Private var used to store the value of the ID.
	 */
	private String obId;
	/**
	 * Private var used to store the calculator object for each OB
	 */
	private OBSizeCalculator obSizeCalculator;
	
	/**
	 * Private constructor...
	 * @param obId
	 * @param obSizeCalculator
	 */
	private OB(final String obId, final OBSizeCalculator obSizeCalculator) {
		this.obId = obId;
		this.obSizeCalculator = obSizeCalculator;
	}
	
	/**
	 * Method to get the value of the current obId.
	 * @return obId of the ID of the OB.
	 */
	public String getObId() {
		return obId;
	}
	
	/**
	 * Method to get the value of the current obSizeCalculator.
	 * @return obSizeCalculator.
	 */
	public OBSizeCalculator getObSizeCalculator() {
		return obSizeCalculator;
	}
	/**
	 * Get an OB object from an obId value.
	 *
	 * @param v Value of the operation.
	 * @return Operation object.
	 */
	public static OB fromObId(final String obId) {
        for (OB c: OB.values()) {
            if (c.obId.equalsIgnoreCase(obId)) {
                return c;
            }
        }
        throw new IllegalArgumentException(obId);
    }
}