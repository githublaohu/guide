package com.lamp.guide.sdk;

import lombok.Data;

@Data
public class CloudConfig {

	private String cloudName;
	
	private String configName;
	
	private String bucketName;
	
	private String endpoint;
	
	private String accessKeyId;
	
	private String secretAccessKey;
	
}
