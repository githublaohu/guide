package com.lamp.guide.sdk.api.http;

import lombok.Data;

@Data
public class GenericResponse {

	
    private String requestId;
    
    private Long clientCRC;
    
    private Long serverCRC;
    
    ResponseMessage response;
}
