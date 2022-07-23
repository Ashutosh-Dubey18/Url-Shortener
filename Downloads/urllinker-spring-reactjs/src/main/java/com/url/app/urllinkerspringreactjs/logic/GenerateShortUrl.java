package com.url.app.urllinkerspringreactjs.logic;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.validator.routines.UrlValidator;

import com.google.common.hash.Hashing;

public class GenerateShortUrl {
	
	public static String getShortUrl(String url) {
		
		String shortUrl = encodeUrl(url);
		return shortUrl;
	}
	
	private static String encodeUrl(String url) {
		String encodedUrl = "";
		LocalDateTime time = LocalDateTime.now();
		encodedUrl = Hashing.murmur3_32_fixed().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
		return encodedUrl;
	}

	public static boolean isUrlValid(String url) {
		UrlValidator urlValidator = new UrlValidator(new String[] { "http", "https" });
		boolean result = urlValidator.isValid(url);
		return result;
	}

}