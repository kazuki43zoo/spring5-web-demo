package com.example.spring5webdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaTypeFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadRestController {

	@PostMapping("/upload")
	String upload(MultipartFile file) {
		MediaTypeFactory.getMediaTypes(file.getOriginalFilename()).forEach(System.out::println);
		return file.getOriginalFilename() + " is uploaded !";
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	@ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
	String handleMaxUploadSizeExceededException() {
		return "Upload file size is too large.";
	}
}
