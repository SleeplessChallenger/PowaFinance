package com.powafinance.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {
    public static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
}
