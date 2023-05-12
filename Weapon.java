public class Weapon {
    private String name;
    private Boolean isGuilty;

    public Weapon(String name, boolean isGuilty) {
        this.name = name;
        this.isGuilty = isGuilty;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsGuilty() {
        return this.isGuilty;
    }
}
