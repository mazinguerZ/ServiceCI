/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

/**
 * UnicaException for RPC
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class RpcUnicaException extends UnicaException {

	/**
	 * RPC identifier
	 */
	private String rpcId;
	
	/**
	 * RPC version
	 */
	private String rpcVersion;
	
	/**
	 * Constructor
	 * 
	 * @param unicaException
	 * @param rpcId
	 * @param rpcVersion
	 */
	public RpcUnicaException(final UnicaException unicaException, final String rpcId, final String rpcVersion) {
		super(unicaException.getCategoryId());
		this.setText(unicaException.getText());
		this.setParameters(unicaException.getParameters());
		this.setResponseCode(unicaException.getResponseCode());
		this.setRpcId(rpcId);
		this.setRpcVersion(rpcVersion);
	}

	/**
	 * Get the RPC identifier
	 * @return
	 */
	public String getRpcId() {
		return rpcId;
	}

	/**
	 * Set the RPC identifier
	 * 
	 * @param rpcId
	 */
	public void setRpcId(String rpcId) {
		this.rpcId = rpcId;
	}

	/**
	 * Get the RPC version
	 * 
	 * @return
	 */
	public String getRpcVersion() {
		return rpcVersion;
	}

	/**
	 * Set the RPC version
	 * 
	 * @param rpcVersion
	 */
	public void setRpcVersion(String rpcVersion) {
		this.rpcVersion = rpcVersion;
	}
}