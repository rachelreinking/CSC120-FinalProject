public class Room {
    private String name;
    private Boolean isGuilty;
    private Boolean hasCharacter;
    private Character character;

    public Room(String name, boolean isGuilty, Boolean hasCharacter, Character character) {
        this.name = name;
        this.isGuilty = isGuilty;
        this.hasCharacter = hasCharacter;
        this.character = character;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsGuilty() {
        return this.isGuilty;
    }

    public Character getCharacter() {
        return this.character;
    }

    public Boolean hasCharacter() {
        return this.hasCharacter;
    }
}
