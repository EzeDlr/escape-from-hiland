package packages;
import java.util.Scanner;

public class Personaje {
    
    Scanner teclado = new Scanner(System.in);
    
        private String name = "You";
        private String description = "A brave warrior!";
        public Object position;
        protected int gold = 0;


        protected double health = 100;
        private float strength = 15;
        private int mana = 60;
        private int healthPotionQuantity;
        private int manaPotionQuantity;    

        
        public void Attack(Monster monster) {
            
            //Attack 3 >  3 - (30M)
            double wasteAttack3 = 3.2;
            double wasteAttack2 = 2.7;
            double wasteAttack1= 2;

            System.out.println();
            System.out.println("Health remaining: "+health);
            System.out.println("Remaining mana: "+mana);
            System.out.println();
            System.out.println("1 - Soft attack > ("+(mana-wasteAttack1)+") remaining mana");
            System.out.println("2 - Medium attack > ("+(mana-wasteAttack2)+") remaining mana");
            System.out.println("3 - Hard attack > ("+(mana-wasteAttack3)+") remaining mana"+"\n");
            
            System.out.println("Monster health reamining: "+monster.health);
            System.out.print("Select an attack: ");
            int typeAttack = teclado.nextInt();
            int damage = 0;

            if(typeAttack == 1) {
                damage = 1;
                monster.health -= damage;
                mana -= wasteAttack1;
            } else if(typeAttack == 2) {
                damage = 2;
                monster.health = monster.health - damage;
                mana -= wasteAttack2;
            } else if(typeAttack == 3) {
                damage = 3;
                monster.health = monster.health - damage;
                mana -= wasteAttack3;
            } 

            if(mana == 0) {
                System.out.println("No mana remaining");
            }

            if(health == 0) {
                System.out.println("You dead");
                gold = 0;
            }
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

        public static void main(String[] args) {
            Personaje personaje = new Personaje();
            System.out.println(personaje);
        }
    }

    


    

    

