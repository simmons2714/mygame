public class Monster {

        private int hp;
        private double dex;
        private String name;
        private int atk;
        private  String flavorText;

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDex(double dex) {
        this.dex = dex;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public double getDex() {
        return dex;
    }

    public int getAtk() {
        return atk;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}
