package globetales.exchange.controller.model;



import globetales.exchange.entity.CommunityAsset;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class CommunityAssetData {
	
	private Long communityAssetID;
	 private Long community;
	    private Long asset;

	    public CommunityAssetData(CommunityAsset communityAsset) {
	    	this.communityAssetID = communityAsset.getCommunityAssetID();
	        this.community= communityAsset.getCommunity() != null ? communityAsset.getCommunity().getCommunityID() : null;
	        this.asset = communityAsset.getAsset() != null ? communityAsset.getAsset().getAssetID() : null;
	    }
	}
	
 


