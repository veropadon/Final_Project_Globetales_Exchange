package globetales.exchange.controller;

import java.util.List;


import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import globetales.exchange.controller.model.CommunityAssetData;
import globetales.exchange.entity.Asset;
import globetales.exchange.entity.Community;
import globetales.exchange.entity.CommunityAsset;
import globetales.exchange.service.AssetService;
import globetales.exchange.service.CommunityAssetService;
import globetales.exchange.service.CommunityService;



@RestController
@RequestMapping("/communityAssets")

public class CommunityAssetController {
	
	

	@Autowired
	private CommunityService  communityService;
	
	@Autowired
	private AssetService assetService;
	
    @Autowired
    private CommunityAssetService communityAssetService;
    

  
   
  
    @PostMapping("/communityAsset") 
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommunityAssetData> addCommunityAsset(  @RequestBody CommunityAssetData communityAssetData) {
    CommunityAsset communityAsset = convertToEntity(communityAssetData);
    CommunityAsset savedCommunityAsset = communityAssetService.addCommunityAsset(communityAsset);
    CommunityAssetData responseData = convertToDto(savedCommunityAsset);
    return ResponseEntity.ok(responseData);
    
    }




  
 
       @GetMapping
   
    public ResponseEntity<List<CommunityAssetData>> getAllCommunityAssets()  {
        List<CommunityAsset> communityAssets = communityAssetService.getAllCommunityAssets();
        List<CommunityAssetData> responseData = communityAssets.stream()
                                                              .map(this::convertToDto)
                                                              .collect(Collectors.toList());
        return ResponseEntity.ok(responseData);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CommunityAssetData> getCommunityAssetById(@PathVariable Long id) {
        CommunityAsset communityAsset = communityAssetService.getCommunityAssetById(id);
        CommunityAssetData responseData = convertToDto(communityAsset);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommunityAssetData> updateCommunityAsset(@PathVariable Long id, 
                                                                  @RequestBody CommunityAssetData communityAssetData) {
        CommunityAsset communityAsset = convertToEntity(communityAssetData);
        communityAsset.setCommunityAssetID(id);
        CommunityAsset updatedCommunityAsset = communityAssetService.updateCommunityAsset(communityAsset);
        CommunityAssetData responseData = convertToDto(updatedCommunityAsset);
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunityAsset(@PathVariable Long id) {
        communityAssetService.deleteCommunityAsset(id);
        return ResponseEntity.ok().build();
        
        
  
    }
    

    
    
    
    //Method to convert to Entity 
   
    private CommunityAsset convertToEntity(CommunityAssetData communityAssetData) {
        CommunityAsset communityAsset = new CommunityAsset();

        //  IDs are validated and not null 
        Community community = communityService.getCommunityById(communityAssetData.getCommunity());
        Asset asset = assetService.getAssetById(communityAssetData.getAsset());

        communityAsset.setCommunity(community);
        communityAsset.setAsset(asset);

        return communityAsset;
    }


    
    
    // Method to convert Entity to DTO
    
    private CommunityAssetData convertToDto(CommunityAsset communityAsset) {
        CommunityAssetData communityAssetData = new CommunityAssetData();
        communityAssetData.setCommunityAssetID(communityAsset.getCommunityAssetID());
        
        if (communityAsset.getCommunity() != null) {
            communityAssetData.setCommunity(communityAsset.getCommunity().getCommunityID());
        }
        if (communityAsset.getAsset() != null) {
            communityAssetData.setAsset(communityAsset.getAsset().getAssetID());
        }

        return communityAssetData;
    }

    }



	
	


