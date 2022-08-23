package com.lamp.guide.sdk.api.http;


import com.lamp.guide.sdk.api.event.ProgressListener;

import lombok.Data;

@Data
public class GenericRequest {
	
    private ProgressListener progressListener;

	private String bucketName;
	private String key;
	private String versionId;
	

}
