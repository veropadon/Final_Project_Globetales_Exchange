package globetales.exchange.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import globetales.exchange.dao.CommunityDao;
import globetales.exchange.entity.Community;

@Service
public class CommunityService {
	
@Autowired
	private CommunityDao communityDao;
	
	 public Community createCommunity(Community community) {
	       
	        return communityDao.save(community);
	    }
	 

	    public List<Community> getAllCommunities() {
	        return communityDao.findAll();
	    }

	    public Community getCommunityById(Long id) {
	        Optional<Community> community = communityDao.findById(id);
	        if (community.isPresent()) {
	            return community.get();
	        } else {
	            throw new NoSuchElementException("Community not foundById:" + id); 
	        }
	        
	    }
	        
	        public boolean existsById(Long id) {
	            return communityDao.existsById(id);
	        }
	    
	        
	        
	    public Community updateCommunity(Community community) {
	        // Check if the community exists before updating
	        if (communityDao.existsById(community.getCommunityID())) {
	            return communityDao.save(community);
	        } else {
	            throw new NoSuchElementException("Community not found with ID:" + community); 
	        }
	    }

	    public void deleteCommunity(Long id) {
	       
	        communityDao.deleteById(id);
	    }

		
	
	
}


