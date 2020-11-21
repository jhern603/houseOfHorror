
//********************************************************************************
// Name:  Jose Hernandez
// FIU email: Jhern603@fiu.edu
// PantherID:  5712864
// CLASS: COP 2210 – 2020
// ASSIGNMENT # 3
// DATE: 04NOV20
//
// I hereby swear and affirm that this work is solely my own, and not the work
// or the derivative of the work of someone else.
//********************************************************************************
public class Player {
    // TODO: viewing inventory
    private String playerName;
    private final Integer INV_SIZE = 4;
    private String[] invContents = new String[INV_SIZE];
    private Room currentRoom;
    public RoomActions house = new RoomActions();

    public Player(String name) {
        playerName = name;
        currentRoom = house.returnStringAsRoom("entrance");
        invContents[0] = null;
        System.out.println("Player: "+name+" created.");
    }

    
    /** 
     * @return String returns the location of the player as a String
     */
    public String getLocation(){
        System.out.println("Player.getLocation:"+ currentRoom.getRoomName());
        return currentRoom.getRoomName();
    }

    
    /** 
     * @return String returns the player's name as a String
     */
    public String getName(){
        System.out.println("Player.getName: "+playerName);
        return playerName;
    }

    
    /** 
     * @return String returns the rooms that are connected to the room the player is currently in
     * @see RoomActions.generateRoom
     */
    public String connectedRooms(){
        System.out.println("Player.connectedRooms:" + house.getConnections(currentRoom.getRoomName()));
        return house.getConnections(currentRoom.getRoomName());
    }

    
    /** 
     * @param item takes the item that the user is trying to pickup as a String
     * @return String returns the name of the item as a String
     */
    public String pickupItem(String item){
        String returnStatus = "Something went wrong!";
        for(int i = 0; i < invContents.length; i++){
            if(invContents[i] == null || invContents[i].isEmpty()){
                invContents[i] = item;
                returnStatus = "You have picked up: " + item;
                System.out.println("Player.pickupItem: "+ item +" was picked up.");
                return returnStatus;
            }else{
                System.err.println("Player.pickupItem: Item was not picked up.");
                returnStatus = "You weren't able to pick that up!";
            }
        }
        return returnStatus;
    }

    
    /** 
     * @param toVisit takes the room the user wants to visit as a String
     * @return String returns a dialog informing the user if they successfully moved into a room or not
     */
    public String moveTo(String toVisit) {
        if (house.canMoveInto(currentRoom.getRoomName(), toVisit)) {
            currentRoom = house.returnStringAsRoom(toVisit);
            System.out.println("Player.moveTo: "+ currentRoom.getRoomName());
            return "You have moved into the " + currentRoom.getRoomName();
        }
        System.err.println("Player.moveTo: Movement failed");
        return "You cannot visit that room from here!";
    }

    
    /**
     * @param itemToInspect takes the item the user is trying to inspect as a String
     * @return String returns the description of the item as a String
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
