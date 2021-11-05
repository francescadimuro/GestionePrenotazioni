package it.epicode.sicurezza;



import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EdificioRequest {

	
	private String nome; 
	private String indirizzo;
	private String nomeCitta;
	@Size(min = 8, max = 8)
	private String codice;
}
