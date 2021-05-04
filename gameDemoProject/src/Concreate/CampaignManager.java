package Concreate;

import Abstract.CampaignService;
import Entities.Campaign;

public class CampaignManager implements CampaignService {

	@Override
	public void addCampaign(Campaign campaign) {
		
		System.out.println(campaign.getCampaignName() +" kampanyas� sistemimize eklendi");
		
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignName() +" kampanyas� sistemimizden silindi");
		
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignName() +" kampanyas� g�ncellendi");
		
	}

	

	

}
