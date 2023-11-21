package globetales.exchange.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import globetales.exchange.dao.ProposalDao;
import globetales.exchange.entity.Proposal;

@Service

public class ProposalService {
	
	 @Autowired
	    private ProposalDao proposalDao;

	    public Proposal createProposal(Proposal proposal) {
	        // Additional logic before saving can be added here
	        return proposalDao.save(proposal);
	    }

	    public List<Proposal> getAllProposals() {
	        return proposalDao.findAll();
	    }

	    public Proposal getProposalById(Long id) {
	        Optional<Proposal> proposal = proposalDao.findById(id);
	        if (proposal.isPresent()) {
	            return proposal.get();
	        } else {
	            throw new NoSuchElementException("Proposal not found with ID:" + id); 
	        }
	    }

	
	  

		public Proposal updateProposal(Proposal proposal) {
		      // Check if the proposal exists before updating
	        if (proposalDao.existsById(proposal.getProposalID())) {
	            return proposalDao.save(proposal);
	        } else {
	            throw new NoSuchElementException("Proposal not found with ID:" + proposal); 
	        }
	    }
		
	


public void deleteProposal(Long id) {
  
    proposalDao.deleteById(id);
}

}
	

