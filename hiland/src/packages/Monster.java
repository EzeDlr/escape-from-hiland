package packages;
import packages.Personaje;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Monster {

        private String name;
        private String description;
        float health = 15f;
        int gold = 100;
        int strength = 3;

        public double normalAttack(Personaje personaje) {
            strength = 1;
            return personaje.health -= strength;
        }

        public double mediumAttack(Personaje personaje) {
            strength = 2;
            return personaje.health -= strength;
        }

        public double hardAttack(Personaje personaje) {
            strength = 3;
            return personaje.health -= strength;
        }

        public double attackProbability(Personaje personaje) {
            int i = new Random().nextInt(16);
            double x = 0;

            if(health == 0) {
                System.out.println("Monster is dead");
                System.out.println();
                personaje.gold += gold;
            }

            if(i <= 5) {
                System.out.println("Monster do a normal attack");
                x = normalAttack(personaje);
            } else if (i <= 10) {
                System.out.println("Monster do a medium attack");
                x = mediumAttack(personaje);
            } else if(i <= 15) {
                System.out.println("Monster do a hard attack");
                x = hardAttack(personaje);
            }

            return x;


            
        }

        public static void main(String[] args) {
            System.out.println("Hola");
        } 
    }
