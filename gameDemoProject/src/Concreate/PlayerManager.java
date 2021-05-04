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
			System.out.println("Kayýt olundu.");
		}else {
			System.out.println("Kiþi bulunamadý . Kayýt olmadý");
		}
		
	}
	

	@Override
	public void deletePlayer(Player player) {
		System.out.println(player.getFirstName() + " silindi");
		
	}

	@Override
	public void updatePlayer(Player player) {
		System.out.println(player.getFirstName() + " güncellendi");
		
	}

	@Override
	public void  discountedPriceSale (Player player, Campaign campaign, Sales[] saless) {
	if(service.checkIfRealPerson(player)) {
		double total =salesService.totalSales(saless) ;
		double price = salesService.applyCampaign(total,campaign) ;
		System.out.println(player.getFirstName() + " "+player.getLastName() +" adlý müþterimiz");
	
		for (Sales sales :saless) {
			System.out.println(sales.getGameName() + "\n" +" Karþýlanmasý gereken sistem özellikleri " +sales.getDescription() 
			+ "\n ücreti :" +sales.getPrice());
		}
		System.out.println(campaign.getCampaignName()+ "  Adlý Kampanya uygulandý " + campaign.getCampaignPrice()+" Tl indirim uygulandý ."
		+ " Yeni ücret : "+price);
	}else {
		System.out.println("Kayýt olunmadýðý için alýþveriþ yapýlamýyor..");
	}
		
	}


	@Override
	public void normalPrice(Player player, Sales[] saless) {
		if(service.checkIfRealPerson(player)) {
		double total =salesService.totalSales(saless) ;
		for (Sales sales :saless) {
			System.out.println(sales.getGameName() + "\n" +" Karþýlanmasý gereken sistem özellikleri " +sales.getDescription() 
			+ "\n ücreti :" +sales.getPrice());
		}
		System.out.println("Kampanyasýz ücret : "+total);
	}else {
		System.out.println("Kayýt olunmadýðý için alýþveriþ yapýlamýyor..");
	}


	}
}
