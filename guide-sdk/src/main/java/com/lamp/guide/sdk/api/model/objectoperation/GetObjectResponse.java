package com.lamp.guide.sdk.api.model.objectoperation;

import java.io.InputStream;


import lombok.Data;

@Data
public class GetObjectResponse {

    // Object key (name)
    private String key;

    // Object's bucket name
    private String bucketName;

    // Object's metadata.
    private ObjectMetadata metadata = new ObjectMetadata();

    // Object's content
    private InputStream objectContent;
}
