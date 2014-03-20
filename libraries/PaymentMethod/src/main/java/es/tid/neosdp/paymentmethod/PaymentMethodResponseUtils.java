/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.paymentmethod;

import es.tid.neosdp.plainmap.PlainMap;
import es.tid.neosdp.plainmap.PlainMapException;

/**
 * Some Utilities to work with responses ...
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es), Pablo Meirino Feijoo (pmeirino@paradigmatecnologico.com)
 */
public final class PaymentMethodResponseUtils {

    private PaymentMethodResponseUtils() {
        // Utility classes should not have a public or default constructor.
    }

    /**
     * Create a telURI.
     * 
     * @param uri
     * @return
     * @throws PlainMapException
     */
    public static PlainMap createResponse(final Boolean isChargeable, final String reason,
            final String paymentMethodType) throws PlainMapException {
        // Create custom response
        PlainMap pm = new PlainMap();
        // Element 1
        pm.put(PaymentMethodConstants.PAYMENTMETHOD_TYPE_ELEMENT, paymentMethodType);
        if (isChargeable != null) {
            pm.put(PaymentMethodConstants.IS_CHARGEABLE_ELEMENT, isChargeable.toString());
        }
        if (reason != null) {
            pm.put(PaymentMethodConstants.REASON_ELEMENT, reason);
        }
        // Number of Results
        pm.put(PaymentMethodConstants.TOTAL_RESULTS_ELEMENT, PaymentMethodConstants.TOTAL_RESULTS_RESP);
        // Root
        pm.addRootPath("userChargeableStatusList");
        //
        return pm;
    }

    /**
     * Create a telURI.
     * 
     * @param uri
     * @return
     * @throws PlainMapException
     */
    public static PlainMap createResponse(final Boolean isChargeable, final String reason,
            final String paymentMethodType, final String tosUrl) throws PlainMapException {
        // Create custom response
        PlainMap pm = createResponse(isChargeable, reason, paymentMethodType);
        if (tosUrl != null) {
            pm.put(PaymentMethodConstants.TOS_URL_ELEMENT, tosUrl);
        }
        return pm;
    }
}
