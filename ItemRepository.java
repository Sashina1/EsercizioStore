package it.softwareInside.MagazzinoStore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.softwareInside.MagazzinoStore.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

	
	
	
}
