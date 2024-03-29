package com.lamp.guide.sdk.cloud.alicloud.oss;

import java.util.Objects;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.lamp.guide.sdk.CloudConfig;
import com.lamp.guide.sdk.Initialization;
import com.lamp.guide.sdk.api.http.GenericRequest;
import com.lamp.guide.sdk.api.model.objectoperation.ObjectMetadata;

public class AliOssClient implements Initialization{

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
	
	public ObjectMetadata crateObjectMetadata(com.aliyun.oss.model.ObjectMetadata objectMetadata){
		if(Objects.isNull(objectMetadata)) {
			return null;
		}
		ObjectMetadata aliObjectMetadata = new ObjectMetadata();
		
				
		return aliObjectMetadata;
	}
	
	public com.aliyun.oss.model.GenericRequest copyGenericRequest(GenericRequest genericRequest ) {
		com.aliyun.oss.model.GenericRequest newGenericRequest = new com.aliyun.oss.model.GenericRequest();
		this.copyGenericRequest(newGenericRequest, genericRequest);
		return newGenericRequest;
	}
	
	public void  copyGenericRequest(com.aliyun.oss.model.GenericRequest newGenericRequest ,GenericRequest genericRequest ) {
		newGenericRequest.setKey(genericRequest.getKey());
		if(Objects.isNull(genericRequest.getBucketName())) {
			newGenericRequest.setBucketName(cloudConfig.getBucketName());
		}else {
			newGenericRequest.setBucketName(genericRequest.getBucketName());
		}
		newGenericRequest.setVersionId(genericRequest.getVersionId());
		
	}
}
