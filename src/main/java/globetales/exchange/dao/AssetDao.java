package globetales.exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import globetales.exchange.entity.Asset;

public interface AssetDao extends JpaRepository<Asset, Long> {
	

}
