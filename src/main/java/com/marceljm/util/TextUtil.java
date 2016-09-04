package com.marceljm.util;

import java.text.Normalizer;

public class TextUtil {

	public static String normalize(String text) {
		text = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		text = text.toLowerCase();
		text = text.replaceAll("[^a-z0-9]", " ");
		text = text.replaceAll("  ", " ");
		text = text.replaceAll(" ", "-");
		return text;
	}

}
