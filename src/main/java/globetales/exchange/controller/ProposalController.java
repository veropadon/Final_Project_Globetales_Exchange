package globetales.exchange.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import globetales.exchange.controller.model.ProposalData;
import globetales.exchange.entity.Proposal;
import globetales.exchange.service.ProposalService;

@RestController
@RequestMapping("/proposals")
public class ProposalController {
	
	private ProposalService proposalService;
	
	 @Autowired
	    public ProposalController(ProposalService proposalService) {
	        this.proposalService = proposalService;
	    }


    @PostMapping
    public ResponseEntity<ProposalData> createProposal(@RequestBody ProposalData proposalData) {
        Proposal  proposal = convertToEntity(proposalData);
        Proposal savedProposal = proposalService.createProposal(proposal);
        ProposalData responseData = convertToDto(savedProposal);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<List<ProposalData>> getAllProposals() {
        List<Proposal> proposals = proposalService.getAllProposals();
        List<ProposalData> responseData = proposals.stream()
                                                   .map(this::convertToDto)
                                                   .collect(Collectors.toList());
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalData> getProposalById(@PathVariable Long id) {
        Proposal proposal = proposalService.getProposalById(id);
        ProposalData responseData = convertToDto(proposal);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProposalData> updateProposal(@PathVariable Long id, 
                                                       @RequestBody ProposalData proposalData) {
        Proposal proposal = convertToEntity(proposalData);
        proposal.setProposalID(id);
        Proposal updatedProposal = proposalService.updateProposal(proposal);
        ProposalData responseData = convertToDto(updatedProposal);
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProposal(@PathVariable Long id) {
        proposalService.deleteProposal(id);
        return ResponseEntity.ok().build();
    }
	
	
	
    private Proposal convertToEntity(ProposalData proposalData) {
        Proposal proposal = new Proposal();
        proposal.setProposalID(proposalData.getProposalID());
        proposal.setTitle(proposalData.getTitle());
        proposal.setDescription(proposalData.getDescription());
        proposal.setStatus(proposalData.getStatus()); 

        return proposal;
}
    
    private ProposalData convertToDto(Proposal proposal) {
        ProposalData proposalData = new ProposalData();
        proposalData.setProposalID(proposal.getProposalID());
        proposalData.setTitle(proposal.getTitle());
        proposalData.setDescription(proposal.getDescription());
        proposalData.setStatus(proposal.getStatus());

        // Included details of related entities,
  
        

        return proposalData;
    }

}
