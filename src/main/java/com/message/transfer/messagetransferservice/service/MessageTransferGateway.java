/**
 * 
 */
package com.message.transfer.messagetransferservice.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.message.transfer.messagetransferservice.bean.InputMessage;
import com.message.transfer.messagetransferservice.bean.Item;
import com.message.transfer.messagetransferservice.bean.PurchaseOrder;

/**
 * @author draghuwanshi
 *
 */
@MessagingGateway
public interface MessageTransferGateway {

	@Gateway(requestChannel = "received.inputmessage.channel")
	public PurchaseOrder processeReceivedInputJsonMessage(InputMessage inputMessage);

	@Gateway(requestChannel = "received.inputmessage.xml.channel")
	public Item processeReceivedInputXMLMessageToXML(Item item);

	@Gateway(requestChannel = "received.inputmessage.channel")
	public Item processeReceivedInputXMLMessageToJson(Item item);

	@Gateway(requestChannel = "received.inputmessage.channel")
	public Item processeReceivedInputJsonMessageToJson(Item item);

	@Gateway(requestChannel = "received.inputmessage.xml.channel")
	public Item processeReceivedInputJsonMessageToXML(Item item);
}
