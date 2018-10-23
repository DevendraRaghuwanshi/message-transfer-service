/**
 * 
 */
package com.message.transfer.messagetransferservice.bean;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author draghuwanshi
 *
 */
public class PurchaseOrderDeserializer extends JsonDeserializer<PurchaseOrder> {
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderDeserializer.class);

	@Override
	public PurchaseOrder deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		logger.debug("Inut message unmarshaling start");
		Unmarshaller unmarshaller = null;
		PurchaseOrder purchaseOrder = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
			unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			logger.error("Error in unmarshalling input payload"+e.getMessage());
		}

		StringReader reader = new StringReader(p.getValueAsString());
		try {
			purchaseOrder = (PurchaseOrder) unmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			logger.error("Error in unmarshalling input payload"+e.getMessage());
		}
		logger.debug("Inut message unmarshaling end");
		return purchaseOrder;
	}

}
