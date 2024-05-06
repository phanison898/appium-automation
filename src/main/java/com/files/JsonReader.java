package com.files;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class JsonReader {

	private String filePath = null;

	public JsonReader(String filePath) {
		this.filePath = filePath;
	}

	public JsonObject read() {
		Gson gson = new Gson();

		FileReader fileReader = null;

		try {
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		JsonObject jo = gson.fromJson(fileReader, JsonObject.class);

		return jo;
	}

}
