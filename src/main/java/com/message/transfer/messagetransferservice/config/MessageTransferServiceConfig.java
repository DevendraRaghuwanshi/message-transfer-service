/**
 * 
 */
package com.message.transfer.messagetransferservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.messaging.MessageChannel;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author draghuwanshi
 *
 */
@Configuration
@EnableIntegration
@IntegrationComponentScan
public class MessageTransferServiceConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageTransferServiceConfig.class);

	@Bean
	public MessageChannel reciveMessageChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel replyMessageChannel() {
		return new DirectChannel();
	}

	@Bean
	@Transformer(inputChannel = "received.inputmessage.channel", outputChannel = "received.inputmessage.objectToJson.channel")
	public ObjectToJsonTransformer objectToJsonTransformer() {
		logger.debug("Process input xml to json object");
		return new ObjectToJsonTransformer(getMapper());
	}

	@Bean
	public Jackson2JsonObjectMapper getMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return new Jackson2JsonObjectMapper(objectMapper);
	}
}
