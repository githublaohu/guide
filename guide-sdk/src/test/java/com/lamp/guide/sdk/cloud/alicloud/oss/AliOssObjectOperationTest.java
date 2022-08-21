package com.lamp.guide.sdk.cloud.alicloud.oss;

import com.lamp.guide.sdk.api.CloudConfig;
import com.lamp.guide.sdk.api.http.GenericRequest;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectRequest;

public class AliOssObjectOperationTest {
	
	AliOssObjectOperation aliOssObjectOperation;
	
	public void init() {
		
		CloudConfig cloudConfig = new CloudConfig();
		
		cloudConfig.setAccessKeyId("");
		cloudConfig.setSecretAccessKey("");
		cloudConfig.setBucketName("");
		aliOssObjectOperation.initialization(cloudConfig);
	}
	

	public void putObject() {
		PutObjectRequest putObjectRequest = new PutObjectRequest();
		aliOssObjectOperation.putObject(putObjectRequest);
		
		// 查询
		GenericRequest genericRequest = new GenericRequest();
		genericRequest.setKey(putObjectRequest.getKey());
		aliOssObjectOperation.doesObjectExist(genericRequest);
	}

	public void appendObject() {

	}

	public void uploadFile() {

	}

	public void completeMultipartUpload() {

	}
}
