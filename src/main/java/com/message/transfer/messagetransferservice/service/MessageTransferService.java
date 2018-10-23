/**
 * 
 */
package com.message.transfer.messagetransferservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.message.transfer.messagetransferservice.bean.InputMessage;
import com.message.transfer.messagetransferservice.bean.Item;
import com.message.transfer.messagetransferservice.bean.PurchaseOrder;

/**
 * @author draghuwanshi
 *
 */
@Component
public class MessageTransferService {

	private static final Logger logger = LoggerFactory.getLogger(MessageTransferService.class);

	@ServiceActivator(inputChannel = "received.inputmessage.channel")
	public void processReceivedInputMessageToJson(Message<InputMessage> message) {
		logger.debug("processReceivedInputMessageToJson :: Start");
		try {
			MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
			MessageBuilder.fromMessage(message);
			Message<PurchaseOrder> newmessage = MessageBuilder
					.withPayload(message.getPayload().getInputPayload().getPurchaseOrder()).build();
			replyChannel.send(newmessage);
			logger.debug("processReceivedInputMessageToJson :: End");
		} catch (MessagingException e) {
			logger.error("Error in sending output json to reuest" + e.getMessage());
			e.printStackTrace();
		}

	}

	@ServiceActivator(inputChannel = "received.inputmessage.xml.channel")
	public void processReceivedXMLInputMessageToXML(Message<Item> message) {
		logger.debug("processReceivedXMLInputMessageToXML :: Start");
		try {
			MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
			MessageBuilder.fromMessage(message);
			Message<Item> newmessage = MessageBuilder.withPayload(message.getPayload()).build();
			replyChannel.send(newmessage);
			logger.debug("processReceivedXMLInputMessageToXML :: End");
		} catch (MessagingException e) {
			logger.error("Error in sending output xml to reuest" + e.getMessage());
			e.printStackTrace();
		}

	}

	@ServiceActivator(inputChannel = "received.inputmessage.channel")
	public void processReceivedXMLInputMessageToJson(Message<Item> message) {
		logger.debug("processReceivedXMLInputMessageToJson :: Start");
		try {
			MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
			MessageBuilder.fromMessage(message);
			Message<Item> newmessage = MessageBuilder.withPayload(message.getPayload()).build();
			replyChannel.send(newmessage);
			logger.debug("processReceivedXMLInputMessageToJson :: End");
		} catch (MessagingException e) {
			logger.error("Error in sending output json to request" + e.getMessage());
			e.printStackTrace();
		}

	}

	@ServiceActivator(inputChannel = "received.inputmessage.channel")
	public void processReceivedJsonInputMessageToJson(Message<Item> message) {
		logger.debug("processReceivedJsonInputMessageToJson :: Start");
		try {
			MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
			MessageBuilder.fromMessage(message);
			Message<Item> newmessage = MessageBuilder.withPayload(message.getPayload()).build();
			replyChannel.send(newmessage);
			logger.debug("processReceivedJsonInputMessageToJson :: End");
		} catch (MessagingException e) {
			logger.error("Error in sending output json to request" + e.getMessage());
			e.printStackTrace();
		}

	}

	@ServiceActivator(inputChannel = "received.inputmessage.xml.channel")
	public void processReceivedJsonInputMessageToXML(Message<Item> message) {
		logger.debug("processReceivedJsonInputMessageToXML :: Start");
		try {
			MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
			MessageBuilder.fromMessage(message);
			Message<Item> newmessage = MessageBuilder.withPayload(message.getPayload()).build();
			replyChannel.send(newmessage);
			logger.debug("processReceivedJsonInputMessageToXML :: End");
		} catch (MessagingException e) {
			logger.error("Error in sending output xml to request" + e.getMessage());
			e.printStackTrace();
		}

	}

}
