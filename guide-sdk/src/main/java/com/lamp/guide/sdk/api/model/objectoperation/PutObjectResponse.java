package com.lamp.guide.sdk.api.model.objectoperation;

import java.io.InputStream;

import com.lamp.guide.sdk.api.http.GenericResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PutObjectResponse extends GenericResponse{

    private String eTag;
    
    // Object Version Id
    private String versionId;

    // The callback response body. Caller needs to close it.
    private InputStream callbackResponseBody;
}
