package commands;

import entities.Hero;

public class MoveCommand implements Command {
    private Hero hero;
    private Hero.Direction direction;
    private CommandManager manager;

    public MoveCommand(Hero hero, Hero.Direction direction) {
        this.hero = hero;
        this.direction = direction;
        manager = new CommandManager();
    }

	@Override
	public void undo() {
        Hero.Direction revDirection = getReversedDirection();



        MoveCommand aux = new MoveCommand(hero, revDirection);
        aux.execute();
		
	}

	@Override
	public void execute() {
		hero.move(direction);
	}


    public Hero.Direction getReversedDirection() {
        if(direction.equals(Hero.Direction.E)) {
            return Hero.Direction.W;
        } else if (direction.equals(Hero.Direction.W)) {
            return Hero.Direction.E;
        } else if (direction.equals(Hero.Direction.N)) {
            return Hero.Direction.S;
        } else if (direction.equals(Hero.Direction.S)) {
            return Hero.Direction.N;
        }
        return null;
    }
}
