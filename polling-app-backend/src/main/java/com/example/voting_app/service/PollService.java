package com.example.voting_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.voting_app.model.Poll;
import com.example.voting_app.repository.PollRepository;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

	public List<Poll> getAllPolls() {
		return pollRepository.findAll();
	}

	public Optional<Poll> getPollById(Long id) {
		return pollRepository.findById(id);
	}
    
    
}
