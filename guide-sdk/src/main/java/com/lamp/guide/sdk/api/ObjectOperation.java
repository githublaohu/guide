package com.lamp.guide.sdk.api;

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
	
	public boolean doesObjectExist(GenericRequest genericRequest);
	
	/**
	 * 流式下载
	 * 下载到本地文件
	 * 范围下载
	 * 限定条件下载										
	 * @param getObjectRequest
	 * @return
	 */
	public GetObjectResponse getObject(GetObjectRequest getObjectRequest);
	
	/**
	 * 断点续传下载
	 */
	public DownloadFileResponse downloadFile(DownloadFileRequest downloadFileRequest);
	
	
}
