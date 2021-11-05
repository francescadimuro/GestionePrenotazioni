package it.epicode.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table (name = "postazione")
public class Postazione {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String codice;
	private String descrizione;
	private Integer numeroMassimoOccupati;
	@Enumerated (EnumType.STRING)
	private TipoPostazione tipo;
	
	@ManyToOne
	private Edificio edificio;
	
//	@OneToMany (mappedBy = "postazione")
//	private Set<Prenotazione> setPrenotazione = new HashSet<>();
	
	public Postazione(String codice, String descrizione, Integer numeroMassimoOccupati, TipoPostazione tipo,
			Edificio edificio) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.numeroMassimoOccupati = numeroMassimoOccupati;
		this.tipo = tipo;
		this.edificio = edificio;
	}
	
	
}
