public abstract class VideoGame {

    public interface Damageable {
        void takeDamage(int amount);
        boolean isDestroyed();
    }

    public interface Repairable {
        void repair(int amount);
    }

    public interface Upgradable {
        void upgrade();
    }
   
    class GameCharacter implements Damageable, Repairable, Upgradable {
        protected int health;
        protected String name;
        protected int level;
       
        public GameCharacter(int health, String name, int level) {
            this.health = health;
            this.name = name;
            this.level = level;
        }

        @Override
        public void takeDamage(int amount) {
            health -= amount;
            System.out.println("Character " + name + " took " + amount + " damage. Remaining health: " + health);
        }

        @Override
        public boolean isDestroyed() {
            return health <= 0;
        }

        @Override
        public void repair(int amount) {        
            health += amount;
        }

        @Override
        public void upgrade() {
            level += 1;
            health += 20;
            System.out.println("Character " + name + " leveled up to " + level + ". Health: " + health + ".");
        }
    }

    class Weapon implements Damageable, Repairable, Upgradable {
        protected int durability;
        protected String name;
    
        public Weapon(int durability, String name) {
            this.durability = durability;
            this.name = name;
        }

        @Override
        public void takeDamage(int amount) {
            durability -= amount;
            System.out.println("Weapon " + name + " durability reduced to " + durability);
        }

        @Override
        public boolean isDestroyed() {
            return durability <= 0;
        }

        @Override
        public void repair(int amount) {
            durability += amount;
            System.out.println("Weapon " + name + " repaired. Durability: " + durability);
        }

        @Override
        public void upgrade() {
            durability += 100;
        }
    }

    class Building implements Damageable, Repairable, Upgradable {
        protected int health;
        protected String name;
        protected int level;

        public Building(int level, String name, int health) {
            this.level = level;  
            this.name = name;
            this.health = health;
        }

        @Override
        public void takeDamage(int amount) {
            health -= amount;
            System.out.println(name + " building took " + amount + " damage. Remaining health: " + health);
        }

        @Override
        public boolean isDestroyed() {
            return health <= 0;
        }

        @Override
        public void repair(int amount) {
            health += amount;
            System.out.println(name + " building repaired. Health: " + health);
        }

        @Override
        public void upgrade() {
            level += 1;
            System.out.println(name + " building upgraded to level " + level);
        }
    }

    public class GameManager {
        public void applyDamage(Damageable d, int amount) {
            d.takeDamage(amount);
        }

        public void repairObject(Repairable r, int amount) {
            r.repair(amount);
        }

        public void upgradeObject(Upgradable u) {
            u.upgrade();
        }
    }
}

    class GameDemo {
    public static void main(String[] args) {
        VideoGame game = new VideoGame() {};
        VideoGame.GameManager gm = game.new GameManager();
        
        VideoGame.Damageable character = game.new GameCharacter(100, "Alex", 1);
        VideoGame.Damageable weapon = game.new Weapon(50, "Sword");
        VideoGame.Damageable building = game.new Building(1, "Tower", 200);
        
        gm.applyDamage(character, 30);
        gm.applyDamage(weapon, 20);
        gm.applyDamage(building, 90);
        
        ((VideoGame.Upgradable) character).upgrade();
        ((VideoGame.Upgradable) building).upgrade();
        ((VideoGame.Repairable) weapon).repair(15);
        ((VideoGame.Repairable) building).repair(50);
        
        System.out.println("Character destroyed? " + character.isDestroyed());
        System.out.println("Weapon destroyed? " + weapon.isDestroyed());
        System.out.println("Building destroyed? " + building.isDestroyed());
    }
}
