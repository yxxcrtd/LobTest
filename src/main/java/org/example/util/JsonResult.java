package org.example.util;

import lombok.Data;

@Data
public class JsonResult<T> {

    private int code;

    private String message;

    private T data;

    public static final <T> JsonResult<T> jsonResult(String message, T t) {
        JsonResult<T> jsonResult = new JsonResult<T>();
        jsonResult.setCode(200);
        jsonResult.setMessage(message);
        jsonResult.setData(t);
        return jsonResult;
    }

}
