package com.spring.boot.file.operations.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.spring.boot.file.operations.model.Photo;

@Service
public class PhotoSertvice {

	public Map<String, Photo> db = new HashMap<String, Photo>(){{
		put("1", new Photo("1", "file.jpg"));
		put("2", new Photo("2", "file2.jpg"));
		put("3", new Photo("3", "file3.jpg"));
	}};

	public void dbConfig() {
		System.out.println("Database initilized..!!");
		db.put("1", new Photo("1", "file.jpg"));
		db.put("2", new Photo("2", "file2.jpg"));
		db.put("3", new Photo("3", "file3.jpg"));
	}

	public Collection<Photo> getAllPhotos() {
		return db.values();
	}

	public Photo getPhoto(String id) {
		Photo photo = db.get(id);
		if (photo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return photo;
	}

	public Photo updatePhoto(Photo ph) {
//		String id = ph.getId();
//		Photo photo = db.get(id);
		if (db.get(ph.getId()) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return db.put(ph.getId(), ph);
	}

	public void deletePhoto(String id) {
		if (db.get(id) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 db.remove(id);
	}

	@SuppressWarnings("static-access")
	public Photo savePhoto(Photo photo) {
		photo.setId(UUID.randomUUID().randomUUID().toString());
		db.put(photo.getId(), photo);
		return photo;
	}

}
