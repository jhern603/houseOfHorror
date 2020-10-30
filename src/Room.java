import java.util.*;

public class Room {
    private String roomName;
    private boolean visited;
    private int visitedCounter;
    private List<String> connectedRooms = new ArrayList<>();
    private HashMap<String, String> itemsInRoom = new HashMap<>();

    public Room(String name, String[] connectedTo) {
        this.roomName = name;
        this.connectedRooms = Arrays.asList(connectedTo);
        this.visitedCounter = 0;
        this.visited = false;
    }

    public int setVisited() {
        if (this.visited) {
            this.visitedCounter++;
            return 0;
        } else {
            this.visited = true; 
            this.visitedCounter++;
            return 1;
        }
    }

    public void addItem(String name, String description) {
        this.itemsInRoom.put(name.toLowerCase(), description.toLowerCase());
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

        return itemsArray;
    }

    public HashMap<String, String> getItemPairs() {
        return itemsInRoom;
    }

    public int getVisitedCount() {
        return this.visitedCounter;
    }

    public String returnObjAsString(Object method) {
        return method.toString().replace("[", "").replace("]", "");
    }
    
    public String returnArrAsString(Object[] array) {
        return Arrays.toString(array).replace("[", "").replace("]", "");
    }

}
