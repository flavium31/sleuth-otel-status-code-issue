package com.example.sleuthotelstatuscodeissue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping(path = "/test")
	ResponseEntity<Void> test() {
		throw new RuntimeException();
		//return ResponseEntity.ok().build();
	}

}
