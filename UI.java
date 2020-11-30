import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface UI {

    void run(Scanner args);
}

/*class Attack implements UI {
    private NPC.Goblin goblin;
    private NPC.Imp imp;
    private NPC.Melon melon;
    private Player player;

    Attack(NPC.Goblin goblin, NPC.Imp imp, NPC.Melon melon, Player player) {
        this.goblin = goblin;
        this.imp = imp;
        this.melon = melon;
        this.player = player;
    }

    @Override
    public void run(Scanner args) {
        if (args.hasNext("goblin")) {
            System.out.println("attacking goblin");
            player.attacks(goblin);
            System.out.println(player.toDMG(goblin));

        } else if (args.hasNext("imp")) {
            System.out.println("attacking imp");
            player.attacks(imp);
            System.out.println(player.toDMG(imp));

        } else if (args.hasNext("melon")) {
            System.out.println("attacking melon");
            player.attacks(melon);
            System.out.println(player.toDMG(melon));

        } else {
            System.out.println("who");

        }

    }


}*/

class Attack2 implements UI {

    private Player player;

    List<NPC> monsterList;


    public Attack2(){
        monsterList = new ArrayList<>();
    }

    public Attack2(Player player, List<NPC> monsterList){
        this.monsterList = monsterList;
        this.player = player;


    }

    public  NPC findMonster(String noun){
        Game.noun = noun;
        for (NPC npc :monsterList) {
            if(npc.getName().equals(noun))
                return npc;
        }
        return null;
    }




    @Override
    public void run(Scanner args) {

        NPC target = findMonster(args.next());
        if(target != null){
            while(NPC.eitherNPCisDead(monsterList.get(Game.i), player)){
                if(player.hitChance(monsterList.get(Game.i))){
                    player.attacks(monsterList.get(Game.i));
                    System.out.println(player.toDMG(monsterList.get(Game.i)));
                }else{
                    monsterList.get(Game.i).attacks(player);
                    System.out.println(monsterList.get(Game.i).toDMG(player));
                }
            }

        }

    }


}

class Equip implements  UI{
    public Player player;
    List<Weapons> weaponsList;

    public Equip(){
        weaponsList = new ArrayList<>();
    }

    public Equip(Player player, List<Weapons> weaponsList){
        this.player = player;
        this.weaponsList = weaponsList;
    }

    @Override
    public void run(Scanner args) {
        if(args.next().equals(weaponsList.get(Game.j).getName()) ){
            player.setDexAdj(weaponsList.get(Game.j).getSizeDexAdj());
            player.setrHandBlk(weaponsList.get(Game.j).getBlock());
            player.setrHandAtk(weaponsList.get(Game.j).getDmg() + player.getAtk());
            player.setRhand(weaponsList.get(Game.j).getName());
            System.out.println(player.toString());

        }else{
            System.out.println("you don't have that weapon");
            System.out.println("ava weapons are " + weaponsList.toString());
        }

    }
}


class Melon implements UI {
    @Override
    public void run(Scanner args) {
        //if (!args.hasNext())
        //  throw new IllegalArgumentException("What?");
        if (args.hasNext("melon"))
            System.out.println("honeydew");
        else
            System.out.println("honeydew");
    }
}

class Heal implements UI {
    private Player player;
    private HealthPotion hpfix;

    Heal(Player player, HealthPotion hpfix) {
        this.player = player;
        this.hpfix = hpfix;
    }

    @Override
    public void run(Scanner args) {
        if (args.hasNext("potion")) {
            hpfix.restoreHP(player);
            System.out.println(player.getHp());
        } else {
            System.out.println("wut2");
        }
    }
}
