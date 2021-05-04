package Abstract;

import Entities.Player;

public abstract class BaseManager implements CustomerPlayerService  {

	@Override
	public void save(Player player) {

		System.out.println("Saved to db : " + player.getFirstName());
	}
}
