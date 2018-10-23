/**
 * 
 */
package com.message.transfer.messagetransferservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.transfer.messagetransferservice.bean.Item;
import com.message.transfer.messagetransferservice.service.MessageTransferGateway;

/**
 * @author draghuwanshi
 *
 */
@RestController
@RequestMapping("/message")
public class MessageTransferController {

	private static final Logger logger = LoggerFactory.getLogger(MessageTransferController.class);

	@Autowired
	MessageTransferGateway messageTransferGateway;

	/*
	 * This method accepting JSON with XML as input body payload and return response
	 * into JSON
	 */
	/*@PostMapping
	public PurchaseOrder receivedInputMessageIntoJson(@RequestBody InputMessage inputMessage) {
		logger.debug("Input Json Message Process Start");
		return messageTransferGateway.processeReceivedInputJsonMessage(inputMessage);

	}*/

	/*
	 * This method accepting XML as input payload and return response into XML
	 */
	@PostMapping(path = "/itemxmltoxml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public Item convertInputXMLMessageIntoXML(@RequestBody Item item) {
		logger.debug("receivedInputMessageXMLIntoXML :: Start");
		Item itemXml=messageTransferGateway.processeReceivedInputXMLMessageToXML(item);
		logger.debug("receivedInputMessageXMLIntoXML :: End");
		return itemXml;
	}

	/*
	 * This method accepting XML as input payload and return response into JSON
	 */
	@PostMapping(path = "/itemxmltojson", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item convertInputXMLMessageIntoJson(@RequestBody Item item) {
		logger.debug("convertInputXMLMessageIntoJson :: Start");
		Item itemJson=messageTransferGateway.processeReceivedInputXMLMessageToJson(item);
		logger.debug("convertInputXMLMessageIntoJson :: End");
		return itemJson;

	}

	/*
	 * This method accepting JSON as input payload and return response into JSON
	 */
	@PostMapping(path = "/itemjsontojson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item convertInputJsonMessageIntoJson(@RequestBody Item item) {
		logger.debug("convertInputJsonMessageIntoJson :: Start");
		Item itemJson=messageTransferGateway.processeReceivedInputJsonMessageToJson(item);
		logger.debug("convertInputJsonMessageIntoJson :: End");
		return itemJson;

	}

	/*
	 * This method accepting JSON as input payload and return response into JSON
	 */
	@PostMapping(path = "/itemjsontoxml", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public Item convertInputJsonMessageIntoXML(@RequestBody Item item) {
		logger.debug("convertInputJsonMessageIntoXML :: Start");
		 Item itemXml=messageTransferGateway.processeReceivedInputJsonMessageToXML(item);
		logger.debug("convertInputJsonMessageIntoXML :: End");
		return itemXml;

	}

}
