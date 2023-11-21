package globetales.exchange.controller.model;

import java.util.HashSet;
import java.util.Set;

import globetales.exchange.entity.Community;
import globetales.exchange.entity.Proposal;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class CommunityData {
	
  private Long communityID;
  private String name;
  private String description;
 private String location;
 
 public CommunityData(Community community) {
     this.communityID = community.getCommunityID();
     this.name = community.getName();
     this.description = community.getDescription();
     this.location = community.getLocation();
     
     
 }
 
  
     private Set<Proposal> sentProposals = new HashSet<>();
     
     // Collection of proposals that this community has received
 	
  
     private Set<Proposal> receivedProposals = new HashSet<>();

	
	}

 
	 
 
  


	

   
	


