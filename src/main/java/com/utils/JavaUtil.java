package com.utils;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class JavaUtil {

	public static boolean isDirectoryExist(String directoryPath) {

		boolean isDirectoryExist = false;

		File file = new File(directoryPath);

		if (file.exists()) {
			isDirectoryExist = true;
		}

		return isDirectoryExist;
	}

	public static boolean isFileExist(String filePath) {

		boolean isFileExist = false;

		File file = new File(filePath);

		if (file.exists()) {
			isFileExist = true;
		}

		return isFileExist;
	}

	public static File createDirectoryIfNotExist(String directoryPath) {

		File file = new File(directoryPath);

		if (!file.exists()) {
			file.mkdir();
		}

		return file;
	}

	public static File createFileIfNotExist(String filePath) {

		File file = new File(filePath);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return file;
	}

}
