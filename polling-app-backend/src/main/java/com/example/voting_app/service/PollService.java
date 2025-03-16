package com.example.voting_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.voting_app.model.OptionVote;
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

	public void vote(Long pollId, int optionIndex) {
		// Get Poll from DB
		Poll poll = pollRepository.findById(pollId)
				.orElseThrow(() -> new RuntimeException("Poll not found"));
		
		// Get all options
		List<OptionVote> options = poll.getOptions();
		
		// If index for vote is not valid, throw error
		if (optionIndex < 0 || optionIndex >= options.size()) {
			throw new IllegalArgumentException("Invalid option index");
		}
		
		// Get selected option
		OptionVote selectedOption = options.get(optionIndex);
		
		// Increment vote for selected option
		selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
		
		// Save incremented option into the DB
		pollRepository.save(poll);
	}
    
    
}
