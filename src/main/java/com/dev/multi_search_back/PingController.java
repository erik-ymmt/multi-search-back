package com.dev.multi_search_back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
	@CrossOrigin
	@GetMapping("/ping")
	public Ping ping() {
			return new Ping("Pong! Server is running.");
	}
}