package Abstract;

import Entities.Campaign;
import Entities.Player;
import Entities.Sales;

public interface PlayerService {
	
	void deletePlayer(Player player);
	
	void updatePlayer(Player player);
	
	void  discountedPriceSale (Player player,Campaign campaign,Sales[] saless) ;
	
	void normalPrice(Player player,Sales[] saless);

}
