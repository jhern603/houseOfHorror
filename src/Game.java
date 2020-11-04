import javax.swing.*;
import java.util.*;

public class Game { 

    public void play() {
        String begin = input("Welcome to the house of horrors!\nAre you willing to enter?").toLowerCase();
        if (begin.contains("y")) {
            String playerName = input("What is your name?");
            Player player = new Player(playerName);

            output("You enter a suspcious looking house and find that the door shuts behind you.\n You try to open the door but it looks like it locked itself. Your only option is to traverse the house and find your way out.");

            do {
                map(player.getLocation());
                String userInput = options("You are currently at the: " + player.getLocation().toUpperCase() + ".\nWhere would you like to go?", player.house.getConnectionsAsList(player.getLocation()).toArray()).toString();

                output(player.moveTo(userInput));
                
                if (userInput.equals("stairs")) {
                    output("The rickety stairs collapse as you go up each step, leaving you unable to go back down.");
                } else {
                    output("You enter the room. The door slams shut door behind you.\n You try to open the door but doesn't budge.");
                }

                if (player.house.getAvailableItems(player.getLocation()).length != 0) {
                    String itemChoice = options("You have found the following items in the room (Click to inspect): ",
                            player.house.getAvailableItems(player.getLocation())).toString();
                    if (!itemChoice.equals("OK")) {
                        output(player.inspectItem(itemChoice));
                        System.exit(1);
                    }
                }

            } while (true);
        } else

        {
            output("That's alright, maybe next time.");
            System.exit(1);
        }

    }

    private static String input(String msg) {
        return JOptionPane.showInputDialog(null, msg, "Horrors of House", 1);
    }

    private static void output(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Horrors of House", 1);
    }

    private static Object options(String msg, Object[] userOptions) {
        int option = JOptionPane.showOptionDialog(null, msg, "Horrors of House", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, userOptions, userOptions[0]);
        return userOptions[option];
    }

    // Use current locatino to pull the map for the user
    private static void map(String location) {
        HashMap<String, String> filePaths = new HashMap<>();
        filePaths.put("Entrance", "src\\media\\img\\map\\1entrance.png");
        filePaths.put("Living Room", "src\\media\\img\\map\\1lr.png");
        filePaths.put("bathroom", "src\\media\\img\\map\\1bathroom.png");
        filePaths.put("Dining Room", "src\\media\\img\\map\\1dining.png");
        filePaths.put("Kitchen", "src\\media\\img\\map\\1kitchen.png");
        filePaths.put("Pantry", "src\\media\\img\\map\\1pantry.png");
        filePaths.put("Stairs", "src\\media\\img\\map\\2stairs.png");
        filePaths.put("Bedroom 1", "src\\media\\img\\map\\2bedroom1.png");
        filePaths.put("Bedroom 2", "src\\media\\img\\map\\2bedroom2.png");
        filePaths.put("Upstairs bathroom", "src\\media\\img\\map\\2bathroom.png");
        filePaths.put("Master Bedroom", "src\\media\\img\\map\\2masterbed.png");
        filePaths.put("Master bathroom", "src\\media\\img\\map\\2masterbath.png");
        ImageIcon mapLocation = new ImageIcon(filePaths.get(location));
        JOptionPane.showMessageDialog(null, "", null, JOptionPane.DEFAULT_OPTION, mapLocation);
    }


}
