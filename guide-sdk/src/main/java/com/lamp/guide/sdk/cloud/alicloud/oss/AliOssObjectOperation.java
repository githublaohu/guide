package com.lamp.guide.sdk.cloud.alicloud.oss;

import java.util.Objects;

import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.model.PutObjectResult;
import com.lamp.guide.sdk.api.ObjectOperation;
import com.lamp.guide.sdk.api.event.ProgressEvent;
import com.lamp.guide.sdk.api.event.ProgressListener;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectResponse;

/**
 * 文档地址
 * 上传文件 https://help.aliyun.com/document_detail/84781.html
 * 下载文件 https://help.aliyun.com/document_detail/32014.html
 * 查询文件 https://help.aliyun.com/document_detail/84835.html
 * @author laohu
 *
 */
public class AliOssObjectOperation extends AliOssClient implements ObjectOperation{

	@Override
	public PutObjectResponse putObject(PutObjectRequest putObjectRequest) {
		com.aliyun.oss.model.PutObjectRequest aliPutObjectRequest = 
					new com.aliyun.oss.model.PutObjectRequest(this.cloudConfig.getBucketName(),putObjectRequest.getKey(),putObjectRequest.getFile());
		
		if(Objects.nonNull(putObjectRequest.getInputStream())) {
			aliPutObjectRequest.setInputStream(putObjectRequest.getInputStream());
		}
		
		if(Objects.nonNull(putObjectRequest.getProgressListener())) {
			aliPutObjectRequest.withProgressListener(new AliProgressListener(putObjectRequest.getProgressListener()));
		}
		
		if(Objects.nonNull(putObjectRequest.getMetadata())) {
			aliPutObjectRequest.setMetadata(this.crateObjectMetadata(putObjectRequest.getMetadata()));
		}
				
		PutObjectResult putObjectResult = ossClient.putObject(aliPutObjectRequest).
		PutObjectResponse putObjectResponse = new PutObjectResponse();
		
		putObjectResponse.setETag(putObjectResult.getETag());
		
		return putObjectResponse;
	}

	public class AliProgressListener implements com.aliyun.oss.event.ProgressListener{

		private ProgressListener progressListener;
		
		public AliProgressListener(ProgressListener progressListener) {
			this.progressListener = progressListener;
		}
		
		@Override
		public void progressChanged(com.aliyun.oss.event.ProgressEvent progressEvent) {
			ProgressEvent newProgressEvent = new ProgressEvent(ProgressEventType.valueOf(progressEvent.getEventType().name()),progressEvent.getBytes());
			this.progressListener.progressChanged(newProgressEvent);
		}
		
	}
}


