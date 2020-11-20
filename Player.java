import java.util.Random;

public class Player extends NPC {
    public String rhand;
    public int rHandAtk;
    public double dexAdj;

    public Player() {
        super(50, 0.05, 7, "player", "you");
    }

    public String getRhand() {
        return rhand;
    }

    public void setRhand(String rhand) {
        this.rhand = rhand;
    }

    public int getrHandAtk() {
        return rHandAtk;
    }

    public void setrHandAtk(int rHandAtk) {
        this.rHandAtk = rHandAtk;
    }

    public double getDexAdj(){
        return dexAdj;
    }

    public void setDexAdj(double dexAdj){
        this.dexAdj = dexAdj;
    }


    @Override
    public String toString() {
        return getName() + " has an attack of " + getrHandAtk() + " currently equipped " + rhand + ". Your current hp is " + getHp();
    }

    @Override
    public void attacks(NPC other){
        other.setHp(other.getHp() - getrHandAtk());
    }

    @Override
    public boolean hitChance(NPC other){
        Random diceRoll = new Random();
        double doesHitA = diceRoll.nextDouble() + this.getDexAdj();
        double doesHitB = diceRoll.nextDouble() + other.getDex();

        return doesHitA > doesHitB;
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    /* public static boolean eitherNPCisDead(NPC object, NPC other){
        return !((object.getHp()) <= 0) ^ other.getHp() <= 0;
    }*/
}
