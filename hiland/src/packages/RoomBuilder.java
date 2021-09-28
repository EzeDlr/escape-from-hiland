package packages;

import java.util.concurrent.TimeUnit;
import java.net.Socket;
import java.util.Scanner;

import packages.Personaje;
import packages.Monster;

public class RoomBuilder {
    
    Scanner teclado = new Scanner(System.in);
    private String roomName;
    private String roomDescription;

    public void roomHallDoor(Monster monster, Personaje personaje) {

        monster.health = 30f;
        monster.gold = 150;
    

        System.out.println("Big Skeleton: I have a gift for you, but first you have to kill me!");
        do {
            personaje.Attack(monster);
            monster.attackProbability(personaje);
            System.out.println(monster.health);
        } while(monster.health != 0);

        if(monster.health == 0) {
            System.out.println("Hint: in the west side of the dungeon, you will find a shop!");
        }
    }

    public boolean roomHall(Monster monster, Personaje personaje) {
        roomName = "Hall";
        roomDescription = "Welcome!";
        boolean unlockHallDoor = false;
        String go;

        System.out.println("A monster appeared! Fight him");
        //Combat
        do {
            personaje.Attack(monster);
            monster.attackProbability(personaje);
        } while(monster.health != 0);

        if(monster.health == 0) {
            System.out.print("You killed the monster. Seems a new door is open. Write 'Go': ");
            System.out.println();
        }

        go = teclado.next(); 
        if(go.equalsIgnoreCase("go")) {
            unlockHallDoor = true;
        } else {
            System.err.println("Error");
        }
        return unlockHallDoor;
    }
    

    public static void main(String[] args) throws InterruptedException {
        
        // Room buillder, character and monsters.
        RoomBuilder roomBuilder = new RoomBuilder();
        Personaje personaje = new Personaje();
        Monster monster = new Monster();
        Monster monster2 = new Monster();


        //If the returned value of roomHall() method is true, call the roomHallDoor()
        //method with a new monster instance. New monster instance is used because
        //in this new room, is a new monster that appeared.

        
     boolean hall = roomBuilder.roomHall(monster, personaje);
       if(hall == true) {
            TimeUnit.SECONDS.sleep(2);
           roomBuilder.roomHallDoor(monster2, personaje);
       }
        
    

    }

}
