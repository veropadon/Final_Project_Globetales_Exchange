package globetales.exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import globetales.exchange.entity.Community;

public interface CommunityDao extends JpaRepository<Community, Long> {

}
