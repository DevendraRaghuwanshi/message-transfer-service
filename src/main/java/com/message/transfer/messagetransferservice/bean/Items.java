package com.message.transfer.messagetransferservice.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Items")
public class Items {
	private List<Item> items;

	public Items() {
	}

	public Items(List<Item> items) {
		super();
		this.items = items;
	}

	@XmlElement(name = "Item")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Items [items=" + items + "]";
	}

}
