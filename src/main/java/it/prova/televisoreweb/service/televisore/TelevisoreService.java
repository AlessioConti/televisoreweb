package it.prova.televisoreweb.service.televisore;

import java.util.List;

import it.prova.televisoreweb.dao.televisore.TelevisoreDAO;
import it.prova.televisoreweb.model.Televisore;

public interface TelevisoreService {
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO);
	
	public List<Televisore> cercaConMarcaEModello(String marca, String modello);
	
	public Televisore cercaConId(Long id) throws Exception;
	
	public int inserisci(Televisore input) throws Exception;
	
	public List<Televisore> listaTuttiTelevisori() throws Exception;
	
	public int elimina(Televisore input) throws Exception;
	
	public int aggiorna(Televisore input) throws Exception;
}