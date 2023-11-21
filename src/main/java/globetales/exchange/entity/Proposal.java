package globetales.exchange.entity;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "proposal")
public class Proposal {
	
	
    @Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long proposalID;
	
	
	@Column(nullable = false , length = 300)
	private String title;
	
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	
	@Column(length = 60)
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name = "community_id_sender")
	private Community sender;
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="communityId_receiver")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Community receiver;
	
	
	
	
	
	

}
