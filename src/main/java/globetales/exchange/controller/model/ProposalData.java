package globetales.exchange.controller.model;

import globetales.exchange.entity.Community;
import globetales.exchange.entity.Proposal;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
public class ProposalData {
	
	private Long proposalID;
	private String title;
	private String description;
	
     private String status;
		
	private Community sender;
	
	private Community receiver;
	
	 public ProposalData(Proposal proposal) {
	        this.proposalID = proposal.getProposalID();
	        this.title = proposal.getTitle();
	        this.description = proposal.getDescription();
	        this.status = proposal.getStatus();
	        this.sender = proposal.getSender();
	        this.receiver = proposal.getReceiver();
	        // Initialize sender and receiver community details
	    }

	

}
