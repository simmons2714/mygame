public class Game{

    public static void main(String[] args) {
        Goblin testGoblin = new Goblin();
        Imp testImp = new Imp();
        testImp.UnImp();
        testGoblin.UnGoblin();

        System.out.println("The " +  testImp.getName() + " has an attack of " + testImp.getAtk() + ". The imp HP is " + testImp.getHp() );
        System.out.println("The " +  testGoblin.getName() + " has an attack of " + testGoblin.getAtk() + ". The goblin HP is " + testGoblin.getHp() );
    }
}
