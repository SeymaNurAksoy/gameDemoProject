package Adapter;

import java.rmi.RemoteException;

import Abstract.PlayerManagerCheckService;

import Entities.Player;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MerniseServiceAdapter implements PlayerManagerCheckService {

	@Override
	public boolean checkIfRealPerson(Player player) {
			
			KPSPublicSoap client = new KPSPublicSoapProxy();
			try {
				boolean result = client.TCKimlikNoDogrula(player.getNationalityId(),
						player.getFirstName().toUpperCase(),player.getLastName().toUpperCase(),
						player.getDateOfBirth());
				return result;
			} catch (RemoteException e) {
				
				e.printStackTrace();
			}
			return false;
		}

	}

