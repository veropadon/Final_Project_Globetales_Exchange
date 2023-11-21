package globetales.exchange.service;




import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import globetales.exchange.dao.CommunicationDao;
import globetales.exchange.entity.Communication;



@Service
public class CommunicationService {

	 @Autowired
	    private CommunicationDao communicationDao;

	    public Communication createCommunication(Communication communication) {
	        return communicationDao.save(communication);
	    }

	    public List<Communication> getAllCommunications() {
	        return communicationDao.findAll();
	    }

	    public Communication getCommunicationById(Long id) {
	        Optional<Communication> communication = communicationDao.findById(id);
	        if (communication.isPresent()) {
	            return communication.get();
	        } else {
	            throw new NoSuchElementException("Communication not found with ID:" + id); 
	        }
	    }

	    public Communication updateCommunication(Communication communication) {
	        if (communicationDao.existsById(communication.getCommunicationId())) {
	            return communicationDao.save(communication);
	        } else {
	            throw new NoSuchElementException("Communication by ID update not found"+ communication); 
	        }
	    }

	    public void deleteCommunication(Long id) {
	        communicationDao.deleteById(id);
	    }
	}
	
	
	

	
	