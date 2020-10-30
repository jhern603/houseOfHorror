import java.util.*;

public class RoomActions {
        // Use this class to visit rooms which will have to check if the room has a
        // connected room and if the user is in the room
        private ArrayList<Room> rooms = new ArrayList<>();
        private int amountRooms = 12;

        public RoomActions() {
                generateRooms();
        }

        public void generateRooms() {
                Room entranceRoom, livingRoom, bathroom, diningRoom, kitchen, pantry, upStairs, bed2, upstairsBath,
                                masterBed, masterBath, bed1;

                // Create room connections
                String[] noConnections = { "There are no connected rooms." };
                String[] connectedRoomsEntrance = { "Stairs", "Living Room", "Dining Room" };
                String[] connectedRoomsLR = { "Bathroom" };
                String[] connectedRoomsDining = { "Kitchen" };
                String[] connectedRoomsKitchen = { "Pantry" };
                String[] connectedRoomsUpStairs = { "Master Bedroom", "Bedroom 2", "Bedroom 1" };
                String[] connectedRoomsBedroom1 = { "Upstairs Bathroom" };
                String[] connectedRoomsBedroom2 = { "Upstairs Bathroom" };
                String[] connectedRoomsMasterBed = { "master bathroom" };

                // Create rooms
                entranceRoom = new Room("Entrance", connectedRoomsEntrance);
                livingRoom = new Room("Living Room", connectedRoomsLR);
                bathroom = new Room("bathroom", noConnections);
                diningRoom = new Room("Dining Room", connectedRoomsDining);
                kitchen = new Room("Kitchen", connectedRoomsKitchen);
                pantry = new Room("Pantry", noConnections);
                upStairs = new Room("Up Stairs", connectedRoomsUpStairs);
                bed1 = new Room("Bedroom 1", connectedRoomsBedroom1);
                bed2 = new Room("Bedroom 2", connectedRoomsBedroom2);
                upstairsBath = new Room("Upstairs bathroom", noConnections);
                masterBed = new Room("Master Bedroom", connectedRoomsMasterBed);
                masterBath = new Room("Master bathroom", noConnections);

                // Add items to room
                livingRoom.addItem("Chest", "Ghost escapes and scares you to death");

                bathroom.addItem("Mirror", "you see a blood face looking back at you");
                bathroom.addItem("Shower",
                                "the bathroom suddenly steams up and you feel fingers touching the back of your neck");

                diningRoom.addItem("Candelabra",
                                "the candelabra light up by themselves and you see a shadow that resembles death");

                kitchen.addItem("Refrigerator", "you open the refrigerator and find some delicious **soul** food");
                kitchen.addItem("Cabinet",
                                "the dishes and glasses start flying at you as soon as you open the cabinets. You get hit in the head and feel yourself start moving towards the light.");

                pantry.addItem("Dusty recipe box", "You open the box and find a recipe for chocolate devils food cake");
                pantry.addItem("Broom", "the broom starts floating as soon as you touch it");

                bed1.addItem("Rocking chair", "the chair starts rocking on its own");

                bed2.addItem("Doll House", "the dolls inside the house start dancing on their own");
                bed2.addItem("Dresser", "A ghost flies out and through your body as you open the dresser");

                upstairsBath.addItem("Mirror", "you see a blood face looking back at you");
                upstairsBath.addItem("Shower",
                                "the bathroom suddenly steams up and you feel fingers touching the back of your neck");

                masterBed.addItem("Jewelry Box", "you find the cursed hope diamond and feel your doom");

                masterBath.addItem("Jewelry Box", "you find the cursed Hope Diamond and feel your doom");
                masterBath.addItem("Intricate Oil Lamp",
                                "you rub the lamp and a genie pops out who will grant you three wishes");
                masterBath.addItem("Mirror", "you see a blood face looking back at you");
                masterBath.addItem("Shower",
                                "the bathroom suddenly steams up and you feel fingers touching the back of your neck");

                // Add rooms to collection
                rooms.add(entranceRoom);
                rooms.add(livingRoom);
                rooms.add(bathroom);
                rooms.add(diningRoom);
                rooms.add(kitchen);
                rooms.add(pantry);
                rooms.add(upStairs);
                rooms.add(bed2);
                rooms.add(upstairsBath);
                rooms.add(masterBed);
                rooms.add(masterBath);
                rooms.add(bed1);
        }

        // Do something with the enhanced For loop
        public String getRooms() {
                String[] roomsArray = new String[amountRooms];
                for (int i = 0; i < rooms.size(); i++) {
                        roomsArray[i] = rooms.get(i).getRoomName();
                }
                return Arrays.toString(roomsArray).replace("[", "").replace("]", "");
        }

        // Make a conditional to run through each room and match it to the input. If
        // they match, then return the items in the room
        // Iterate through each "room" item and compare against user input
        public String getItemsShort(String room) {
                String returnCase = "An error has occurred!";
                room = room.toLowerCase();

                for (int i = 0; i < rooms.size(); i++) {
                        String roomObj = rooms.get(i).getRoomName().toLowerCase();
                        boolean isEqual = (roomObj.equals(room));
                        if (roomObj.equals(room)) {
                                returnCase = Arrays.toString(rooms.get(i).getItemNames());
                                return returnCase;
                        } else {
                                returnCase = "There are no items in this room!";
                        }
                }
                return returnCase;
        }

        public static void main(String[] args) {
                RoomActions test = new RoomActions();
                System.out.println(test.getItemsShort("pantry"));
        }

}