package net.txeis.unity.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateDeserializer extends StdDeserializer<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7001286694788173901L;

	public CustomDateDeserializer() {
		this(null);
	}

	public CustomDateDeserializer(java.lang.Class<String> t) {
		super(t);
	}

	@Override
	public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String cstDate = null;
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);						
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date myDate = dateFormat.parse(p.getText());
/*
			DateFormat cstFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			cstFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			cstDate = cstFormat.format(myDate);
*/
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return p.getText();
//		return cstDate;

	}

}
