package com.lamp.guide.sdk.cloud.alicloud.oss;

import java.util.Objects;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GenericRequest;
import com.lamp.guide.sdk.api.CloudConfig;
import com.lamp.guide.sdk.api.model.objectoperation.ObjectMetadata;

public class AliOssClient {

	protected CloudConfig cloudConfig;

	protected OSS ossClient;

	public void initialization(CloudConfig cloudConfig) {
		ossClient = new OSSClientBuilder().build(cloudConfig.getEndpoint(), cloudConfig.getAccessKeyId(),
				cloudConfig.getSecretAccessKey());
	}
	
	public com.aliyun.oss.model.ObjectMetadata crateObjectMetadata(ObjectMetadata objectMetadata){
		if(Objects.isNull(objectMetadata)) {
			return null;
		}
		com.aliyun.oss.model.ObjectMetadata aliObjectMetadata = new com.aliyun.oss.model.ObjectMetadata();
		
				
		return aliObjectMetadata;
	}
	
	public com.aliyun.oss.model.GenericRequest copyGenericRequest(GenericRequest genericRequest ) {
		com.aliyun.oss.model.GenericRequest newGenericRequest = new com.aliyun.oss.model.GenericRequest();
		this.copyGenericRequest(newGenericRequest, genericRequest);
		return newGenericRequest;
	}
	
	public void  copyGenericRequest(com.aliyun.oss.model.GenericRequest newGenericRequest ,GenericRequest genericRequest ) {
		newGenericRequest.setKey(genericRequest.getKey());
		newGenericRequest.setBucketName(genericRequest.getBucketName());
		newGenericRequest.setVersionId(genericRequest.getVersionId());
		
	}
}
