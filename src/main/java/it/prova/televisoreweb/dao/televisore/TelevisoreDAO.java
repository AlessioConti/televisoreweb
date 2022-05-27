package it.prova.televisoreweb.dao.televisore;

import java.util.List;

import it.prova.televisoreweb.dao.IBaseDAO;
import it.prova.televisoreweb.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	public List<Televisore> findByMarcaEModello(String marca, String modello);
}
