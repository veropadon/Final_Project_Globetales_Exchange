package globetales.exchange.controller.model;

import globetales.exchange.entity.Communication;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class CommunicationData {
	
	 private Long communicationId;
	    private Long senderCommunityID;
	    private Long receiverCommunityID;
	    private String message;

	    public CommunicationData(Communication communication) {
	    	
	    
	        this.communicationId = communication.getCommunicationId();
	        this.senderCommunityID = communication.getSenderCommunityID();
	        this.receiverCommunityID = communication.getReceiverCommunityID();
	        this.message = communication.getMessage();
	    }

}
