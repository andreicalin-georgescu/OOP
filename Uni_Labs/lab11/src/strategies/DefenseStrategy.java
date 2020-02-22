package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;

import java.util.List;

public class DefenseStrategy implements Strategy {
	private Hero hero;
	//TODO Implement constructor with a Hero as argument
	public DefenseStrategy(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void attack(Monster m) {
	    // TODO implement me
		System.out.println("defense");
		List<Treasure> inventory = hero.getInventory();
		for(Treasure item : inventory) {
			if(item.getDamageType() == hero.getDamageType()) {

				int boostHP = item.getBoostHp();
				boostHP += hero.getBaseHpBoost();
				hero.setHP(hero.getHP() + boostHP);
				m.setHP(m.getHP() - hero.getBaseDamage());
				return;
			}
		}
		int boostHP = hero.getBaseHpBoost();
		hero.setHP(hero.getHP() + boostHP);
		m.setHP(m.getHP() - hero.getBaseDamage());
		return;
	    /*	Attack algorithm
			if hero type weapon found boost HP with treasure.getHpBoost() + hero.getBaseHpBoost()
				else boost HP with getBaseHpBoost()
			Do a basic attack on the monster -> hero.getBaseDamage()
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */
	}

}
