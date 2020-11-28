import java.util.Random;

public class NPC {
//add melon as an npc

    private int hp;
    private final double dex;
    private String name;
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

    public synchronized void setHp(int hp){
        this.hp = hp;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isDead(){
        return this.hp <= 0;
    }

    public String toString() {
        return ("the " + getName() + " has an attack of " + getAtk() + " and a hp of " + getHp());
    }
    public String curHP(){
        return(" the remaining hp for the " + getName() + " is " + getHp());
    }

    /*public String inCombat (NPC other){
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
        }*/

    public void attacks(NPC other){
        other.setHp(other.getHp() - this.getAtk());
    }


    public boolean hitChance(NPC other){
        Random diceRoll = new Random();
        double doesHitA = diceRoll.nextDouble() + this.getDex();
        double doesHitB = diceRoll.nextDouble() + other.getDex();

        return doesHitA > doesHitB;
    }

    public static boolean eitherNPCisDead(NPC object, NPC other){
        return !((object.getHp()) <= 0) ^ other.getHp() <= 0;
    }

    public void blocks(Player other){
        if(this.getAtk() - other.getrHandBlk() >=  1) {
            other.setHp(other.getHp() - (this.getAtk() - other.getrHandBlk()));
        }else{
            other.setHp(other.getHp());
        }
    }

    public String toDMG(NPC other) {
        return (this.getName() + " hit " + other.getName() + other.curHP());
    }

    public static class Goblin extends NPC {
        public Goblin(){
            super(20, 0.05, 3, "goblin", "a small creature and its green");
        }

    }

    public static class Imp extends NPC {
        public Imp(){
            super(25, 0.07, 6, "imp", "a small creature and its red");
        }

    }

    public static class Melon extends NPC {
        public Melon(){
            super(40, 0.02, 13, "melon", "its a melon the fuck do you want me to put here");
        }
    }
}
