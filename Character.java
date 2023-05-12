import java.util.ArrayList;

public class Character {
    private String name;
    private Boolean isGuilty;
    //clues
    private ArrayList<Room> clueRooms;
    private ArrayList<Weapon> clueWeapons;
    private ArrayList<Character> clueCharacters;

    
    public Character(String name, Boolean isGuilty) {
        this.name = name;
        this.isGuilty = isGuilty;
        this.clueRooms = new ArrayList<Room>();
        this.clueWeapons = new ArrayList<Weapon>();
        this.clueCharacters = new ArrayList<Character>();
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsGuilty() {
        return this.isGuilty;
    }

    public ArrayList<Room> getRooms() {
        return this.clueRooms;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.clueWeapons;
    }

    public void getClues() {
        this.printRooms();
        this.printWeapons();
        this.printCharacters();
    }

    public void printRooms() {
        System.out.println("This character's rooms:");
        for(int i = 0; i < this.clueRooms.size(); i++) {
          System.out.println(this.clueRooms.get(i).getName());
        }
      }

    public void printWeapons() {
        System.out.println("This character's weapons");
        for(int i = 0; i < this.clueWeapons.size(); i++) {
          System.out.println(this.clueWeapons.get(i).getName());
        }
    }

    public void printCharacters() {
        System.out.println("This character's characters");
        for(int i = 0; i < this.clueCharacters.size(); i++) {
          System.out.println(this.clueCharacters.get(i).getName());
        }
    }

    public void addRoom(Room r)  {
        this.clueRooms.add(r);
    }

    public void addWeapon(Weapon w)  {
        this.clueWeapons.add(w);
    }

    public void addCharacters(Character c) {
        this.clueCharacters.add(c);
    }

    public static void main(String[] args) {
        
    }
}