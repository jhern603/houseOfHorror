import java.util.*;

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
public class Player {
    private String playerName;
    private List<String> invContents = new ArrayList<>();
    private Room currentRoom;
    public RoomActions house = new RoomActions();

    public Player(String name) {
        playerName = name;
        currentRoom = house.returnStringAsRoom("entrance");
        System.out.println("Player: " + name + " created.");
    }

    /**
     * @return String returns the location of the player as a String
     * @author Santiago Aday
     */
    public String getLocation() {
        System.out.println("Player.getLocation:" + currentRoom.getRoomName());
        return currentRoom.getRoomName();
    }

    /**
     * @return String returns the player's name as a String
     * @author Santiago Aday
     */
    public String getName() {
        System.out.println("Player.getName: " + playerName);
        return playerName;
    }

    /**
     * @return String returns the rooms that are connected to the room the player is
     *         currently in
     * @see RoomActions.generateRoom
     * @author Jose Hernandez
     */
    public String connectedRooms() {
        System.out.println("Player.connectedRooms:" + house.getConnections(currentRoom.getRoomName()));
        return house.getConnections(currentRoom.getRoomName());
    }

    /**
     * 
     * @return String returns the contents of the user's inventory
     * @author Santiago Aday
     */
    public String openInventory() {
        String[] contents = new String[invContents.size()];
        for (int i = 0; i < invContents.size(); i++) {
            contents[i] = invContents.get(i);
        }

        return house.returnArrAsString(contents);
    }

    /**
     * 
     * @return String returns the contents of the user's inventory
     * @author Julio Arroyo
     */
    public List<String> getInvContents() {
        return invContents;
    }

    /**
     * @param item takes the item that the user is trying to pickup as a String
     * @return String returns the name of the item as a String
     * @author Jose Hernandez
     */
    public String pickupItem(String item) {
        String returnStatus = "Something went wrong!";
        if (invContents.contains(item)) {
            returnStatus = "You already have: " + item;
            System.out.println("Player.pickupItem: " + item + " already in inventory.");

        } else {
            invContents.add(item);
            returnStatus = "You have picked up: " + item;
            System.out.println("Player.pickupItem: " + item + " was picked up.");
        }
        return returnStatus;
    }

    /**
     * @param toVisit takes the room the user wants to visit as a String
     * @return String returns a dialog informing the user if they successfully moved
     *         into a room or not
     * @author Jose Hernandez
     */
    public String moveTo(String toVisit) {
        if (house.canMoveInto(currentRoom.getRoomName(), toVisit)) {
            currentRoom = house.returnStringAsRoom(toVisit);
            System.out.println("Player.moveTo: " + currentRoom.getRoomName());
            return "You have moved into the " + currentRoom.getRoomName();
        }
        System.err.println("Player.moveTo: Movement failed");
        return "You cannot visit that room from here!";
    }

    /**
     * @param itemToInspect takes the item the user is trying to inspect as a String
     * @return String returns the description of the item as a String
     * @author Sebastian Cubillos
     */
    public String inspectItem(String itemToInspect) {
        for (String item : house.returnStringAsRoom(currentRoom.getRoomName()).getItemNames()) {
            if (item.equals(itemToInspect)) {
                System.out.println("Player.getItemDesc: " + itemToInspect + "'s description returned");
                return house.getItemDesc(currentRoom, itemToInspect);
            }
        }
        System.err.println("Player.getItemDesc: No description returned");
        return "That is not an item in the room!";
    }

}
