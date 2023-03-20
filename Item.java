package it.softwareInside.MagazzinoStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Item {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private double costo;
	private String marca, tipologia;
	
	
	
	public Item (String marca, String tipologia, double costo) {
		setMarca(marca);
		setTipologia(tipologia);
		setCosto(costo);
	}
	
}
