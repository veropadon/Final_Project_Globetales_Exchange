package globetales.exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import globetales.exchange.entity.Proposal;

public interface ProposalDao extends JpaRepository<Proposal, Long> {

}
