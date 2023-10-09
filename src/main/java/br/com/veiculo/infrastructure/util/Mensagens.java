package br.com.veiculo.infrastructure.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class Mensagens {
	
	private static final ResourceBundle MESSAGES_PROPERTIES = ResourceBundle.getBundle("messages");
	
	private Mensagens() {
	}

	public static String get(String key) {
		return MESSAGES_PROPERTIES.getString(key);
	}

	public static String get(String key, Object... args) {
		return MessageFormat.format(get(key), args);
	}

}
