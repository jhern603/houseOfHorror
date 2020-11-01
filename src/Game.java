import javax.swing.*;

public class Game {

    public void play() {

        String begin = input("Welcome to the house of horrors!\nAre you willing to enter?").toLowerCase();

        if (begin.contains("y")) {
            String playerName = input("What is your name?");
            Player player = new Player(playerName);

            
            output("You enter a suspcious looking house and find that the door shuts behind you.\n You try to open the door but it looks like it locked itself. Your only option is to traverse the house and find your way out.");

            do {
                String moveToInput = input("You are currently at the: " + player.getLocation()
                        + ".\nYou can move into the following rooms from here: " + player.connectedRooms()
                        + ".\nWhat would you like to do?");
                output(player.moveTo(moveToInput));
                output("You have found the following items in the room: "
                        + player.house.getAvailableItems(player.getLocation()));
            } while (true);

        } else {
            output("That's alright, maybe next time.");
            System.exit(-1);
        }

    }

    public static String input(String msg) {
        return JOptionPane.showInputDialog(null, msg, "Horrors of House", 1);
    }

    public static void output(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Horrors of House", 1);
    }
}
