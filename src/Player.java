public class Player {
    // TODO: viewing inventory
    // BUG: Kicks player to exception if attempting to move to a non-existent room from not entrance
    // quit command does not work
    private String playerName;
    private final Integer INV_SIZE = 4;
    private String[] invContents = new String[INV_SIZE];
    private Room currentRoom;
    public RoomActions house = new RoomActions();

    public Player(String name) {
        playerName = name;
        currentRoom = house.getRoomProperties("entrance");
        invContents[0] = null;
        System.out.println("Player: "+name+" created.");
    }

    public String getLocation(){
        System.out.println("Player.getLocation:"+ currentRoom.getRoomName());
        return currentRoom.getRoomName();
    }

    public String getName(){
        System.out.println("Player.getName: "+playerName);
        return playerName;
    }

    public String connectedRooms(){
        System.out.println("Player.connectedRooms:" + house.getConnections(currentRoom.getRoomName()));
        return house.getConnections(currentRoom.getRoomName());
    }

    public String pickupItem(String item){
        String returnStatus = "Something went wrong!";
        for(int i = 0; i < invContents.length; i++){
            if(invContents[i] == "" || invContents[i] == null){
                invContents[i] = item;
                returnStatus = "You have picked up: " + item;
                System.out.println("Player.pickupItem: "+ item +" was picked up.");
            }else{
                System.err.println("Player.pickupItem: Item was not picked up.");
                returnStatus = "You weren't able to pick that up!";
            }
        }
        return returnStatus;
    }

    public String moveTo(String toVisit) {
        if (house.canMoveInto(currentRoom.getRoomName(), toVisit)) {
            currentRoom = house.getRoomProperties(toVisit);
            System.out.println("Player.moveTo: "+ currentRoom.getRoomName());
            return "You have moved into the " + currentRoom.getRoomName();
        }
        System.err.println("Player.moveTo: Movement failed");
        return "You cannot visit that room from here!";
    }

    public String inspectItem(String itemToInspect) {
        for (String item : house.getRoomProperties(currentRoom.getRoomName()).getItemNames()) {
            if (item.equals(itemToInspect)) {
                System.out.println("Player.getItemDesc: " + itemToInspect + "'s description returned");
                return house.getItemDesc(currentRoom, itemToInspect);
            }
        }
        System.err.println("Player.getItemDesc: No description returned");
        return "That is not an item in the room!";
    }

    // Performs linear search of the array to check if value is in any index of
    // array
    public boolean arrayContains(String value) {
        boolean status = false;
        for (int i = 0; i <= this.invContents.length; i++) {
            if (this.invContents[i].contains(value)) {
                status = true;
            } else {
                status = false;
            }
        }
        return status;
    }

    // Performs linear search of the array to return index value of array
    public int indexOf(String value) {
        if (this.invContents == null) {
            return -1;
        }
        int len = this.invContents.length;
        int i = 0;
        while (i < len) {
            if (invContents[i].equals(value)) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }
}
