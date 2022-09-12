package com.spring.boot.file.operations.model;

import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Photo {

	private String id;

	@NotEmpty
	private String fileName;

	@JsonIgnore
	private byte[] data;

	private String contentType;

	public Photo() {
	}

	public Photo(String id, String fileName) {
		this.id = id;
		this.fileName = fileName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", fileName=" + fileName + ", data=" + Arrays.toString(data) + ", contentType="
				+ contentType + "]";
	}

}
