package globetales.exchange.entity;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "community_asset")
public class CommunityAsset {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long communityAssetID;
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "community_id")
	private Community community;
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name  = "asset_id")
	private Asset asset;





	
	
	

}

