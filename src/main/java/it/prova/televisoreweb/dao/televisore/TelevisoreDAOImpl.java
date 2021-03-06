package it.prova.televisoreweb.dao.televisore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.televisoreweb.dao.DB_Mock;
import it.prova.televisoreweb.model.Televisore;

public class TelevisoreDAOImpl implements TelevisoreDAO {

	private Connection connection;
	
	public List<Televisore> findByMarcaEModello(String marca, String modello){
		List<Televisore> risultati = new ArrayList<Televisore>();
		
		for(Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if(televisoreItem.getMarca().startsWith(marca) && televisoreItem.getModello().startsWith(modello))
				risultati.add(televisoreItem);
		}
		return risultati;
	}
	public List<Televisore> list() throws Exception {
		return DB_Mock.LISTA_TELEVISORI;
	}

	@Override
	public Televisore get(Long id) throws Exception {
		Televisore temp = new Televisore();
		for(Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if(televisoreItem.getId().equals(id))
				temp = televisoreItem;
		}
		return temp;
	}

	@Override
	public int update(Televisore input) throws Exception {
		for(Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if(televisoreItem.getId() == input.getId()) {
				televisoreItem.setMarca(input.getMarca());
				televisoreItem.setModello(input.getModello());
				televisoreItem.setPrezzo(input.getPrezzo());
				televisoreItem.setNumeroPollici(input.getNumeroPollici());
				televisoreItem.setCodice(input.getCodice());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		input.setId(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_TELEVISORI.add(input)?1:0;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		return DB_Mock.LISTA_TELEVISORI.remove(input)?1:0;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

}
