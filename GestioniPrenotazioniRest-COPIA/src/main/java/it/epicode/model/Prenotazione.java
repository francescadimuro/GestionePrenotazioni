package it.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name ="prenotazione")
public class Prenotazione {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@NotNull
	private User user;
	@ManyToOne
	@NotNull
	private Postazione postazione;
	@NotNull
	private LocalDate dataPrenotata;
	private LocalDate dataPrenotazione;
	
	public Prenotazione(User user, Postazione postazione, LocalDate dataPrenotata, LocalDate dataPrenotazione) {
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotata = dataPrenotata;
		this.dataPrenotazione = dataPrenotazione;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", user=" + user.getUsername() + ", postazione=" + postazione.getCodice() + postazione.getDescrizione() + ", dataPrenotata="
				+ dataPrenotata + ", dataPrenotazione=" + dataPrenotazione + "]";
	}
	
	
}
