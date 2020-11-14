import java.util.Random;

public class NPC {

    private int hp;
    private final double dex;
    private final String name;
    private final int atk;
    private final String flavorText;

    public NPC(int hp, double dex, int atk, String name, String flavorText){
        this.hp = hp;
        this.dex = dex;
        this. atk = atk;
        this.name = name;
        this.flavorText = flavorText;
    }

    public int getHp() {
        return hp;
    }

    public double getDex() {
        return dex;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public boolean isDead(){
        if (this.getHp() <= 0){
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return ("the " + getName() + " has an attack of " + getAtk() + " and a hp of " + getHp());
    }
    public String curHP(){
        return(" the remaining hp for the " + getName() + " is " + getHp());
    }

    public String inCombat (NPC other){
        Random hitChance = new Random();
        double doesHitA = hitChance.nextDouble() + this.getDex();
        double doesHitB = hitChance.nextDouble() + other.getDex();


            if (doesHitA > doesHitB) {
                other.setHp(other.getHp() - this.getAtk());
                return (this.getName() + " hit " + other.getName()  + other.curHP());

            } else {
                this.setHp(this.getHp() - other.getAtk());
                return (other.getName() + " hit " + this.getName() + this.curHP());
            }
        }



}
