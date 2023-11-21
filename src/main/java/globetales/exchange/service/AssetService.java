package globetales.exchange.service;

import java.util.List;

import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import globetales.exchange.dao.AssetDao;
import globetales.exchange.entity.Asset;
import jakarta.transaction.Transactional;

@Service
public class AssetService {

	@Autowired
	private AssetDao assetDao;
	
	public List<Asset> getAllAssets() {
        return assetDao.findAll();
    }

    public Asset getAssetById(Long assetId) {
        return assetDao.findById(assetId)
                              .orElseThrow(() -> new NoSuchElementException("Asset not found with ID:" + assetId));
    }

 
    public boolean existsById(Long id) {
        return assetDao.existsById(id);
    }
  

    @Transactional
    public void deleteAssetById(Long assetId) {
	      assetDao.deleteById(assetId);
	    }

    
public Asset saveAsset(Asset asset) {
    	
        return assetDao.save(asset);
        		
    }

}
	
   