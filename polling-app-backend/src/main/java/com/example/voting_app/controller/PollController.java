package com.example.voting_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.voting_app.model.Poll;
import com.example.voting_app.service.PollService;

@RestController
@RequestMapping("/api/polls")
public class PollController {
	
	@Autowired
	PollService pollService;
	
	@PostMapping
	public Poll createPoll(@RequestBody Poll poll) {
		return pollService.createPoll(poll);
	}
	
	@GetMapping
	public List<Poll> getAllPolls() {
		return pollService.getAllPolls();
	}
}
