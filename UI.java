import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface UI {

    void run(Scanner args);
}

class Attack implements UI {
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


}

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

    @Override
    public void run(Scanner args) {
        //System.out.println(monsterList.get(0));

        if (args.hasNext("goblin")) {
            System.out.println("attacking goblin");
            player.attacks(monsterList.get(0));
            System.out.println(player.toDMG(monsterList.get(0)));

        } else if (args.hasNext("imp")) {
            System.out.println("attacking imp");
            player.attacks(monsterList.get(1));
            System.out.println(player.toDMG(monsterList.get(1)));

        } else if (args.hasNext("melon")) {
            System.out.println("attacking melon");
            player.attacks(monsterList.get(2));
            System.out.println(player.toDMG(monsterList.get(2)));

        } else {
            System.out.println("who");

        }

    }


}


class Melon implements UI {
    @Override
    public void run(Scanner args) {
        //if (!args.hasNext())
        //  throw new IllegalArgumentException("What?");
        if (args.hasNext("melon"))
            System.out.println("test");
        else
            System.out.println("wut");
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
