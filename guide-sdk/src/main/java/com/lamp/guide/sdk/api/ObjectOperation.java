package com.lamp.guide.sdk.api;

import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectResponse;

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
	
	public void uploadFile();
	
	public void completeMultipartUpload();
}
