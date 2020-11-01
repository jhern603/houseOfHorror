public class Player {
    // TODO: picking up items, viewing inventory
    private String playerName;
    private final Integer INV_SIZE = 4;
    private String[] invContents = new String[INV_SIZE];
    private Room currentRoom;
    public RoomActions house = new RoomActions();

    public Player(String name) {
        playerName = name;
        currentRoom = house.getRoomProperties("entrance");
        invContents[0] = null;
    }

    public String getLocation(){
        return currentRoom.getRoomName();
    }

    public String getName(){
        return playerName;
    }

    public String connectedRooms(){
        return house.getConnections(currentRoom.getRoomName());
    }

    public String moveTo(String toVisit) {
        if (house.canMoveInto(currentRoom.getRoomName(), toVisit)) {
            currentRoom = house.getRoomProperties(toVisit);
            return "You have moved into the " + currentRoom.getRoomName();
        }
        return "You cannot visit that room from here!";
    }

    public String inspectItem(String itemToInspect) {
        for (String item : house.getRoomProperties(currentRoom.getRoomName()).getItemNames()) {
            if (item.equals(itemToInspect)) {
                return house.getItemDesc(currentRoom, itemToInspect);
            }
        }
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
