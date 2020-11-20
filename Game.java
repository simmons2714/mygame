public class Game{

    Goblin testGoblin = new Goblin();
    Imp testImp = new Imp();
    Melon testMelon = new Melon();
    Axe testAxe = new Axe();
    Player testPlayer = new Player();
    HealthPotion testPotion = new HealthPotion();
    public static void main(String[] args) {

        Goblin testGoblin = new Goblin();
        Imp testImp = new Imp();
        Melon testMelon = new Melon();
        Axe testAxe = new Axe();
        Player testPlayer = new Player();
        HealthPotion testPotion = new HealthPotion();


        System.out.println("The " + testImp.getName() + " has an attack of " + testImp.getAtk() + ". The imp HP is " + testImp.getHp());
        System.out.println("The " + testGoblin.getName() + " has an attack of " + testGoblin.getAtk() + ". The goblin HP is " + testGoblin.getHp());

        /*//do{
            System.out.println(testGoblin.inCombat(testImp));

       // }while((testGoblin.isDead() && !testImp.isDead()) || (!testGoblin.isDead() && testImp.isDead()));

        System.out.println(testGoblin.inCombat(testImp));
        System.out.println(testGoblin.inCombat(testImp));
        System.out.println(testGoblin.inCombat(testImp));
        System.out.println(testGoblin.inCombat(testImp));
        System.out.println(testGoblin.inCombat(testImp));
        System.out.println(testGoblin.inCombat(testImp));
        System.out.println(testGoblin.inCombat(testImp));

        System.out.println(testGoblin.getHp());
        System.out.println(testImp.getHp());

        if(testGoblin.isDead()){
            System.out.println("dead");
        }else{
            System.out.println("notdead");
        }

        if(testImp.isDead()){
            System.out.println("dead");
        }else{
            System.out.println("notdead");
        }*/

        /*testGoblin.attacks(testImp);
        testGoblin.attacks(testImp);
        testGoblin.attacks(testImp);
        System.out.println(testImp.getHp());*/

        while(/*!testGoblin.isDead() ^ testImp.isDead()*/NPC.eitherNPCisDead(testGoblin, testImp)) {
            if (testGoblin.hitChance(testImp)) {
                testGoblin.attacks(testImp);
                System.out.println(testGoblin.getName() + " hit " + testImp.getName()  + testImp.curHP());
            } else {
                testImp.attacks(testGoblin);
                System.out.println(testImp.getName() + " hit " + testGoblin.getName() + testGoblin.curHP());
            }

            System.out.println(testGoblin.getHp());
            System.out.println(testImp.getHp());
        }

        System.out.println(testPlayer.getName());
        testPlayer.setName("joe");
        System.out.println(testPlayer.getName());


        testPlayer.setrHandAtk(testAxe.getDmg() + testPlayer.getAtk());
        testPlayer.setRhand(testAxe.getName());
        testPlayer.setDexAdj(testAxe.getSizeDexAdj());
        System.out.println(testPlayer.toString());

        testGoblin.setHp(20);

        while(NPC.eitherNPCisDead(testPlayer, testGoblin)){
            if(testPlayer.hitChance(testGoblin)){
                testPlayer.attacks(testGoblin);
                System.out.println(testPlayer.getName() + " hit " + testGoblin.getName()  + testGoblin.curHP());
            }else{
                testGoblin.attacks(testPlayer);
                System.out.println(testGoblin.getName() + " hit " + testPlayer.getName() + testPlayer.curHP());
            }
        }

        //testPlayer.setHp(testPlayer.getHp() + testPotion.getRestore());
        //restore(testPlayer);
        System.out.println(testPlayer.getHp());
        testPotion.restoreHP(testPlayer);
        System.out.println(testPlayer.getHp());
       

    }

    /*public void restore(NPC object){
        if(testPotion.getAmount() > 0){
            testPlayer.setHp(testPlayer.getHp() + testPotion.getRestore());
            testPotion.setAmount(-1);
            //return "Player hp is now " + testPlayer.getHp();
        }else{
            //return "no potions to use";
        }
    }*/

}
