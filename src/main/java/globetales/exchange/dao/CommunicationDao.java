package globetales.exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import globetales.exchange.entity.Communication;

public interface CommunicationDao extends JpaRepository<Communication, Long> {

}
