package com.lamp.guide.sdk.cloud.alicloud.oss;

import java.util.Objects;

import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.lamp.guide.sdk.api.ObjectOperation;
import com.lamp.guide.sdk.api.event.ProgressEvent;
import com.lamp.guide.sdk.api.event.ProgressListener;
import com.lamp.guide.sdk.api.http.GenericRequest;
import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.CompleteMultipartUploadRequest;
import com.lamp.guide.sdk.api.model.objectoperation.CompleteMultipartUploadResponse;
import com.lamp.guide.sdk.api.model.objectoperation.DownloadFileRequest;
import com.lamp.guide.sdk.api.model.objectoperation.DownloadFileResponse;
import com.lamp.guide.sdk.api.model.objectoperation.GetObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.GetObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.UploadFileRequest;
import com.lamp.guide.sdk.api.model.objectoperation.UploadFileResponse;

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
				
		PutObjectResult putObjectResult = ossClient.putObject(aliPutObjectRequest);
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

	@Override
	public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest) {
		return null;
	}

	@Override
	public UploadFileResponse uploadFile(UploadFileRequest uploadFileRequest) {
		return null;
	}

	@Override
	public CompleteMultipartUploadResponse completeMultipartUpload(
			CompleteMultipartUploadRequest completeMultipartUploadRequest) {
		return null;
	}

	@Override
	public boolean doesObjectExist(GenericRequest genericRequest) {
		return ossClient.doesObjectExist(this.copyGenericRequest(genericRequest));
	}

	@Override
	public GetObjectResponse getObject(GetObjectRequest getObjectRequest) {
		
		com.aliyun.oss.model.GetObjectRequest ossGetObjectRequest = new com.aliyun.oss.model.GetObjectRequest(getObjectRequest.getBucketName(),getObjectRequest.getKey());
		
		if(Objects.nonNull(getObjectRequest.getRange())) {
			ossGetObjectRequest.setRange(getObjectRequest.getRange()[0], getObjectRequest.getRange()[1]);
		}
		if(Objects.nonNull(getObjectRequest.getModifiedSinceConstraint())) {
			ossGetObjectRequest.setModifiedSinceConstraint(getObjectRequest.getModifiedSinceConstraint());
		}
		if(Objects.nonNull(getObjectRequest.getProgressListener())) {
			ossGetObjectRequest.withProgressListener(new AliProgressListener(getObjectRequest.getProgressListener()));
		}
		if(Objects.nonNull(getObjectRequest.getFile())) {
			ObjectMetadata objectMetadata = ossClient.getObject(ossGetObjectRequest, getObjectRequest.getFile()); 
			GetObjectResponse getObjectResponse = new GetObjectResponse();
			getObjectResponse.setBucketName(getObjectRequest.getBucketName());
			getObjectResponse.setKey(getObjectRequest.getKey());
			getObjectResponse.setMetadata(this.crateObjectMetadata(objectMetadata));
			return getObjectResponse;
		}else {
			OSSObject object = ossClient.getObject(ossGetObjectRequest);
			GetObjectResponse getObjectResponse = new GetObjectResponse();
			getObjectResponse.setBucketName(object.getBucketName());
			getObjectResponse.setKey(object.getKey());
			getObjectResponse.setObjectContent(object.getObjectContent());
		}
		return null;
	}

	@Override
	public DownloadFileResponse downloadFile(DownloadFileRequest downloadFileRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}


