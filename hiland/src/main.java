import java.util.Scanner;

public class main {

    /*
    * - Guerrero (mucha vida)
    * - Mago (vida media)
    * - Espadachin (poca vida )
    *
    * - Attack1 = soft      0,1
    * - Attack2 = medium    0,3
    * - Attack3  = hard   0,5
    *
    * El daño que hara el monstro deberia de depende de que tipo de monstruo fuese.
       * La vida de los monstruos no sera mayor que 30*/

    static class Menu {

    }


    static class Personaje {
        Scanner teclado = new Scanner(System.in);
        private String name = "You";
        private String description = "A brave warrior!";

        private double health = 100;
        private float strength = 15;
        private int mana = 60;
        private int healthPotionQuantity;
        private int manaPotionQuantity;




        public boolean Attack(Monster monster){
            System.out.print("Type attack(1,2,3)");
            int typeAttack = teclado.nextInt();

            if(typeAttack == 1) {
                strength = 1;
                monster.health = monster.health - strength;
                this.mana = mana - 2;

            } else if(typeAttack == 2) {
                strength = 2;
                monster.health = monster.health - strength;
                this.mana = mana - 2;
            } else if(typeAttack == 3) {
                strength = 3;
                monster.health = monster.health - strength;
                this.mana = mana - 2;
            } if(monster.health == 0) {
                System.out.println("Monster is dead");
            }
            else {
                return false;
            }

            return true;
        }

        public void WinCoins() {

        }

        public boolean PotionUsage() {
            System.out.println("Potions of health: ["+healthPotionQuantity+"]");
            System.out.println("Potions of mana: ["+manaPotionQuantity+"]");
            System.out.print("Select a potion [health/mana]: ");
            String potion = teclado.next();
            if(potion.equalsIgnoreCase("health")) {
                if(healthPotionQuantity > 0) {
                    healthPotionQuantity -= 1;
                    int healthPotion = 50;
                    health = health + healthPotion;
                }
                else if(healthPotionQuantity <= 0) {
                    healthPotionQuantity = 0;
                    System.out.print("\n"+"No 'health' potions!"+"\n");
                }

            }  if(potion.equalsIgnoreCase("mana")){
                if(manaPotionQuantity > 0) {
                    manaPotionQuantity -= 1;
                    int manaPotion = 15;
                    mana = mana + manaPotion;
                }
                if(manaPotionQuantity <= 0) {
                    manaPotionQuantity = 0;
                    System.out.print("\n"+"No 'mana' potions!"+"\n");
                }
            } else {
                return false;
            }
            return true;
        }

        public String toString() {
            System.out.println();
            System.out.println("-------------------INFO-------------------");
            return "Health: "+this.health + "\n" + "Strenght: "+this.strength + "\n" + "Mana: "+this.mana + "\n" +
                    "Health potion quantity: "+this.healthPotionQuantity + "\n" + "Mana potion quantity: "+this.manaPotionQuantity + "\n";
        }
    }

    static class Monster {
        private String name;
        private String description;
        private float health = 15f;
        private int gold = 100;

        public void Attack(Personaje personaje) {
            int strength = 1;
            personaje.health = personaje.health - strength;
    }

        public float getAlive() {
            System.out.println(this.health);
            return this.health;
        }


    }

    public static void main(String[] args) {

        //Objeto personaje
        Personaje personaje = new Personaje();

        //Objeto monstruo
        Monster monster = new Monster();


        //Vidas
        System.out.println(monster.health);
        System.out.println(personaje.health);

        //Ataques
            //Personaje ataca monstruo

        personaje.Attack(monster);
        monster.getAlive();

        /*do {
            personaje.Attack(monster);
            monster.Attack(personaje);
            System.out.println(personaje.health);
            System.out.println(monster.health);
        } while(monster.health > 0);*/

    }

}
