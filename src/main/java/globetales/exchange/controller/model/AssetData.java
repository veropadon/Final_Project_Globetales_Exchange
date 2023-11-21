package globetales.exchange.controller.model;

import globetales.exchange.entity.Asset;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AssetData {

	
	private Long assetID;
	private String title;
	private String description;
	private String content;





public AssetData(Asset asset) {
	
	this.assetID= asset.getAssetID();
	this.title= asset.getTitle();
	this.description = asset.getDescription();
	this.content = asset.getContent();
	
	
}

}