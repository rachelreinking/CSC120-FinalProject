/**
 * This creates a game that the player can play and associated methods that facilitate gameplay.
 * The game is played in the main method of this class 
 * This class has a dependency on Board Class
 * @author Rachel Reinking
 * @version 12 May 2023
 */

import java.util.ArrayList;
import java.util.Scanner;
import com.google.common.graph.*;

public class Game{
    public Board myBoard;
    public ArrayList<Character> myCharacters;
    public ArrayList<Room> myRooms;
    public Room myLocation;
    int myHints;

    /* Constructor */
    public Game(Board myBoard) {
        this.myBoard = myBoard;
        this.myCharacters = new ArrayList<Character>();
        this.myRooms = new ArrayList<Room>();
        this.myLocation = null;
        this.myHints = 0;
    }

    /* Accessor for myLocation */
    public Room getMyLocation() {
        return this.myLocation;
    }

    /*
     * This moves the player to the specified room, and has the character there give them clues if applicable
     * This updates the player's current location
     * @param roomNum The index of the room in myBoard.rooms
     */
    public void goToRoom(int roomNum) {
        this.myLocation = this.myBoard.getRoom(roomNum-1);
        Room r = this.myLocation;        

        if(!this.myRooms.contains(r)) {
            this.myRooms.add(r);
            System.out.println("You are in the " + r.getName() + ".");
            if(r.hasCharacter()){ 
                this.myCharacters.add(r.getCharacter());
                System.out.println(r.getCharacter().getName() + " is here.");
                System.out.println(r.getCharacter().getName() + " has clues to give you.");
                r.getCharacter().getClues();
                System.out.println();
            } else {
                System.out.println("There are no characters here.");
                System.out.println();
            }
        }

    }

    /*
     * This prints out hints for the player that are dynamically updated as gameplay continues
     * This prints out a maximum of three hints, which have to do with the character, room, and weapon respectively
     * this updates the player's number of hints remaining
     */
    public void getHints() {
        this.myHints += 1;
        if(this.myHints == 1) {
            boolean roomGuilty = false;
            for(int i = 0; i < this.myRooms.size(); i++) {
                if(this.myRooms.get(i).getIsGuilty()) {
                    System.out.println("Hint: you have already been in the room of the murder.");
                    roomGuilty = true;
                } 
            }
            if(!roomGuilty) {
                System.out.println("Hint: You have not yet been in the room of the murder.");
            }
        } else if(this.myHints == 2) {
            boolean charGuilty = false;
            for(int i = 0; i < this.myCharacters.size(); i++) {
                if(this.myCharacters.get(i).getIsGuilty()) {
                    System.out.println("Hint: you have already interviewed the guilty party.");
                    charGuilty = true;
                }
            }
            if(!charGuilty) {
                System.out.println("Hint: you have not yet interviewed the guilty party.");
            }
        } else if(this.myHints == 3) {
            System.out.println("Hint: Is it getting dark in here? If only there were some way to . . . shed some light on this case.");
        } else if(this.myHints < 1 || this.myHints > 3){
            System.out.println("There are not any hints to give");
        }

    }

    /*
     * This prints all of the information that the character has gathered so far
     * This also prints the complete list of subjects for comparison
     */
    public void getNotes() {
        System.out.println("Revealed Rooms: ");
        for (int j = 0; j < this.myRooms.size(); j++) {
            System.out.println(this.myRooms.get(j).getName());
        }
        System.out.println();
        System.out.println("Revealed characters and associated information:");
        for(int i = 0; i < this.myCharacters.size(); i++) {
            System.out.println("This character's name is: " + this.myCharacters.get(i).getName());
            this.myCharacters.get(i).getClues();
            System.out.println();
        }
    }

    /*
     * This allows a player to accuse a suspect and prints whether all the information was correct or if some of it was wrong
     * @param int charNum the index of the character in myBoard.characters
     * @param int roomNum The index of the room in myBoard.rooms
     * @param int roomNum The index of the weapon in myBoard.weapons
     */
    public void accuse(int charNum, int roomNum, int weaponNum) {
        if(this.myBoard.getCharacter(charNum-1).getIsGuilty()) {
            if(this.myBoard.getRoom(roomNum-1).getIsGuilty()) {
                if(this.myBoard.getWeapon(weaponNum-1).getIsGuilty()){
                    System.out.println("You find " + this.myBoard.getCharacter(charNum-1).getName() + " holding ");
                    System.out.println("Correct accusation." + this.myBoard.getCharacter(charNum-1).getName() + " is guilty. They used the " + this.myBoard.getWeapon(weaponNum-1).getName() + " in the " + this.myBoard.getRoom(roomNum-1).getName() + ". You have solved the mystery!");
                }
            }
        } else {
            System.out.println("The cellar is empty.");
            System.out.println("Incorrect accusation. You have failed in your mission and the guilty person still roams free.");
        }

    }


    public static void main(String[] args) {
        //establish characters
        Character scarlett = new Character("Miss Scarlett", false);
        Character green = new Character("Mr. Green", false);
        Character mustard = new Character("Colonel Mustard", true);
        Character plum = new Character("Professor Plum", false);
        Character peacock = new Character("Mrs. Peacock", false);
        Character white = new Character("Mrs. White", false);
        //establish rooms
        Room kitchen = new Room("Kitchen", false, true, peacock);
        Room ballroom = new Room("Ballroom", true, true, white);
        Room conservatory = new Room("Conservatory", false, true, scarlett);
        Room billiard = new Room("Billiard Room", false, true, green);
        Room library = new Room("Library", false, true, mustard);
        Room study = new Room("Study", false, false, null);
        Room hall = new Room("Hall", false, false, null);
        Room lounge = new Room("Lounge", false, false, null);
        Room dining = new Room("Dining Room", false, false, plum);
        Room cellar = new Room("Cellar", false, null, null);
        //establish weapons
        Weapon candlestick = new Weapon("Candlestick", true);
        Weapon dagger = new Weapon("Dagger", false);
        Weapon pipe = new Weapon("Lead Pipe", false);
        Weapon revolver = new Weapon("Revolver", false);
        Weapon rope = new Weapon("Rope", false);
        Weapon wrench = new Weapon("Wrench", false);
        //add clues to characters
        scarlett.addRoom(billiard);
        scarlett.addRoom(hall);
        scarlett.addCharacters(green);
        green.addRoom(kitchen);
        green.addWeapon(dagger);
        green.addWeapon(pipe);
        mustard.addRoom(lounge);
        mustard.addCharacters(white);
        mustard.addCharacters(plum);
        plum.addRoom(study);
        plum.addWeapon(rope);
        plum.addCharacters(peacock);
        peacock.addRoom(conservatory);
        peacock.addWeapon(revolver);
        peacock.addCharacters(scarlett);
        white.addRoom(library);
        white.addRoom(dining);
        white.addWeapon(wrench);
        
        Board myBoard = new Board();
        //add charactersto board
        myBoard.addCharacters(scarlett);
        myBoard.addCharacters(green);
        myBoard.addCharacters(mustard);
        myBoard.addCharacters(plum);
        myBoard.addCharacters(peacock);
        myBoard.addCharacters(white);
        //add rooms to board
        myBoard.addRoom(kitchen);
        myBoard.addRoom(ballroom);
        myBoard.addRoom(conservatory);
        myBoard.addRoom(billiard);
        myBoard.addRoom(library);
        myBoard.addRoom(study);
        myBoard.addRoom(hall);
        myBoard.addRoom(lounge);
        myBoard.addRoom(dining);
        myBoard.addRoom(cellar);
        //add weapons to board
        myBoard.addWeapon(candlestick);
        myBoard.addWeapon(dagger);
        myBoard.addWeapon(pipe);
        myBoard.addWeapon(revolver);
        myBoard.addWeapon(rope);
        myBoard.addWeapon(wrench);
        //create map
        //ImmutableGraph with Rooms as Node data
        ImmutableGraph<Room> myGraph = GraphBuilder.undirected()
        .<Room>immutable()
        .putEdge(kitchen, ballroom)
        .putEdge(kitchen, study)
        .putEdge(ballroom, conservatory)
        .putEdge(conservatory, billiard)
        .putEdge(conservatory, lounge)
        .putEdge(billiard, library)
        .putEdge(library, study)
        .putEdge(study, hall)
        .putEdge(hall, lounge)
        .putEdge(lounge, dining)
        .putEdge(dining, kitchen)
        .build();

        Game game = new Game(myBoard);
        Scanner input = new Scanner(System.in);

        System.out.println("This is much like the game of Clue, but with more twists and more deception");
        System.out.println("During a dinner party, Mr. Boddy has been found dead in his large manor. All his guests are suspects in his murder.");
        System.out.println("Here are all of the suspected people, weapons, and rooms involved in this case");
        System.out.println();
        myBoard.printCharacters();
        myBoard.printRooms();
        myBoard.printWeapons();
        System.out.println("You must interview each of the suspects, and take notes on what they know are **not** persons, weapons, and rooms involved in this case");
        System.out.println("To interview a character, you must enter the room where they are located");
        System.out.println("To move between rooms, the rooms must be next to each other or connected with a secret passage");
        System.out.println("Choose a room to examine to begin: ");
        myBoard.printRooms();

        int roomNum = input.nextInt();
        if(roomNum < 1 || roomNum > 9) {
            System.out.println("This is not a valid room to enter");
        } else {
            game.goToRoom(roomNum);
        }
        
        System.out.println("In case you haven't figured it out already, there are more rooms than suspects, so some of the rooms are empty.");
        System.out.println("Since there are six suspects, you may enter a maximum of six rooms before you are forced to make an accusation, whether or not you have gathered sufficient evidence.");
        System.out.println("You will also have access to a total of 3 hints throughout the game to help you solve the mystery.");
        System.out.println("In this game, there are five main actions you can take");
        System.out.println("1: You can enter a new room");
        System.out.println("2: You can review your notes on the case");
        System.out.println("3: You can get a hint that may help you solve this case. You have " + (3-game.myHints) + " hints remaining");
        System.out.println("4: You can be shown this menu again as a refresher of the actions");
        System.out.println("5: You can make a final accusation, which will automatically end the game");
        System.out.println("What would you like to do next? Enter a number");
        
        int action = input.nextInt();
        while(action != 5) {
            if(action == 1) {
                if(game.myRooms.size() < 6) {
                    System.out.println("Choose a room to enter:");
                    myBoard.printRooms();
                    roomNum = input.nextInt();
                    if(roomNum < 1 || roomNum > 9) {
                        System.out.println("This is not a valid room to enter");
                    } else {
                        if(myGraph.hasEdgeConnecting(game.myLocation, myBoard.rooms.get(roomNum-1))) {
                        game.goToRoom(roomNum); 
                        } else {
                            System.out.println("Cannot enter " + myBoard.rooms.get(roomNum-1).getName() + " from" + game.getMyLocation().getName() + ". Choose a room that is connected to " + game.getMyLocation().getName());
                    }
                    System.out.println();
                    System.out.println("What would you like to do next? Enter a number");
                    action = input.nextInt();
                    }
                    
                } else {
                    System.out.println("You have explored 6 rooms. You cannot explore any more rooms.");
                    System.out.println();
                    System.out.println("What would you like to do next? Enter a number");
                    action = input.nextInt();
                }
            } else if(action == 2) {
                game.getNotes();
                System.out.println("Here are all of the suspected people, weapons, and rooms involved in this case");
                System.out.println();
                myBoard.printCharacters();
                myBoard.printRooms();
                myBoard.printWeapons();
                System.out.println();
                System.out.println("What would you like to do next? Enter a number");
                action = input.nextInt();
            } else if(action == 3) {
                game.getHints();
                System.out.println();
                System.out.println("What would you like to do next? Enter a number");
                action = input.nextInt();
            } else if(action == 4) {
                System.out.println("1: You can enter a new room");
                System.out.println("2: You can review your notes on the case");
                System.out.println("3: You can get a hint that may help you solve this case. You have " + (3-game.myHints) + " hints remaining");
                System.out.println("4: You can be shown this menu again as a refresher of the actions");
                System.out.println("5: You can make a final accusation, which will automatically end the game");
                System.out.println();
                System.out.println("What would you like to do next? Enter a number");
                action = input.nextInt();
            } else if(action < 1 || action > 5) {
                System.out.println("Invalid command. Enter a number between 1 and 5");
                System.out.println();
                System.out.println("What would you like to do next? Enter a number");
                action = input.nextInt();
            }

        }
        System.out.println("You are accusing your suspect and therefore ending the game. Who are you accusing?");
        myBoard.printCharacters();
        int finalChar = input.nextInt();
        System.out.println("What weapon did they use?");
        myBoard.printWeapons();
        int finalWeapon = input.nextInt();
        System.out.println("What room did the murder occur?");
        myBoard.printRooms();
        int finalRoom = input.nextInt();

        System.out.println("You call the authorities and together you all enter the " + myBoard.getRoom(finalRoom).getName() + " and see a loose panel on the wall, which you didn't notice before.");
        System.out.println("You enter the secret passage and find you way to a hidden, restricted room in the mansion: the " + myBoard.getRoom(myBoard.rooms.size()-1).getName());
        game.myLocation = myBoard.getRoom(finalRoom);
        game.accuse(finalChar, finalRoom, finalWeapon);


            input.close(); 
        }  
    }
