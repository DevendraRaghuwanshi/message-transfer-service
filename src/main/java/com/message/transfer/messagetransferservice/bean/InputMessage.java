package com.message.transfer.messagetransferservice.bean;

import java.io.Serializable;

/**
 * @author draghuwanshi
 *
 */
public class InputMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String actualMidiaType;
	private String requiredMidiaType;
	private InputPayload inputPayload;

	public InputMessage() {
	}

	public InputMessage(String actualMidiaType, String requiredMidiaType, InputPayload inputPayload) {
		super();
		this.actualMidiaType = actualMidiaType;
		this.requiredMidiaType = requiredMidiaType;
		this.inputPayload = inputPayload;
	}

	public String getActualMidiaType() {
		return actualMidiaType;
	}

	public void setActualMidiaType(String actualMidiaType) {
		this.actualMidiaType = actualMidiaType;
	}

	public String getRequiredMidiaType() {
		return requiredMidiaType;
	}

	public void setRequiredMidiaType(String requiredMidiaType) {
		this.requiredMidiaType = requiredMidiaType;
	}

	public InputPayload getInputPayload() {
		return inputPayload;
	}

	public void setInputPayload(InputPayload inputPayload) {
		this.inputPayload = inputPayload;
	}

	@Override
	public String toString() {
		return "InputMessage [actualMidiaType=" + actualMidiaType + ", requiredMidiaType=" + requiredMidiaType
				+ ", inputPayload=" + inputPayload + "]";
	}
}
