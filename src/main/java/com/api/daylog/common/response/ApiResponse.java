package com.api.daylog.common.response;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ApiResponse {

    private final Header header;

    private Object data;

    @Getter @Setter
    static class Header {

        private int code = 200;

        private String message = "SUCCESS";
    }

    private ApiResponse(Header header, Object result) {
        this.header = header;

        if (result == null) {
            this.data = new HashMap<>();
        } else {
            if (result instanceof List) {
                setList((List<Object>)result);
            } else {
                this.data = result;
            }
        }
    }

    public static ApiResponse ok(Object result) {
        return new ApiResponse(new Header(), result);
    }

    private void setList(List<Object> result) {
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", result.size());
        map.put("list", result);
        this.data = map;
    }
}
