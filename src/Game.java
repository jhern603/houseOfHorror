
//********************************************************************************
// Name:  Jose Hernandez
// FIU email: Jhern603@fiu.edu
// PantherID:  5712864
// CLASS: COP 2210 – 2020
// ASSIGNMENT # 3
// DATE: 04NOV20
//
// I hereby swear and affirm that this work is solely my own, and not the work
// or the derivative of the work of someone lse, except as outlined in the 
// assignment instructions.
//********************************************************************************
import javax.swing.*;
import java.util.*;

public class Game {

    /**
     * @apiNote This method is used to initialize and build the game
     * @author Luis Loboff
     */
    
    public void play() {
        String begin = input("Welcome to the house of horrors!\nAre you willing to enter?").toLowerCase();
        if (begin.contains("y")) {
            String playerName = input("What is your name?");
            Player player = new Player(playerName);
    
            output("You enter a suspcious looking house and find that the door shuts behind you.\n You try to open the door but it looks like it locked itself. Your only option is to traverse the house and find your way out.");
    
            do {
                String userInput = options(
                        "You are currently at the: " + player.getLocation() + ".\nWhere would you like to go?",
                        player.house.getConnectionsAsList(player.getLocation()).toArray()).toString();
    
                if (userInput.equals("attic") && player.getInvContents().contains("key")) {
                    output(player.moveTo(userInput));
                    map(player.getLocation());
                    if (player.house.getAvailableItems(player.getLocation()).length != 0) {
                        String itemChoice = options(
                                "You have found the following items in the room (Click to inspect): ",
                                player.house.getAvailableItems(player.getLocation())).toString();
                        if (!itemChoice.equals("OK")) {
                            output(player.inspectItem(itemChoice));
                            output(player.pickupItem(itemChoice));
                            if (!player.openInventory().isEmpty())
                                output("You currently have: " + player.openInventory());
                        }
                    }
                } else if (userInput.equals("outdoors") && player.getInvContents().contains("house key")) {
                    output("You finally have espaced this terrible house");
                    System.exit(1);
    
                } else if (!userInput.equals("attic") && !userInput.equals("outdoors")) {
                    output(player.moveTo(userInput));

                    if(!userInput.equals("elevator"))
                        map(player.getLocation());
                    
                    if (player.house.getAvailableItems(player.getLocation()).length != 0) {
                        String itemChoice = options(
                                "You have found the following items in the room (Click to inspect): ",
                                player.house.getAvailableItems(player.getLocation())).toString();
                        if (itemChoice.equalsIgnoreCase("chest") || itemChoice.equalsIgnoreCase("shower")
                                || itemChoice.equalsIgnoreCase("cabinet") || itemChoice.equalsIgnoreCase("lever")) {
                            output(player.inspectItem(itemChoice));
                            System.exit(1);
                        } else if (!itemChoice.equals("OK")) {
                            output(player.inspectItem(itemChoice));
                            output(player.pickupItem(itemChoice));
                            if (!player.openInventory().isEmpty())
                                output("You currently have: " + player.openInventory());
                        }
                    }
                } else {
                    output("This door is locked. Looks like you need a key to get through.");
                }
    
            } while (true);
        } else
    
        {
            output("That's alright, maybe next time.");
            System.exit(1);
        }
    
    }
    
    /**
     * @param msg will take A String input from play() class
     * @return String Creates a JOptionPane window that takes User input and stores
     *         it
     * @author Jose Hernandez
     */
    private static String input(String msg) {
        return JOptionPane.showInputDialog(null, msg, "Horrors of House", 1);
    }

    /**
     * @param msg Creates a JOptionPane window that displays a message
     * @author Jose Hernandez
     */
    private static void output(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Horrors of House", 1);
    }

    /**
     * @param msg         Will take a String input of the message being returned by
     *                    the UserOption
     * @param userOptions Will take an Object input that reflects what the user
     *                    chose at any given time
     * @return Object Creates a JOptionPane window that displays a drop down
     *         selection system
     * @author Jose Hernandez
     */
    private static Object options(String msg, Object[] userOptions) {
        String option = (String) JOptionPane.showInputDialog(null, msg, "Horrors of House",
                JOptionPane.QUESTION_MESSAGE, null, userOptions, userOptions[0]);
        return option;
    }

    /**
     * @param location Displays a map for each room
     * @author Jose Hernandez
     */
    private static void map(String location) {
        HashMap<String, String> filePaths = new HashMap<>();
        filePaths.put("Entrance", "src\\media\\img\\map\\FrontDoor.jpg");
        filePaths.put("Basement", "src\\media\\img\\map\\Basement.jpg");
        filePaths.put("Storage Room", "src\\media\\img\\map\\Basement.jpg");
        filePaths.put("Boiler Room", "src\\media\\img\\map\\Basement.jpg");
        filePaths.put("Living Room", "src\\media\\img\\map\\LivingRoom.jpg");
        filePaths.put("bathroom", "src\\media\\img\\map\\Bathroom1.jpg");
        filePaths.put("Dining Room", "src\\media\\img\\map\\DiningRoom.jpg");
        filePaths.put("Kitchen", "src\\media\\img\\map\\Kitchen.jpg");
        filePaths.put("Pantry", "src\\media\\img\\map\\Pantry.jpg");
        filePaths.put("Bedroom 1", "src\\media\\img\\map\\Bedroom1.jpg");
        filePaths.put("Bedroom 2", "src\\media\\img\\map\\Bedroom2.jpg");
        filePaths.put("Upstairs bathroom", "src\\media\\img\\map\\Bathroom2.jpg");
        filePaths.put("Master Bedroom", "src\\media\\img\\map\\MasterBedroom.jpg");
        filePaths.put("Master bathroom", "src\\media\\img\\map\\MasterBathroom.jpg");
        ImageIcon mapLocation = new ImageIcon(filePaths.get(location));
        JOptionPane.showMessageDialog(null, "", "Current Location", JOptionPane.DEFAULT_OPTION, mapLocation);
    }

}
