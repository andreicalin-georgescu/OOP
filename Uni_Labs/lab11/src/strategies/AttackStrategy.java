package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;

import java.util.List;

public class AttackStrategy implements Strategy {
	private Hero hero;
	//TODO Implement constructor with a Hero as argument
	public AttackStrategy(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void attack(Monster m) {
	    // TODO implement me

		List<Treasure> inventory = hero.getInventory();
		boolean found = false;
		for(Treasure item : inventory) {
			if(item.getDamageType() == hero.getDamageType()) {
				int damage = hero.getBaseDamage() * 3;
				int monsterHP = m.getHP();
				m.setHP(monsterHP - damage);
				return;
			}
			if(item.getDamageType() == m.getWeakness()) {
				found = true;
			}
		}

		if (!found) {
			int damage = hero.getBaseDamage();
			int monsterHP = m.getHP();
			m.setHP(monsterHP - damage);
		} else {
			int damage = hero.getBaseDamage() * 2;
			int monsterHP = m.getHP();
			m.setHP(monsterHP - damage);
		}



	    /*	Attack algorithm
			if hero type weapon found use it (x3 weapon damage)
				else if counter weapon found use it (x2 weapon damage)
				else basic attack (no bonus)
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */
	}

}
