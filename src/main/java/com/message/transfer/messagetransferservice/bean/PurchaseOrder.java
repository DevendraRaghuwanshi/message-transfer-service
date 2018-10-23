package com.message.transfer.messagetransferservice.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrder")	
public class PurchaseOrder {

	private Address address;

	private Items items;

	private String deliveryNotes;

	public PurchaseOrder() {
	}

	public PurchaseOrder(Address address, Items items, String deliveryNotes) {
		super();
		this.address = address;
		this.items = items;
		this.deliveryNotes = deliveryNotes;
	}

	@XmlElement(name = "Address")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@XmlElement(name = "Items")
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@XmlElement(name = "DeliveryNotes")
	public String getDeliveryNotes() {
		return deliveryNotes;
	}

	public void setDeliveryNotes(String deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [address=" + address + ", items=" + items + ", deliveryNotes=" + deliveryNotes + "]";
	}

}
