package Concreate;

import Abstract.SalesService;
import Entities.Campaign;

import Entities.Sales;

public class SalesManager implements SalesService {

	@Override
	public double applyCampaign(double total, Campaign campaign) {
	
		double price = total -campaign.getCampaignPrice();
		return price;
	}

	@Override
	public double totalSales(Sales[] saless) {
		double total=0;
		for(Sales sales:saless) {
		 total =total+ sales.getPrice();
		}
		System.out.println("TOPLAM ÜCRET : "+ total);
		return total;
		
		
	}



}
