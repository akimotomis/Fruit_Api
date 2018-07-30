package com.example;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{

	public JsonpAdvice() {
        super("callback");
	}

    @Bean
    public MappingJackson2HttpMessageConverter MappingJackson2HttpMessageConverter(ApplicationContext ctx) {
        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().applicationContext(ctx).build();
        return new MappingJackson2HttpMessageConverter(mapper) {
            @Override
            protected void writePrefix(JsonGenerator generator, Object obj) throws IOException {
                if (!(obj instanceof MappingJacksonValue))
                    return;
                String funcName = ((MappingJacksonValue) obj).getJsonpFunction();
                if (funcName != null)
                    generator.writeRaw(funcName + "(");
            }
        };
    }
}
