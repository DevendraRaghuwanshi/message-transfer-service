/**
 * 
 */
package com.message.transfer.messagetransferservice.bean;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author draghuwanshi
 *
 */

public class InputPayload implements Serializable {

	private static final long serialVersionUID = 11223L;
	
	@JsonDeserialize(using = PurchaseOrderDeserializer.class)
	private PurchaseOrder purchaseOrder;

	public InputPayload() {

	}

	public InputPayload(PurchaseOrder purchaseOrder) {
		super();
		this.purchaseOrder = purchaseOrder;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public String toString() {
		return "InputPayload [purchaseOrder=" + purchaseOrder + "]";
	}

}
