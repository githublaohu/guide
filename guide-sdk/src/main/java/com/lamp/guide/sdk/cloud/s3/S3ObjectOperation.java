package com.lamp.guide.sdk.cloud.s3;

import com.lamp.guide.sdk.api.ObjectOperation;
import com.lamp.guide.sdk.api.http.GenericRequest;
import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.AppendObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.CompleteMultipartUploadRequest;
import com.lamp.guide.sdk.api.model.objectoperation.CompleteMultipartUploadResponse;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectRequest;
import com.lamp.guide.sdk.api.model.objectoperation.PutObjectResponse;
import com.lamp.guide.sdk.api.model.objectoperation.UploadFileRequest;
import com.lamp.guide.sdk.api.model.objectoperation.UploadFileResponse;

public class S3ObjectOperation extends S3Client implements ObjectOperation {

	@Override
	public PutObjectResponse putObject(PutObjectRequest putObjectRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadFileResponse uploadFile(UploadFileRequest uploadFileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompleteMultipartUploadResponse completeMultipartUpload(
			CompleteMultipartUploadRequest completeMultipartUploadRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doesObjectExist(GenericRequest genericRequest) {
		return false;
	}

}
