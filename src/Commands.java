public class Commands {
    private static final String[] validCommands = { "move", "inspect", "quit" };

    public boolean isCommand(String input) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].contains(input))
                return true;
        }
        return false;
    }

    public String command(String input) {
        String command = "none";
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].contains(input))
                command = validCommands[i];
        }
        return command;
    }

    public String getCommandList() {
        String commandString = "";
        for (String command : validCommands) {
            commandString += command + " ";
        }
        return commandString;
    }

}
