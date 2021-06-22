package vtmc.sandeliosistema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vtmc.sandeliosistema.domain.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
	
	Client findByNameAndSurnameAndDate(String name, String surname, String date);
}
