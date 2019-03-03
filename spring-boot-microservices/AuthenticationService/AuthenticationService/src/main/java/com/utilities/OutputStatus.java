package com.utilities;

public class OutputStatus {
	
	private String outputStatus=Constants.FAILURE;
	private int outputCode = Constants.OUPUT_CODE_FAILURE;
	private Object data = null;
	
	public OutputStatus() {
		super();
	}
	
	public OutputStatus(String outputStatus, int outputCode, Object data) {
		super();
		this.outputStatus = outputStatus;
		this.outputCode = outputCode;
		this.data = data;
	}
	public String getOutputStatus() {
		return outputStatus;
	}
	public void setOutputStatus(String outputStatus) {
		this.outputStatus = outputStatus;
	}
	public int getOutputCode() {
		return outputCode;
	}
	public void setOutputCode(int outputCode) {
		this.outputCode = outputCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "OutputStatus [outputStatus=" + outputStatus + ", outputCode=" + outputCode + ", data=" + data + "]";
	}
	
	

}
