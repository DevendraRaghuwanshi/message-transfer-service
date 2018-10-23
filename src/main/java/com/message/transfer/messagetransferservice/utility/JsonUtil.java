/**
 * 
 */
package com.message.transfer.messagetransferservice.utility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.transfer.messagetransferservice.bean.Item;

/**
 * @author draghuwanshi
 *
 */
public class JsonUtil {

	public static List<?> readJsonArrayFromFile(String fileName, Class<?> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<?> list = objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        return list;
    }
	

	public static String readJsonFromFile(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item object = objectMapper.readValue(new File(fileName), Item.class);
        return object.toString();
    }
}
