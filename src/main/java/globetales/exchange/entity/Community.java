package globetales.exchange.entity;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name ="community")

public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long communityID;
	
	
	@Column(nullable = false, length = 285)
	private String name;
	
	
	
	@Column(length = 750)
	private String description;
	
	
	@Column(length = 35)
	private String location;
	
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private Set<Proposal> sentProposals = new HashSet<>();
    
    // Collection of proposals that this community has received
	
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Set<Proposal> receivedProposals = new HashSet<>();


		
	


	
	
}

	
	

	
	
	


