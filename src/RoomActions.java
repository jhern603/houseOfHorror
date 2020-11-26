
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
import java.util.*;

public class RoomActions {
        private ArrayList<Room> rooms = new ArrayList<>();
        private final int AMOUNT_ROOMS = 19;
        private int counter;

        public RoomActions() {
                generateRooms();
        }

        /**
         * @apiNote Generates all the rooms as well as adds items into each room
         * @author Ernesto Alva
         */
        public void generateRooms() {
                Room myError, entranceRoom, livingRoom, bathroom, diningRoom, kitchen, pantry, upStairs, bed2,
                                upstairsBath, masterBed, masterBath, bed1, storageRoom, boilerRoom, attic, basement, outdoors, elevator;

                // Create room connections (also used for back tracking, which is currently
                // disabled)
                String[] lift = { "entrance", "living room", "bathroom", "dining room", "kitchen", "pantry", "stairs",
                                "bedroom 2", "upstairs bathroom", "master bedroom", "master bathroom", "bedroom 1",
                                "attic", "basement" };
                String[] basementConnect = { "storage room", "boiler room", "entrance" };
                String[] entrance = {"elevator", "outdoors"};

                // Create rooms
                myError = new Room();
                outdoors = new Room("You have escaped this crappy house", entrance);
                entranceRoom = new Room("Entrance", entrance);
                elevator = new Room("elevator", lift);
                livingRoom = new Room("Living Room", lift);
                bathroom = new Room("bathroom", lift);
                diningRoom = new Room("Dining Room", lift);
                kitchen = new Room("Kitchen", lift);
                pantry = new Room("Pantry", lift);
                upStairs = new Room("Stairs", lift);
                bed1 = new Room("Bedroom 1", lift);
                bed2 = new Room("Bedroom 2", lift);
                upstairsBath = new Room("Upstairs bathroom", lift);
                masterBed = new Room("Master Bedroom", lift);
                masterBath = new Room("Master bathroom", lift);
                attic = new Room("Attic", lift);
                storageRoom = new Room("Storage Room", basementConnect);
                boilerRoom = new Room("Boiler Room", basementConnect);
                basement = new Room("Basement", basementConnect);
                
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
                attic.addItem("house key", "You have found a second, slightly different, key");
                storageRoom.addItem("key", "You have found a glistening key. You wonder what it's for.");
                
                boilerRoom.addItem("Lever",
                                "You pull on the lever and the room fills up with steam, suffocating you to death.");

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
                rooms.add(attic);
                rooms.add(basement);
                rooms.add(storageRoom);
                rooms.add(boilerRoom);
                rooms.add(outdoors);
                rooms.add(elevator);

                System.out.println("RoomActions.generateRooms: Rooms generated");
        }

        
        /**
         * @return String returns room list as a String
         * @author Ernesto Alva
         */
        public String getRoomList() {
                String[] roomsArray = new String[AMOUNT_ROOMS];
                for (int i = 0; i < rooms.size(); i++) {
                        roomsArray[i] = rooms.get(i).getRoomName();
                }
                return returnArrAsString(roomsArray);
        }
        
        
        /**
         * @return String[] Returns room list as an array
         * @author Ernesto Alva
         */
        public String[] getRoomListAsArr() {
                String[] roomsArray = new String[AMOUNT_ROOMS];
                for (int i = 0; i < rooms.size(); i++) {
                        roomsArray[i] = rooms.get(i).getRoomName();
                }
                return roomsArray;
        }

        
        /**
         * @param room Will take a String input of a room
         * @return String[] returns items in a particular room
         * @author Julio Arroyo
         */
        public String[] getAvailableItems(String room) {
                room = room.toLowerCase();
                return returnStringAsRoom(room).getItemNames();
        }

        
        /**
         * @param currentRoom Will take an Object input of the current room
         * @param item        Will take a String input of an item
         * @return String returns item descriptions in a particular room
         * @author Julio Arroyo
         */
        public String getItemDesc(Room currentRoom, String item) {
                return currentRoom.getItemDesc(item);
        }

        
        /**
         * @param currentRoom Will take a String input of the current room
         * @param nextRoom    will take a String input of the next room
         * @return boolean returns a status of if you can travel to a particular room
         *         from the current room
         * @author Ernesto Alva
         */
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

        
        /**
         * @param currentRoom Will take a String input of the current room
         * @return List<String> returns the connected rooms to the current room
         * @author Julio Arroyo
         */
        public List<String> getConnectionsAsList(String currentRoom) {
                return returnStringAsRoom(currentRoom).getConnectedRooms();
        }

        
        /**
         * @param currentRoom Will take a String input of the current room
         * @return String Returns the connected room to the current room
         * @author Sebastian Cubillos
         */
        public String getConnections(String currentRoom) {
                return returnObjAsString(returnStringAsRoom(currentRoom).getConnectedRooms());
        }

        
        /**
         * @param attemptedRoom Will take a String input of an attempted room
         * @return Room returns the room as a string
         * @author Sebastian Cubillos
         */
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

        
        /**
         * @param method Will take an Object input of a method
         * @return String Returns an object as a String
         * @author Jose Hernandez
         */
        public String returnObjAsString(Object method) {
                return method.toString().replace("[", "").replace("]", "");
        }

        
        /**
         * @param array will take an Object array input of an array
         * @return String Returns an array as a String
         * @author Jose Hernandez
         */
        public String returnArrAsString(Object[] array) {
                return Arrays.toString(array).replace("[", "").replace("]", "");
        }

}