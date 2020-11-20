public class Items {
    private String name;
    private String flavorText;




    public Items(String name, String flavorText){
        this.name = name;
        this.flavorText = flavorText;
    }

    public String getName() {
        return name;
    }

    public String getFlavorText() {
        return flavorText;
    }
}

class HealthPotion extends Items{
    int restore = 20;
    int amount = 1;
    public HealthPotion(){
        super("hp potion", "it restores your hp by 20");
    }

    public int getRestore() {
        return restore;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
    
    public void restoreHP(NPC beta){
        beta.setHp(beta.getHp() + restore);
    }
}

