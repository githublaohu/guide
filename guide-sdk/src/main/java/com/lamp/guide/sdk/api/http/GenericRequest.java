package com.lamp.guide.sdk.api.http;

import lombok.Data;

@Data
public class GenericRequest {

	private String bucketName;
	private String key;
	private String versionId;
}
