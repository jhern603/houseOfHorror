import javax.swing.*;

public class Game {

    public void play() {
        Commands cmd = new Commands();
        String begin = input("Welcome to the house of horrors!\nAre you willing to enter?").toLowerCase();

        if (begin.contains("y")) {
            String playerName = input("What is your name?");
            Player player = new Player(playerName);

            output("You enter a suspcious looking house and find that the door shuts behind you.\n You try to open the door but it looks like it locked itself. Your only option is to traverse the house and find your way out.");

            do {
                String userInput = input("You are currently at the: " + player.getLocation().toUpperCase()
                        + ".\nYou can move into the following rooms from here: " + player.connectedRooms().toUpperCase()
                        + ".\nWhat would you like to do?(Your available commands are: " + cmd.getCommandList() + ")");

                String[] inputToArray = userInput.split(" ");
                String userCommand = inputToArray[0];
                String userWord = (inputToArray.length <= 2) ? inputToArray[1]
                        : ((inputToArray.length <= 3) ? inputToArray[1] + " " + inputToArray[2]
                                : inputToArray[1] + " " + inputToArray[2] + " " + inputToArray[3]);

                if (cmd.command(userCommand).equals("move")) {
                    output(player.moveTo(userWord));
                    output("You have found the following items in the room: "
                            + player.house.getAvailableItems(player.getLocation()).toUpperCase());
                } else if (cmd.command(userCommand).equals("quit")) {
                    output("You really thought you can quit just like that?\nYou entered this house, now you have to explore it.");

                } else if (cmd.command(userCommand).equals("inspect")) {
                    output(player.inspectItem(userWord));
                    String pickup = input("Would you like to pick this item up?");
                    if (pickup.contains("y")) {
                        output(player.pickupItem(userWord));
                        System.exit(1);
                    }
                } else {
                    output("That is not a valid command!");
                }
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
