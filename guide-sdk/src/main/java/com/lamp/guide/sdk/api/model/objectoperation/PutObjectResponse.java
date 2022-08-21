package com.lamp.guide.sdk.api.model.objectoperation;

import java.io.InputStream;

import com.lamp.guide.sdk.api.http.GenericResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PutObjectResponse extends GenericResponse{

    private String eTag;
    
    // Object Version Id
    private String versionId;

    // The callback response body. Caller needs to close it.
    private InputStream callbackResponseBody;
}
