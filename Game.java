import java.util.*;

public class Game{
    public  NPC.Goblin goblin;
    public  Player player;
    public   NPC.Imp imp;
    public  NPC.Melon  mel;


    public  Axe axe = new Axe();
    public  Bow bow = new Bow();
    public  Gun gun = new Gun();
    public   Sword sword = new Sword();

    public   HealthPotion potion;
    
    public  Rooms library = new Library();
    public  Rooms cafe = new Cafe();

    Scanner input = new Scanner(System.in);
    static String testAction;
    static String verb;
    static String noun;
    public static String verbnoun;

    public static HashMap<String, UI> actions = new HashMap<>();
    public static ArrayList<NPC> monsterList = new ArrayList<NPC>();
    public static ArrayList<Weapons> weaponsList =  new ArrayList<Weapons>();

    public Game(){

        player =  new Player();
        player.setrHandAtk(axe.getDmg() + player.getAtk());
        genCMDList();
        genRooms();

        runActions(input);


    }

    public static void main(String[] args) {
        Game game = new Game();

    }

    public  void genCMDList(){
        goblin = new NPC.Goblin();
        imp = new NPC.Imp();
        mel = new NPC.Melon();

        monsterList.add(goblin);
        monsterList.add(imp);
        monsterList.add(mel);


        weaponsList.add(axe);
        weaponsList.add(bow);
        weaponsList.add(gun);
        weaponsList.add(sword);


        actions.put("melon", new Melon());
        actions.put("use", new Heal(player, potion));
        actions.put("attack", new Attack2(player, monsterList));
        actions.put("equip", new Equip(player, weaponsList));

    }

    public  void genRooms(){
       Rooms outside =  new Rooms("outside ", "grass n junk");

       cafe =  new Cafe();
       library = new Library();

       outside.addAdjRoom(Direction.NORTH, cafe);
       cafe.addAdjRoom(Direction.EAST, library);

       library.setMobInRoom(goblin);
       cafe.setMobInRoom(mel);

       player.setLocation(outside);

    }

    static int i = 0;
    static int j = 0;
    public  NPC findMonster(String noun){
        Game.noun = noun;
        for (i = 0; i<monsterList.size(); i++) {
            if(monsterList.get(i).getName().equals(noun))
                return monsterList.get(i);
        }
        return null;
    }

    public  Weapons findWeapons(String noun){
        Game.noun = noun;
        for (j= 0; j<weaponsList.size(); j++) {
            if(weaponsList.get(j).getName().equals(noun))
                return weaponsList.get(j);
        }
        return null;
    }
    public void runActions(Scanner input){


        System.out.print("> ");
        verbnoun = input.nextLine();
        Scanner tokenizer = new Scanner(verbnoun);
        if (tokenizer.hasNext()) {
            verb = tokenizer.next();
            if (tokenizer.hasNext()) {
                noun = tokenizer.next();
            } else {
                noun = verb;
            }
        }
        testAction = verb + " " + noun;
        Scanner testScan = new Scanner(testAction);
        actions.get(testScan.next()).run(testScan);




        NPC target = findMonster(noun);
        Weapons target2 = findWeapons(noun);

        while(true){
            if(target != null ){
                break;
            }else{
                System.out.print("monster wasn't found \n>");
                Scanner inputFix =  new Scanner(System.in);
                verbnoun = inputFix.nextLine();
                Scanner tokenizerFix = new Scanner(verbnoun);
                if (tokenizerFix.hasNext()) {
                    verb = tokenizerFix.next();
                    if (tokenizerFix.hasNext()) {
                        noun = tokenizerFix.next();
                    } else {
                        noun = verb;
                    }
                }
                testAction = verb + " " + noun;
                Scanner testScanFix = new Scanner(testAction);
                actions.get(testScanFix.next()).run(testScanFix);
            }
        }

    }



}
