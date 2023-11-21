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

import globetales.exchange.controller.model.CommunicationData;
import globetales.exchange.entity.Communication;
import globetales.exchange.service.CommunicationService;

@RestController
@RequestMapping("/communications")
public class CommunicationController {
	
	
	@Autowired
	private CommunicationService communicationService;
	
	
	
	@PostMapping
	public ResponseEntity<CommunicationData> createCommunication(@RequestBody CommunicationData communicationData) {
		Communication communication = convertToEntity(communicationData);
		Communication savedCommunication = communicationService.createCommunication(communication);
		CommunicationData responseData = convertToDto(savedCommunication);
		return ResponseEntity.ok(responseData);
	}
	

	







	@GetMapping
	public ResponseEntity<List<CommunicationData>> getAllCommunications() {
		List<Communication> communications = communicationService.getAllCommunications();
		List<CommunicationData> responseData = communications.stream(). map(this::convertToDto)
				                               .collect(Collectors.toList());
		
		
		return ResponseEntity.ok(responseData);
		
		
		

		
	}
	
	
	@GetMapping("/{id}")
    public ResponseEntity<CommunicationData> getCommunicationById(@PathVariable Long id) {
        Communication communication = communicationService.getCommunicationById(id);
        CommunicationData responseData = convertToDto(communication);
        return ResponseEntity.ok(responseData);
    }



	@PutMapping("/{id}")
    public ResponseEntity<CommunicationData> updateCommunication(@PathVariable Long id, 
                                                                 @RequestBody CommunicationData communicationData) {
        Communication communication = convertToEntity(communicationData);
        communication.setCommunicationId(id); // Ensure correct ID is set
        Communication updatedCommunication = communicationService.updateCommunication(communication);
        CommunicationData responseData = convertToDto(updatedCommunication);
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunication(@PathVariable Long id) {
        communicationService.deleteCommunication(id);
        return ResponseEntity.ok().build();
    }
	
    private Communication convertToEntity(CommunicationData communicationData) {
        Communication communication = new Communication();
        communication.setCommunicationId(communicationData.getCommunicationId());
        communication.setSenderCommunityID(communicationData.getSenderCommunityID());
        communication.setReceiverCommunityID(communicationData.getReceiverCommunityID());
        communication.setMessage(communicationData.getMessage());
      
        return communication;
    }

    
    private CommunicationData convertToDto(Communication communication) {
        CommunicationData communicationData = new CommunicationData();
        communicationData.setCommunicationId(communication.getCommunicationId());
        communicationData.setSenderCommunityID(communication.getSenderCommunityID());
        communicationData.setReceiverCommunityID(communication.getReceiverCommunityID());
        communicationData.setMessage(communication.getMessage());
       
        return communicationData;
    }



}
