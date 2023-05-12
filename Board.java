import java.util.ArrayList;


public class Board {
    public ArrayList<Character> characters;
    public ArrayList<Room> rooms;
    public ArrayList<Weapon> weapons;

    public Board() {
        this.characters = new ArrayList<Character>();
        this.rooms = new ArrayList<Room>();
        this.weapons = new ArrayList<Weapon>();
    }

    public Character getCharacter(int i) {
        return this.characters.get(i);
    }

    public void getCharacterInfo(int i) {
        System.out.println("This character's name is: " + this.characters.get(i).getName());
        this.characters.get(i).getClues();
    }

    public Room getRoom(int i) {
        return this.rooms.get(i);
    }

    public Weapon getWeapon(int i) {
        return this.weapons.get(i);
    }

    public void addCharacters(Character c) {
        this.characters.add(c);
    }

    public void addRoom(Room r) {
        this.rooms.add(r);
    }

    public void addWeapon(Weapon w) {
        this.weapons.add(w);
    }

    public void printCharacters() {
        System.out.println("Characters:");
        for(int i = 0; i < this.characters.size(); i++) {
            System.out.println((i+1) +": " + this.characters.get(i).getName());
        }
        System.out.println();
    }

    public void printRooms() {
        System.out.println("Rooms:");
        for(int i = 0; i < (this.rooms.size()-1); i++) {
            System.out.println((i+1) +": " + this.rooms.get(i).getName());
        }
        System.out.println();
    }

    public void printWeapons() {
        System.out.println("Weapons:");
        for(int i = 0; i < this.weapons.size(); i++) {
            System.out.println((i+1) +": " + this.weapons.get(i).getName());
        } 
        System.out.println();
    }


    public static void main(String[] args) {
    
    }
}
