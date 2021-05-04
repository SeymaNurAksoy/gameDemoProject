package Concreate;

import Abstract.BaseManager;
import Abstract.PlayerManagerCheckService;
import Abstract.PlayerService;
import Abstract.SalesService;
import Entities.Campaign;
import Entities.Player;
import Entities.Sales;

public class PlayerManager extends BaseManager implements PlayerService {

	SalesService salesService;
	PlayerManagerCheckService service;

	public PlayerManager(PlayerManagerCheckService service,SalesService salesService) {
		super();
	    this.service =service;
	    this.salesService = salesService;
	}

	
	@Override 
	public void save(Player player) {
		if(service.checkIfRealPerson(player)) {
			super.save(player);
			System.out.println("Kay�t olundu.");
		}else {
			System.out.println("Ki�i bulunamad� . Kay�t olmad�");
		}
		
	}
	

	@Override
	public void deletePlayer(Player player) {
		System.out.println(player.getFirstName() + " silindi");
		
	}

	@Override
	public void updatePlayer(Player player) {
		System.out.println(player.getFirstName() + " g�ncellendi");
		
	}

	@Override
	public void  discountedPriceSale (Player player, Campaign campaign, Sales[] saless) {
	if(service.checkIfRealPerson(player)) {
		double total =salesService.totalSales(saless) ;
		double price = salesService.applyCampaign(total,campaign) ;
		System.out.println(player.getFirstName() + " "+player.getLastName() +" adl� m��terimiz");
	
		for (Sales sales :saless) {
			System.out.println(sales.getGameName() + "\n" +" Kar��lanmas� gereken sistem �zellikleri " +sales.getDescription() 
			+ "\n �creti :" +sales.getPrice());
		}
		System.out.println(campaign.getCampaignName()+ "  Adl� Kampanya uyguland� " + campaign.getCampaignPrice()+" Tl indirim uyguland� ."
		+ " Yeni �cret : "+price);
	}else {
		System.out.println("Kay�t olunmad��� i�in al��veri� yap�lam�yor..");
	}
		
	}


	@Override
	public void normalPrice(Player player, Sales[] saless) {
		if(service.checkIfRealPerson(player)) {
		double total =salesService.totalSales(saless) ;
		for (Sales sales :saless) {
			System.out.println(sales.getGameName() + "\n" +" Kar��lanmas� gereken sistem �zellikleri " +sales.getDescription() 
			+ "\n �creti :" +sales.getPrice());
		}
		System.out.println("Kampanyas�z �cret : "+total);
	}else {
		System.out.println("Kay�t olunmad��� i�in al��veri� yap�lam�yor..");
	}


	}
}
