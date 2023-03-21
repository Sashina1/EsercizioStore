package it.softwareInside.MagazzinoStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.repository.ItemRepository;



@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	
	
	
	
	public Item cercaId(int id) {
		
		try {
			return itemRepository.findById(id).get();
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
	/**
	 * METODO CHE PRENDE IN INGRESSO 
	 * UN OGGETTO DI TIPO ITEM DIVERSO DA NULL
	 * RITORNA TRUE SE L 'ITEM è STATO AGGIUNTO 
	 * ALTRIMENTI FALSE
	 * @param item
	 * @return
	 */
	public boolean addItem(Item item) {
		
		if(item == null)
			return false;
		
		try {
			itemRepository.save(item);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	/**
	 * cancella un oggetto di tipo item
	 * tramite la posizione
	 * @param id
	 * @return
	 */
	public Item deleteItem(int id) {
		
		try {
			
			Item item = itemRepository.findById(id).get();
			itemRepository.deleteById(id);
			return item;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
	/**
	 * lista degli oggetti item 
	 * nel database
	 * @return
	 */
	public Iterable<Item> allItem() {
		
		
		 return itemRepository.findAll(); 
		
	}
	
	
	
	/**
	 * calcolo dei prezzi degli oggetti 
	 * nel database
	 * @return
	 */
	public double calcoloItem() {
		 double somma = 0;
		 for (Item item : itemRepository.findAll()) {
			somma += item.getCosto();
			
		}
		return somma;
	}
	
	
	
	
	
	public boolean updateItem(Item item) {
		
		return addItem(item);
		
		
	}
	
	
	
	
}
