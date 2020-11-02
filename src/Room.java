import java.util.*;

public class Room {
    private String roomName;
    private List<String> connectedRooms = new ArrayList<>();
    private HashMap<String, String> itemsInRoom = new HashMap<>();

    public Room() {
        this.roomName = "An exception has occurred!";
        this.connectedRooms.add("None");
    }

    public Room(String name) {
        this.roomName = name;
        this.connectedRooms.add("There are no connected rooms.");
    }

    public Room(String name, String[] connectedTo) {
        this.roomName = name;
        this.connectedRooms = Arrays.asList(connectedTo);
    }

    public void addItem(String name, String description) {
        this.itemsInRoom.put(name.toLowerCase(), description.toLowerCase());
        System.out.println("Room.addItem: " + name + " added.");
    }

    public List<String> getConnectedRooms() {
        Collections.sort(this.connectedRooms);
        return this.connectedRooms;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String[] getItemNames() {
        Set<String> itemsSet = this.itemsInRoom.keySet();
        String[] itemsArray = new String[itemsSet.size()];
        itemsArray = itemsSet.toArray(itemsArray);
        System.out.println("Room.getItemNames:" + Arrays.toString(itemsArray));

        return itemsArray;
    }

    public String getItemDesc(String key) {
        System.out.println("Room.getItemDesc:" + key + "'s Description returned");
        return this.itemsInRoom.get(key);
    }

}
