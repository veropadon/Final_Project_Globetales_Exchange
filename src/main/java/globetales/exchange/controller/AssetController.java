package globetales.exchange.controller;

import java.util.List;





import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import globetales.exchange.entity.Asset;
import globetales.exchange.service.AssetService;



@RestController
@RequestMapping("/assets")


public class AssetController {
	
	private static final Logger log = LoggerFactory.getLogger(AssetController.class);
	
	@Autowired
	private AssetService assetService;
	
	
	
	// Create or Update asset
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Asset saveAsset(@RequestBody Asset asset) {
		log.info("Creating or updating asset{}" , asset);
		return assetService.saveAsset(asset);	
	}
	
	
	
	// Get all assets 
	@GetMapping
	public List <Asset> getAllAssets() {
		log.info("Retrieve all assets called.");
		return assetService.getAllAssets();
		
		
		
	}
	
	// Get asset By Id
	@GetMapping("/{assetId}")
	public Asset getAssetById(@PathVariable Long assetId) {
		log.info("Retrieving asset with ID={}", assetId);
		return assetService.getAssetById(assetId);
		
	}
	
	
	
	// Delete asset By ID 
	
	@DeleteMapping("/{assetId}")
	public Map<String, String > deleteAssetById(@PathVariable Long assetId)  {
		log.info("Deleting asset with ID={}", assetId);
		assetService.deleteAssetById(assetId);
		return Map.of("message", "Deletion of asset with ID=" + assetId + " was successful");
				
		
		
	}
	

	//Update Asset by ID 
	
	@PutMapping("/{assetId}")
	public Asset updateAsset(@PathVariable Long assetId, @RequestBody Asset asset) {
		asset.setAssetID(assetId);
		log.info("Updating asset {} with ID={} " , asset, assetId);
		return assetService.saveAsset(asset);
	}
	
	
	
}

	
	
	


