package com.lamp.guide.sdk.api.http;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseMessage extends HttpMesssage {

    private String uri;
    
    private int statusCode;
}
