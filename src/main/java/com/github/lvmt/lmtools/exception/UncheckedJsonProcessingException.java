package com.github.lvmt.lmtools.exception;

import java.io.IOException;
import java.io.UncheckedIOException;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-25
 *
 * Unchecked version of {@link JsonProcessingException}
 */
public class UncheckedJsonProcessingException extends UncheckedIOException {

    public UncheckedJsonProcessingException(JsonProcessingException cause) {
        super(cause.getMessage(), cause);
    }
}
