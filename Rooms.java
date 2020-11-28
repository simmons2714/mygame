
import java.util.*;

public class Game {
    // Player testPlayer = new Player();

    public static void main(String[] args) {

        NPC.Goblin testGoblin = new NPC.Goblin();
        NPC.Imp testImp = new NPC.Imp();
        NPC.Melon testMelon = new NPC.Melon();
        Axe testAxe = new Axe();
        Player testPlayer = new Player();
        HealthPotion testPotion = new HealthPotion();


        testPlayer.setrHandAtk(testAxe.getDmg() + testPlayer.getAtk());

        //Map<String, ArrayList<Integer>> rooms = new HashMap<>();

        //currRoom.Look();

        //genRooms();


        Cafe testCafe = new Cafe();
        Library testLibrary = new Library();

        Rooms outside = new Rooms("outside", "grass n junk");

        outside.addAdjRoom(Direction.NORTH, testCafe);
        testCafe.addAdjRoom(Direction.EAST, testLibrary);

        System.out.println(outside.go(Direction.NORTH).Look() + " " + outside.Look());

        Rooms currRoom = outside;

        currRoom.go(Direction.NORTH);
        System.out.println(currRoom.Look());

        testPlayer.setLocation(outside);

        System.out.println(testPlayer.getLocation().Look());
        testPlayer.setLocation(outside.go(Direction.NORTH));
        System.out.println(testPlayer.getLocation().Look());

        testLibrary.setMobInRoom(testMelon);

        testPlayer.setLocation((testPlayer.getLocation()).go(Direction.EAST));
        System.out.println(testPlayer.getLocation().Look());


        if (testLibrary.doesExist(testGoblin)) {
            testPlayer.attacks(testGoblin);
            System.out.println(testGoblin.getHp());
        } else {
            System.out.println(testGoblin.getHp());
            System.out.println("Mob not found");
        }

        if (testLibrary.doesExist(testMelon)) {
            testPlayer.attacks(testMelon);
            System.out.println(testMelon.getHp());
            System.out.println("You atk melon");
        } else {
            System.out.println(testGoblin.getHp());
            System.out.println("Mob not found");
        }

        List<NPC> monsterList = new ArrayList<NPC>();
        monsterList.add(testGoblin);
        monsterList.add(testImp);
        monsterList.add(testMelon);


        HashMap<String, UI> actions = new HashMap<>();
        actions.put("attack", new Attack(testGoblin, testImp, testMelon, testPlayer));
        actions.put("melon", new Melon());
        actions.put("use", new Heal(testPlayer, testPotion));
        actions.put("attack2", new Attack2(testPlayer, monsterList));


        String testAction;
        String verb = " ";
        String noun = " ";
        String verbnoun;


        Scanner input = new Scanner(System.in);
        System.out.println("What do");

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

        while(true){
            if(noun.contains("goblin") || noun.contains("imp") || noun.contains("melon")){
                break;
            }else{
                System.out.println("monster wasn't found");
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
