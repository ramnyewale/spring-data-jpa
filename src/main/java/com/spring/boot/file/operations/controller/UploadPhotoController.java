package com.spring.boot.file.operations.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.file.operations.model.Photo;
import com.spring.boot.file.operations.service.PhotoSertvice;

@RestController
@RequestMapping("/api")
public class UploadPhotoController {

	@Autowired
	private PhotoSertvice photoService;

	@GetMapping("/")
	public String landingPage() {
		return "<html>\r\n" + "	<head>\r\n" + "		<title><h2>Landing Page</h2></title>\r\n" + "	</head>\r\n"
				+ "	<body style=\"background-color: linen;\">\r\n"
				+ "		<h2>Welcome to File upload/download portal</h2>\r\n"
				+ "	</body style=\"background-color: skyblue;\">\r\n" + "</html>";
	}

	@GetMapping("/photos")
	public Collection<Photo> getAllPhotos() {
		return photoService.getAllPhotos();
	}

	@GetMapping("/photos/{id}")
	public Photo getPhoto(@PathVariable String id) {
		return photoService.getPhoto(id);
	}

	@PutMapping("/update-photo/{id}")
	public Photo updatePhoto(@RequestBody Photo photo) {
		return photoService.updatePhoto(photo);
	}

	@DeleteMapping("/delete-photo/{id}")
	public void deletePhoto(@PathVariable String id) {
		photoService.deletePhoto(id);
	}

	@PostMapping("/save-photo")
	public Photo savePhoto(@RequestBody Photo photo) {
		return photoService.savePhoto(photo);
	}
}
