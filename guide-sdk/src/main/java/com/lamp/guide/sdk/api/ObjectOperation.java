package com.lamp.guide.sdk.api;

import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.CompleteMultipartUploadRequest;
import com.lamp.guide.sdk.api.model.objectoperation.CompleteMultipartUploadResponse;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.UploadFileRequest;
import com.lamp.guide.sdk.api.model.objectoperation.UploadFileResponse;

/**
 * 上传文件
 * 下载文件
 * 查询文件
 * @author laohu
 *
 */
public interface ObjectOperation {

	public PutObjectResponse putObject(PutObjectRequest putObjectRequest);
	
	public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest);
	
	public UploadFileResponse uploadFile(UploadFileRequest uploadFileRequest );
	
	public CompleteMultipartUploadResponse completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest);
}
