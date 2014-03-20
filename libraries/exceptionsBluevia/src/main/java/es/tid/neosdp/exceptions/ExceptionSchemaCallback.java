/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.tid.neosdp.representations.schema.FileSchemaCallback;

/**
 * Implements SchemaCallback to provide the location of UNICA XML schemas for management
 * of UNICA exceptions.
 * XML schemas are stored in the directory /schemas
 *
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class ExceptionSchemaCallback extends FileSchemaCallback {

	/**
	 * Path to the properties file with the mapping between filenames and namespaces (for XML schemas related to UNICA exceptions)
	 */
	private final static String SCHEMAS_MAPPING_PATH = "/properties/schemas-mapping.properties";

	/**
	 * Logger
	 */
	private final static Logger logger = Logger.getLogger(ExceptionSchemaCallback.class.getName());

	static {
		try {
			InputStream inputStream = ExceptionSchemaCallback.class.getResourceAsStream(ExceptionSchemaCallback.SCHEMAS_MAPPING_PATH);
			FileSchemaCallback.loadSchemasMapping(inputStream);
		} catch(Throwable t) {
			logger.log(Level.WARNING, "Error adding the mappings for exception schemas", t);
		}
	}
}