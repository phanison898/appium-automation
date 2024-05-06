package com.config;

import com.files.JsonReader;
import com.google.gson.JsonObject;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

	private static JsonObject jo = null;

	private static String platformName = null;

	private static Dotenv env = null;

	private static String getSecret(String key) {
		if (env == null) {
			env = Dotenv.load();
		}
		return env.get(key);
	}

	public static String getPlatformName() {
		return platformName;
	}

	public static void setPlatformName(String platformName) {
		Config.platformName = platformName;
	}

	public static String getUsername() {
		return getSecret("SAUCE_USERNAME");
	}

	public static String getAccessKey() {
		return getSecret("SAUCE_ACCESS_KEY");
	}

	public static String getAppiumServerUrl() {
		return getSecret("SAUCE_URL");
	}

	public static boolean isScreenshots() {
		return getAppJsonObject().get("screenshots").getAsBoolean();
	}

	public static boolean isHeadless() {
		return getAppJsonObject().get("headless").getAsBoolean();
	}

	public static long getPageLoadWaitTime() {
		return getAppJsonObject().get("timeouts").getAsJsonObject().get("page-load-wait-time").getAsLong();
	}

	public static long getImplicitWaitTime() {
		return getAppJsonObject().get("timeouts").getAsJsonObject().get("implicit-wait-time").getAsLong();
	}

	public static long getExplicitWaitTime() {
		return getAppJsonObject().get("timeouts").getAsJsonObject().get("explicit-wait-time").getAsLong();
	}

	public static long getScriptLoadWaitTime() {
		return getAppJsonObject().get("timeouts").getAsJsonObject().get("script-load-wait-time").getAsLong();
	}

	public static String getReportName() {
		return getJsonObject().get("report").getAsJsonObject().get("name").getAsString();
	}

	public static String getReportTitle() {
		return getJsonObject().get("report").getAsJsonObject().get("title").getAsString();
	}

	public static String getReportTheme() {
		return getJsonObject().get("report").getAsJsonObject().get("theme").getAsString();
	}

	public static String getAuthorName() {
		return getJsonObject().get("author").getAsJsonObject().get("name").getAsString();
	}

	public static String getAutherGithubUsername() {
		return getJsonObject().get("author").getAsJsonObject().get("github-username").getAsString();
	}

	public static String getAuthorEmail() {
		return getJsonObject().get("author").getAsJsonObject().get("email").getAsString();
	}

	private static JsonObject getJsonObject() {

		if (jo == null) {

			JsonReader jsonReader = new JsonReader(Paths.JSON_CONFIG_FILE);
			jo = jsonReader.read();
		}

		return jo;
	}

	private static JsonObject getAppJsonObject() {

		JsonObject jo = null;

		if (jo == null) {

			jo = getJsonObject().get("app").getAsJsonObject();
		}
		return jo;
	}

}
