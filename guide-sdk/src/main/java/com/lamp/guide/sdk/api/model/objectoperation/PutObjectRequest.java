package com.lamp.guide.sdk.api.model.objectoperation;

import java.io.File;
import java.io.InputStream;

import com.lamp.guide.sdk.api.event.ProgressListener;

import lombok.Data;

@Data
public class PutObjectRequest {

	private String key;

	private File file;
	
	private InputStream inputStream;

	private ObjectMetadata metadata;
	
	private ProgressListener progressListener;

}
