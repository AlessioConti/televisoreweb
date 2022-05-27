package it.prova.televisoreweb.service.televisore;

import java.util.List;

import it.prova.televisoreweb.dao.televisore.TelevisoreDAO;
import it.prova.televisoreweb.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDAO;
	
	
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;

	}

	@Override
	public List<Televisore> cercaConMarcaEModello(String marca, String modello) {
		return televisoreDAO.findByMarcaEModello(marca, modello);
	}

	@Override
	public Televisore cercaConId(Long id) throws Exception {
		return televisoreDAO.get(id);
	}

	@Override
	public int inserisci(Televisore input) throws Exception {
		return televisoreDAO.insert(input);
	}

	@Override
	public List<Televisore> listaTuttiTelevisori() throws Exception {
		return televisoreDAO.list();
	}

	@Override
	public int elimina(Televisore input) throws Exception {
		return televisoreDAO.delete(input);
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
		return televisoreDAO.update(input);
	}

}
