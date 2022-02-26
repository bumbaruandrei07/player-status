package PlayerStatus;

public class Main {
    public static void main(String[] args) {

        PlayerStatus player1 = new PlayerStatus();
        player1.initPlayer("Sidious", 3, 30000);

        PlayerStatus player2 = new PlayerStatus();
        player2.initPlayer("Yoda", 3, 900);

        player1.findArtifact(3);
        player2.findArtifact(103);

        player1.setWeaponInHand("sniper");
        player2.setWeaponInHand("knife");

        player1.movePlayerTo(20, 123);
        player2.movePlayerTo(12, 341);

        player2.displayPlayerStatus();

        System.out.println("Player one is attacking player 2 ");
        player1.attackOpponent(player2);

        player2.displayPlayerStatus();

        System.out.println("First player weapon: " + player1.getWeaponInHand());
        System.out.println("Second player weapon: " + player2.getWeaponInHand());


        player1.setWeaponInHand("knife");

        System.out.print("When player 1 is trying to attack player 2: ");
        player1.shouldAttackOpponent(player2);

        System.out.print("When player 2 is trying to attack player 1: ");
        player2.shouldAttackOpponent(player1);

        player1.movePlayerTo(123, 1234);
        player2.movePlayerTo(124, 2131);

        player1.findArtifact(7);
        player2.findArtifact(17);
        player2.displayPlayerStatus();
        player1.attackOpponent(player2);

        player1.displayPlayerStatus();
        player2.displayPlayerStatus();

        player2.attackOpponent(player1);
        player1.displayPlayerStatus();
        player2.attackOpponent(player1);
        player2.attackOpponent(player1);
        player2.attackOpponent(player1);
        player2.attackOpponent(player1);
        player1.displayPlayerStatus();

        PlayerStatus player3 = new PlayerStatus();
        player3.initPlayer("Darth Vader", 3, 50000);

        player3.findArtifact(2); //prime number
        player3.findArtifact(496); //perfect number
        player3.findArtifact(7); // prime number
        player3.movePlayerTo(20, 50);
        player3.setWeaponInHand("kalashnikov");
        player3.displayPlayerStatus();

        PlayerStatus player4 = new PlayerStatus();
        player4.initPlayer("Obi-Wan Kenobi", 3, 20000);
        player4.setWeaponInHand("sniper");
        player4.findArtifact(28); //perfect number
        player4.findArtifact(9); //ordinary number
        player4.findArtifact(210); //even number and the sum of its digits is 3
        player4.findArtifact(28);
        player4.movePlayerTo(100, 200);
        player4.displayPlayerStatus();
        System.out.print("If Obi-Wan tries to attack Yoda: ");
        player4.shouldAttackOpponent(player2);
        System.out.print("If Darth Vader tries to attack Yoda: ");
        player3.shouldAttackOpponent(player2);
        System.out.println("Obi-Wan attacks Darth Vader: ");
        player4.attackOpponent(player3);
        player4.attackOpponent(player3);
        player4.attackOpponent(player3);
        player4.attackOpponent(player3);
        player4.attackOpponent(player3);
        player4.attackOpponent(player3);
        player4.attackOpponent(player3);
        player3.displayPlayerStatus();

    }
}
