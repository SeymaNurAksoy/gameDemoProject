package gameDemoProject;

import Adapter.MerniseServiceAdapter;
import Concreate.CampaignManager;
import Concreate.PlayerManager;

import Concreate.SalesManager;
import Entities.Campaign;
import Entities.Player;
import Entities.Sales;

public class Main {

	public static void main(String[] args) {
	
		Campaign campaign = new Campaign(1,"YEN� �YERLERE �ZEL 5 TL �ND�R�M",5);
		
		Sales sales = new Sales(1,"CSGO","��letim Sistemi: Windows� 7/Vista/XP\r\n"
				+ "��lemci: Intel� Core� 2 Duo E6600 or AMD Phenom� X3 8750 processor or better\r\n"
				+ "Bellek: 2 GB RAM",25);
		
		Sales sales2 = new Sales(1,"PUBG","��letim Sistemi: Windows� 7/Vista/XP\r\n"
				+ "��lemci: Intel� Core� 2 Duo E6600 or AMD Phenom� X3 8750 processor or better\r\n"
				+ "Bellek: 2 GB RAM",25);
		
		Sales[] saless = {sales,sales2};
		
		
		
		CampaignManager campaignManager = new CampaignManager();
		campaignManager.addCampaign(campaign);
		
		Player player = new Player(1,"�eyma Nur ","Aksoy",12752239584l,2000);
		
		Player player2 = new Player(1,"�eyma Nur ","Aksoy",1752239584l,2000);

		PlayerManager playerManager= new PlayerManager(new MerniseServiceAdapter(),new SalesManager());
		//playerManager.save(player);
		playerManager.save(player2);
		System.out.println("Sepet Bilgileri ------------------------");
		
	//	playerManager.discountedPriceSale(player, campaign, saless);
		playerManager.normalPrice(player2, saless);
		
	
		
		
		
		

	}

}
