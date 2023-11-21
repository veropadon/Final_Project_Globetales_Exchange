package globetales.exchange.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import globetales.exchange.dao.AssetDao;
import globetales.exchange.dao.CommunityAssetDao;
import globetales.exchange.dao.CommunityDao;
import globetales.exchange.entity.Asset;
import globetales.exchange.entity.Community;
import globetales.exchange.entity.CommunityAsset;

import jakarta.transaction.Transactional;

@Service

public class CommunityAssetService {
	
	
	 @Autowired
	 
	    private CommunityAssetDao communityAssetDao;
	 
	 @Autowired
	 private CommunityDao communityDao; 

	 @Autowired
	 private AssetDao assetDao; 
	 
	 
	
	    
	    //Create / add a new association between " Community" and "Asset"
	    
	 @Transactional
	    public CommunityAsset addCommunityAsset(Long communityId, Long assetId) {
	        Community community = communityDao.findById(communityId)
	                .orElseThrow(() -> new NoSuchElementException("Community not found with ID: " + communityId));
	        Asset asset = assetDao.findById(assetId)
	                .orElseThrow(() -> new NoSuchElementException("Asset not found with ID: " + assetId));

	        CommunityAsset communityAsset = new CommunityAsset();
	        communityAsset.setCommunity(community);
	        communityAsset.setAsset(asset);

	        return communityAssetDao.save(communityAsset);
	    }
	 
	 
	  @Transactional
      public boolean existsById(Long id) {
          return communityDao.existsById(id);
      }


	    @Transactional
	    public List<CommunityAsset> getAllCommunityAssets() {
	        return communityAssetDao.findAll();
	    }

 
	    @Transactional
	    public List<Asset> getAssetsByCommunityId(Long communityId) {
	        List<CommunityAsset> communityAssets = communityAssetDao.findByCommunityCommunityID(communityId);
	        return communityAssets.stream().map(CommunityAsset::getAsset).collect(Collectors.toList());
	    }
	    
	    
	    @Transactional

	    public List<Community> getCommunitiesByAssetId(Long assetId) {
	        List<CommunityAsset> communityAssets = communityAssetDao.findByAssetAssetID(assetId);
	        return communityAssets.stream().map(CommunityAsset::getCommunity).collect(Collectors.toList());
	    }

	    @Transactional
	    public void deleteCommunityAsset(Long communityAssetId) {
	        if (!communityAssetDao.existsById(communityAssetId)) {
	            throw new NoSuchElementException("CommunityAsset not found with ID: " + communityAssetId);
	        }
	        communityAssetDao.deleteById(communityAssetId);
	    }

	    @Transactional
	    public CommunityAsset updateCommunityAsset(Long communityAssetId, Long newCommunityId, Long newAssetId) {
	        CommunityAsset communityAsset = communityAssetDao.findById(communityAssetId)
	                .orElseThrow(() -> new NoSuchElementException("CommunityAsset not found with Id:" + communityAssetId));

	        if (newCommunityId != null) {
	            Community newCommunity = communityDao.findById(newCommunityId)
	                    .orElseThrow(() -> new NoSuchElementException("Community not found by Id:" + newCommunityId));
	            communityAsset.setCommunity(newCommunity);
	        }

	        if (newAssetId != null) {
	            Asset newAsset = assetDao.findById(newAssetId)
	                    .orElseThrow(() -> new NoSuchElementException("Asset not found By ID:" + newAssetId));
	            communityAsset.setAsset(newAsset);
	        }

	        return communityAssetDao.save(communityAsset);
	    }

        @Transactional
		public CommunityAsset getCommunityAssetById(Long id) {
			 return communityAssetDao.findById(id)
			            .orElseThrow(() -> new NoSuchElementException("CommunityAsset not found with ID: " + id));
			}
        
        
      
        
        @Transactional

		public CommunityAsset updateCommunityAsset(CommunityAsset communityAsset) {
			if (communityAsset == null || communityAsset.getCommunityAssetID() == null) {
		        throw new IllegalArgumentException("CommunityAsset and its ID must not be null");
		    }
		    if (!communityAssetDao.existsById(communityAsset.getCommunityAssetID())) {
		        throw new NoSuchElementException("CommunityAsset not found with ID: " + communityAsset);
		    }
		    return communityAssetDao.save(communityAsset);
		}


		public CommunityAsset addCommunityAsset(CommunityAsset communityAsset) {
			if (communityAsset.getCommunity() == null || communityAsset.getAsset() == null) {
		        throw new IllegalArgumentException("Community and Asset must not be null");
		    }
		    return communityAssetDao.save(communityAsset);
		}

			
		}


	

  
	

	   
	    	
	    	
			
		




	