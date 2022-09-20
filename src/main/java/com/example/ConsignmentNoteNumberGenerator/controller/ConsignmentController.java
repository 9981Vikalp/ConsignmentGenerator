package com.example.ConsignmentNoteNumberGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConsignmentNoteNumberGenerator.pojo.ConsignmentGenerator;
import com.example.ConsignmentNoteNumberGenerator.service.ConsignmentService;

@RestController
@RequestMapping("/controller")
public class ConsignmentController {
	@Autowired
	ConsignmentService consignmentService;

	@PostMapping("/canNoteGenerator")
	public String canNoteGenerator(@RequestBody ConsignmentGenerator consignmentGenerator) {
		return consignmentService.canNotGeneratorService(consignmentGenerator);
	}

}
