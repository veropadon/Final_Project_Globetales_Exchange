package globetales.exchange.dao;






import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import globetales.exchange.entity.CommunityAsset;

public interface CommunityAssetDao extends JpaRepository<CommunityAsset, Long> {

	List<CommunityAsset> findByAssetAssetID(Long assetId);

	List<CommunityAsset> findByCommunityCommunityID(Long communityId);

	




	
	
	   
 
}
