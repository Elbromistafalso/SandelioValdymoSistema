package vtmc.sandeliosistema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vtmc.sandeliosistema.domain.Inventory;
	
	@Repository
	public interface InventoryDao extends JpaRepository<Inventory, String> {
		
	}


