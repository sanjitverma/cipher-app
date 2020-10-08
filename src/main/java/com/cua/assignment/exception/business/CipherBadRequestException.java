package com.cua.assignment.exception.business;

import com.cua.assignment.util.ExceptionUtil;
import org.springframework.util.StringUtils;

import java.util.Map;

public class CipherBadRequestException extends RuntimeException {

    public CipherBadRequestException(Class cl, String... searchParamsMap) {
        super(CipherBadRequestException.generateMessage(cl.getSimpleName(), ExceptionUtil.toMap(String.class, String.class, searchParamsMap)));

    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) +
                " was not found for parameters " +
                searchParams;
    }

}
