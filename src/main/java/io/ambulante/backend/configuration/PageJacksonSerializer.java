package io.ambulante.backend.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import java.io.IOException;

@JsonComponent
@SuppressWarnings("rawtypes")
public class PageJacksonSerializer extends StdSerializer<Page> {

	public PageJacksonSerializer() {
		super(Page.class);
	}

	@Override
	public void serialize(Page page, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
		jsonGenerator.writeStartObject();
		writeContent(page, jsonGenerator);
		jsonGenerator.writeEndObject();
	}

	private void writeContent(final Page page, final JsonGenerator jsonGenerator) throws IOException {
		jsonGenerator.writeObjectField("content", page.getContent());
		jsonGenerator.writeFieldName("page");
		jsonGenerator.writeStartObject();
		writePageInfo(page, jsonGenerator);
		jsonGenerator.writeEndObject();
	}

	private void writePageInfo(final Page page, final JsonGenerator jsonGenerator) throws IOException {
		jsonGenerator.writeNumberField("totalPages", page.getTotalPages());
		jsonGenerator.writeNumberField("totalElements", page.getTotalElements());
		jsonGenerator.writeNumberField("size", page.getNumberOfElements());
		jsonGenerator.writeNumberField("number", page.getNumber());
	}
}
