/**
 * 
 */
package com.message.transfer.messagetransferservice.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.message.transfer.messagetransferservice.bean.Item;
import com.message.transfer.messagetransferservice.controller.MessageTransferController;
import com.message.transfer.messagetransferservice.service.MessageTransferGateway;

/**
 * @author draghuwanshi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = MessageTransferController.class, secure = false)
public class MessageTransferControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(MessageTransferControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	Environment enviroment;

	@MockBean
	private MessageTransferGateway messageTransferGateway;

	MvcResult result = null;

	Item item = new Item("Baby Monitor", 1, 39.98, "test123", "2018-10-22");

	String exampleItemXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<Item>"
			+ "<ProductName>Baby Monitor</ProductName>" + "<Quantity>1</Quantity>" + "<USPrice>39.98</USPrice>"
			+ "<Comment>test123</Comment>" + "<ShipDate>2018-10-22</ShipDate>" + "</Item>";

	String exampleItemJson = "{\"productName\":\"Baby Monitor\",\"quantity\":1,\"usPrice\":39.98,\"comment\":\"test123\",\"shipDate\":\"2018-10-22\"}";

	@Test
	public void convertInputJsonMessageIntoJsonTest() throws Exception {
		logger.debug("convertInputJsonMessageIntoJsonTest :: Start");
		Mockito.when(messageTransferGateway.processeReceivedInputJsonMessageToJson(Mockito.any(Item.class)))
				.thenReturn(item);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/message/itemjsontojson")
				.accept(MediaType.APPLICATION_JSON)
				.content(exampleItemJson)
				.contentType(MediaType.APPLICATION_JSON);
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			JSONAssert.assertEquals(exampleItemJson,
					result.getResponse().getContentAsString(), false);
			logger.debug("convertInputJsonMessageIntoJsonTest :: End");
		} catch (Exception e) {
			logger.error("Error in convertInputJsonMessageIntoJsonTest "+e.getMessage());
			e.printStackTrace();
		}

	}

	@Test
	public void convertInputXMLMessageIntoJsonTest() throws Exception {
		logger.debug("convertInputXMLMessageIntoJsonTest :: Start");
		Mockito.when(messageTransferGateway.processeReceivedInputXMLMessageToJson(Mockito.any(Item.class)))
				.thenReturn(item);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/message/itemxmltojson")
				.accept(MediaType.APPLICATION_JSON).content(exampleItemXml).contentType(MediaType.APPLICATION_XML);

		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			JSONAssert.assertEquals(exampleItemJson, result.getResponse().getContentAsString(), false);
			logger.debug("convertInputXMLMessageIntoJsonTest :: End");
		} catch (Exception e) {
			logger.error("Error in convertInputXMLMessageIntoJsonTest "+e.getMessage());
			e.printStackTrace();
		}

	}

	@Test
	public void convertInputXMLMessageIntoXMLTest() throws Exception {
		logger.debug("convertInputXMLMessageIntoXMLTest :: Start");
		Mockito.when(messageTransferGateway.processeReceivedInputXMLMessageToXML(Mockito.any(Item.class)))
				.thenReturn(item);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/message/itemxmltoxml")
				.accept(MediaType.APPLICATION_XML).content(exampleItemXml).contentType(MediaType.APPLICATION_XML);
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			assertEquals(exampleItemXml, result.getResponse().getContentAsString());
			logger.debug("convertInputXMLMessageIntoXMLTest :: End");
		} catch (Exception e) {
			logger.error("Error in convertInputXMLMessageIntoXMLTest "+e.getMessage());
			e.printStackTrace();
		}

	}

	@Test
	public void convertInputJsonMessageIntoXMLTest() throws Exception {
		logger.debug("convertInputJsonMessageIntoXMLTest :: Start");
		Mockito.when(messageTransferGateway.processeReceivedInputJsonMessageToXML(Mockito.any(Item.class)))
				.thenReturn(item);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/message/itemjsontoxml")
				.accept(MediaType.APPLICATION_XML).content(exampleItemJson).contentType(MediaType.APPLICATION_JSON);
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			assertEquals(exampleItemXml, result.getResponse().getContentAsString());
			logger.debug("convertInputJsonMessageIntoXMLTest :: End");
		} catch (Exception e) {
			logger.error("Error in convertInputXMLMessageIntoXMLTest "+e.getMessage());
			e.printStackTrace();
		}
	}

}
