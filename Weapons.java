public class Weapons {
    private int dmg;
    private double sizeDexAdj;
    private String name;
    private int block;
    private String flavorText;

    public Weapons(int dmg, double sizeDexAdj, String name, int block, String flavorText){
        this.dmg = dmg;
        this.sizeDexAdj = sizeDexAdj;
        this.name = name;
        this.block = block;
        this.flavorText = flavorText;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public double getSizeDexAdj() {
        return sizeDexAdj;
    }

    public void setSizeDexAdj(double sizeDexAdj) {
        this.sizeDexAdj = sizeDexAdj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }
}

class Axe extends Weapons{
    public Axe(){
        super(15, (-0.02), "axe", 5, "an axe");
    }
}

class Sword extends Weapons{
    public Sword(){
        super(12, 0.00, "sword", 7, "a sword");
    }
}

class Gun extends Weapons{
    public Gun(){
        super(30, (-0.04), "gun", 1, "a gun" );
    }
}

class MelonSword extends Weapons{
    public MelonSword(){
        super(10, 0.03, "melon", 6, "a melon in the shape of a sword");
    }
}

class Bow extends Weapons{
    public Bow(){
        super(14, (-0.01), "bow", 4, "a bow ");
    }
}
