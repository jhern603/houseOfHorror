public class Player {
    private String playerName;
    private final Integer INV_SIZE = 4;
    private String[] invContents = new String[INV_SIZE];
    private Room currentRoom;
    private Room prevRoom;
    private String emptyInv;


    public Player(String name) {
        playerName = name;
        emptyInv = (invContents.length == 0) ? "Your inventory is empty!" : "Something went wrong";
    }

    public void spawn() {

    }

    // Performs linear search of the array to check if value is in any index of
    // array

    // public boolean arrayContains(String value) {
    //     for (int i = 0; i <= this.invContents.length; i++) {
    //         if (this.invContents[i].contains(value)) {
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }
    //     return false;
    // }

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