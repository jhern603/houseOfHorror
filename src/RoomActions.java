import java.util.*;

public class RoomActions {
        private ArrayList<Room> rooms = new ArrayList<>();
        private final int AMOUNTROOMS = 13;
        private int counter;

        public RoomActions() {
                generateRooms();
        }

        public void generateRooms() {
                Room myError, entranceRoom, livingRoom, bathroom, diningRoom, kitchen, pantry, upStairs, bed2,
                                upstairsBath, masterBed, masterBath, bed1;

                // Create room connections (also used for back tracking, which is currently
                // disabled)
                String[] connectedRoomsEntrance = { "stairs", "living room", "dining room" };
                String[] connectedRoomsLR = { "bathroom" };
                String[] connectedRoomsDining = { "kitchen" };
                String[] connectedRoomsKitchen = { "pantry" };
                String[] connectedRoomsUpStairs = { "master bedroom", "bedroom 2", "bedroom 1" };
                String[] connectedRoomsBedroom = { "upstairs bathroom" };
                String[] connectedRoomsUpStairsBath = { "bedroom 1", "bedroom 2" };
                String[] connectedRoomsMasterBed = { "master bathroom" };
                String[] connectedRoomsBathroom = { "living room" };
                String[] connectedRoomsPantry = { "kitchen" };
                String[] connectedRoomsMasterBath = { "master bedroom" };

                // Create rooms
                myError = new Room();
                entranceRoom = new Room("Entrance", connectedRoomsEntrance);
                livingRoom = new Room("Living Room", connectedRoomsLR);
                bathroom = new Room("bathroom");
                diningRoom = new Room("Dining Room", connectedRoomsDining);
                kitchen = new Room("Kitchen", connectedRoomsKitchen);
                pantry = new Room("Pantry");
                upStairs = new Room("Stairs", connectedRoomsUpStairs);
                bed1 = new Room("Bedroom 1", connectedRoomsBedroom);
                bed2 = new Room("Bedroom 2", connectedRoomsBedroom);
                upstairsBath = new Room("Upstairs bathroom");
                masterBed = new Room("Master Bedroom", connectedRoomsMasterBed);
                masterBath = new Room("Master bathroom");

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
                rooms.add(myError);
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

                System.out.println("RoomActions.generateRooms: Rooms generated");
        }

        public String getRoomList() {
                String[] roomsArray = new String[AMOUNTROOMS];
                for (int i = 0; i < rooms.size(); i++) {
                        roomsArray[i] = rooms.get(i).getRoomName();
                }
                return returnArrAsString(roomsArray);
        }

        public String[] getAvailableItems(String room) {
                room = room.toLowerCase();
                return returnStringAsRoom(room).getItemNames();
        }

        public String getItemDesc(Room currentRoom, String item) {
                return currentRoom.getItemDesc(item);
        }

        public boolean canMoveInto(String currentRoom, String nextRoom) {
                currentRoom = currentRoom.toLowerCase();
                nextRoom = nextRoom.toLowerCase();
                int numberConnectedRooms = returnStringAsRoom(currentRoom).getConnectedRooms().size();
                boolean status = false;
                for (counter = 0; counter < numberConnectedRooms; counter++) {
                        if (returnStringAsRoom(currentRoom).getConnectedRooms().get(counter).contains(nextRoom)) {
                                status = true;
                        }
                }
                return status;

        }

        public List<String> getConnectionsAsArr(String currentRoom) {
                return returnStringAsRoom(currentRoom).getConnectedRooms();
        }

        public String getConnections(String currentRoom) {
                return returnObjAsString(returnStringAsRoom(currentRoom).getConnectedRooms());
        }

        public Room returnStringAsRoom(String attemptedRoom) {
                attemptedRoom = attemptedRoom.toLowerCase();
                Room room = rooms.get(0);
                for (int i = 0; i < rooms.size(); i++) {
                        String roomObj = rooms.get(i).getRoomName().toLowerCase();
                        if (roomObj.equals(attemptedRoom)) {
                                room = rooms.get(i);
                        }
                }
                return room;
        }

        public String returnObjAsString(Object method) {
                return method.toString().replace("[", "").replace("]", "");
        }

        public String returnArrAsString(Object[] array) {
                return Arrays.toString(array).replace("[", "").replace("]", "");
        }

}