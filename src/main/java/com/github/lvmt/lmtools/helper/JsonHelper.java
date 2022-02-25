package com.github.lvmt.lmtools.helper;

import java.io.IOException;
import java.io.UncheckedIOException;

import javax.annotation.Nullable;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.github.lvmt.lmtools.exception.UncheckedJsonProcessingException;
import com.hubspot.jackson.datatype.protobuf.ProtobufModule;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-25
 * JsonHelper depends on Jackson
 */
public final class JsonHelper {

    private static final String EMPTY_JSON = "{}";
    private static final String EMPTY_ARRAY_JSON = "[]";

    private static final ObjectMapper MAPPER = new ObjectMapper(new JsonFactoryBuilder()
            .configure(Feature.INTERN_FIELD_NAMES, true).build())
            .registerModule(new GuavaModule());

    static {
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MAPPER.enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature());
        MAPPER.enable(JsonParser.Feature.ALLOW_COMMENTS);
        MAPPER.registerModule(new ParameterNamesModule());
        MAPPER.registerModule(new KotlinModule());
        MAPPER.registerModule(new ProtobufModule());
    }

    @Nullable
    public static String toJSON(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new UncheckedJsonProcessingException(e);
        }
    }

    private static RuntimeException wrapException(IOException e) {
        if (e instanceof JsonProcessingException) {
            return new UncheckedJsonProcessingException((JsonProcessingException) e);
        } else {
            return new UncheckedIOException(e);
        }
    }

    public static <T> T fromJSON(@Nullable String json, Class<T> valueType) {
        if (json == null) {
            return null;
        }
        try {
            return MAPPER.readValue(json, valueType);
        } catch (IOException e) {
            throw wrapException(e);
        }
    }
}
