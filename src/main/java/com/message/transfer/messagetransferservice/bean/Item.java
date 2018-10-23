package com.message.transfer.messagetransferservice.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Item")
@XmlType (propOrder={"productName","quantity","usPrice","comment","shipDate"})
public class Item {
	private String productName;
	private int quantity;
	private double usPrice;
	private String comment;
	private String shipDate;

	public Item() {
	}

	public Item(String productName, int quantity, double usPrice, String comment, String shipDate) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.usPrice = usPrice;
		this.comment = comment;
		this.shipDate = shipDate;
	}

	@XmlElement(name = "ProductName")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@XmlElement(name = "Quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@XmlElement(name = "USPrice")
	public double getUsPrice() {
		return usPrice;
	}

	public void setUsPrice(double usPrice) {
		this.usPrice = usPrice;
	}

	@XmlElement(name = "Comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@XmlElement(name = "ShipDate")
	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	@Override
	public String toString() {
		return "Item [productName=" + productName + ", quantity=" + quantity + ", usPrice=" + usPrice + ", comment="
				+ comment + ", shipDate=" + shipDate + "]";
	}

}
