package globetales.exchange.entity;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "asset")
public class Asset {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetID;
	
	@Column(nullable = false , length = 265)
	private String title;
	
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "community_asset",
	joinColumns = @JoinColumn(name = "asset_id"),
	inverseJoinColumns = @JoinColumn(name = "community_id"))
	private Set<Community> communities = new HashSet<>();
	
	
}
