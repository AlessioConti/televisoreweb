package it.prova.televisoreweb.service;

import it.prova.televisoreweb.dao.MyDaoFactory;
import it.prova.televisoreweb.service.televisore.TelevisoreService;
import it.prova.televisoreweb.service.televisore.TelevisoreServiceImpl;

public class MyServiceFactory {
	private static TelevisoreService TELEVISORE_SERVICE_INSTANCE;
	
	public static TelevisoreService getTelevisoreService() {
		if(TELEVISORE_SERVICE_INSTANCE == null)
			TELEVISORE_SERVICE_INSTANCE = new TelevisoreServiceImpl();
		
		TELEVISORE_SERVICE_INSTANCE.setTelevisoreDAO(MyDaoFactory.getTelevisoreDAOInstance());
		
		return TELEVISORE_SERVICE_INSTANCE;
	}
}
