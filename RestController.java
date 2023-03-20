package it.softwareInside.MagazzinoStore.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.service.ItemService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Autowired
	ItemService itemService;
	
	
	
	@PostMapping("/add")
	public boolean add(@RequestBody Item item) {
		try {
			return itemService.addItem(item);
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("/update") //per modificare inserisco su rested un parametro id e modifico
	public boolean updateItem1(@RequestBody Item item) {
		
		try {
			return itemService.addItem(item);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * per togliere elemento da Rested
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteMap")
	public Item delete(@RequestParam int id) {
		
		return itemService.deleteItem(id);
	}
	
	
	@GetMapping("/add")
	public boolean addItem(@RequestParam("tipo")String tipo, @RequestParam("marca")String marca, 
			               @RequestParam("costo")double costo) {
		
		return itemService.addItem(new Item(tipo, marca, costo));
		
	}
	
	
	@GetMapping("/delete")
	public Item deleteItem(@RequestParam("id") int id) {
		
		return itemService.deleteItem(id);
	}
	
	
	
	@GetMapping("/calcoloAllItem")
	public Double calcoloItem() {
		
		return itemService.calcoloItem();
	}
	
	
	@GetMapping("/allItem")
	public Iterable<Item> allItem() { 
		
		return itemService.allItem();
		
	}
	
	@GetMapping("/testItem")
	public boolean updateItem(Item item) {
		
		return itemService.updateItem(item);
		
	}
	

	
	
	@GetMapping("/cercaId")
	public Item cercaId(@RequestParam("id")int id) {
		
		Item item = itemService.cercaId(id);
		
		return item;
		
	}
	
	
	
	
	
	
}
