package Abstract;

import Entities.Campaign;
import Entities.Sales;


public interface SalesService  {
	
	double applyCampaign(double total,Campaign campaign);
	
	double totalSales(Sales[] sales);
	
	


}
