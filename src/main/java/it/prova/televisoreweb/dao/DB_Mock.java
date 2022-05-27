package it.prova.televisoreweb.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.prova.televisoreweb.model.Televisore;


public class DB_Mock {
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore(1l, "Samsung", "AC11", 1200, 30, "00010001"));
		LISTA_TELEVISORI.add(new Televisore(2l, "Samsung", "AC12", 1200, 40, "00010002"));
		LISTA_TELEVISORI.add(new Televisore(3l, "Samsung", "AC13", 1400, 24, "00010003"));
		LISTA_TELEVISORI.add(new Televisore(4l, "TG", "BH", 890, 23, "00010004"));
		LISTA_TELEVISORI.add(new Televisore(5l, "TG", "BH20", 950, 17, "00010005"));
		LISTA_TELEVISORI.add(new Televisore(6l, "Sony", "002GO", 1050, 39, "00010006"));
		LISTA_TELEVISORI.add(new Televisore(7l, "Sony", "003GO", 1200, 26, "00010007"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId=LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getId)).get().getId();
		return ++resultId;
	}

}
