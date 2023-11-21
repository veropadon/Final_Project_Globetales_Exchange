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

import globetales.exchange.controller.model.CommunityData;
import globetales.exchange.entity.Community;
import globetales.exchange.service.CommunityService;

@RestController
	@RequestMapping("/communities") 
	public class CommunityController {

	    @Autowired
	    private CommunityService communityService;
	    
	    

	    @PostMapping
	    public ResponseEntity<CommunityData> createCommunity(@RequestBody CommunityData communityData) {
	        Community community = convertToEntity(communityData);
	        Community savedCommunity = communityService.createCommunity(community);
	        CommunityData responseData = convertToDto(savedCommunity);
	        return ResponseEntity.ok(responseData);
	    }

	    @GetMapping
	    public ResponseEntity<List<CommunityData>> getAllCommunities() {
	        List<Community> communities = communityService.getAllCommunities();
	        List<CommunityData> responseData = communities.stream()
	                                                      .map(this::convertToDto)
	                                                      .collect(Collectors.toList());
	        return ResponseEntity.ok(responseData);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CommunityData> getCommunityById(@PathVariable Long id) {
	        Community community = communityService.getCommunityById(id);
	        CommunityData responseData = convertToDto(community);
	        return ResponseEntity.ok(responseData);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CommunityData> updateCommunity(@PathVariable Long id, 
	                                                         @RequestBody CommunityData communityData) {
	        Community community = convertToEntity(communityData);
	        community.setCommunityID(id);
	        Community updatedCommunity = communityService.updateCommunity(community);
	        CommunityData responseData = convertToDto(updatedCommunity);
	        return ResponseEntity.ok(responseData);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {
	        communityService.deleteCommunity(id);
	        return ResponseEntity.ok().build();
	    }

	    // Utility method to convert DTO to Entity
	    private Community convertToEntity(CommunityData communityData) {
	        Community community = new Community();
	        community.setCommunityID(communityData.getCommunityID());
	        community.setName(communityData.getName());
	        community.setDescription(communityData.getDescription());
	        community.setLocation(communityData.getLocation());
	        // Add other fields and necessary logic
	        return community;
	    }

	    // Utility method to convert Entity to DTO
	    private CommunityData convertToDto(Community community) {
	        CommunityData communityData = new CommunityData();
	        communityData.setCommunityID(community.getCommunityID());
	        communityData.setName(community.getName());
	        communityData.setDescription(community.getDescription());
	        communityData.setLocation(community.getLocation());
	        // Add other fields and necessary logic
	        return communityData;
	    }
	}



