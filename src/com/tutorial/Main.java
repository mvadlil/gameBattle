package com.tutorial;

// player
class Player {
    String name;
    double health;
    int level;

    // object member
    Weapon weapon;
    Armor armor;

    // constructor
    Player(String name, double health) {
        this.name = name;
        this.health = health;
    }

    // method equip weapon
    void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // method equip armor
    void equipArmor(Armor armor) {
        this.armor = armor;
    }

    // method attack player
    void attack(Player opponent) {
        double attackPower = this.weapon.attackPower;
        System.out.println("\n===BATTLE START===\n");
        System.out.println(this.name + " attacking " + opponent.name + " with power " + attackPower);
        opponent.defence(attackPower);
        System.out.println("\n====END BATTLE====\n");
    }

    void defence(double attackPower) {
        // akan mengambil damage
        double damage;
        if (this.armor.defencePower < attackPower) {
            damage = attackPower - this.armor.defencePower;
        } else {
            damage = 0;
        }
        System.out.println(this.name + " gets damage " + damage);
        double decreaseHealth = this.health - damage;
        this.health -= damage;
        System.out.println(this.name + " health decrease to " + decreaseHealth);
        this.displayDefence();
    }

    void displayDefence() {
        System.out.println("===================================");
        System.out.println("Name   : " + this.name);
        System.out.println("Health : " + this.health);
        this.weapon.display();
        this.armor.display();
        System.out.println("===================================");
    }

    void display() {
        System.out.println("===========PLAYER STATUS===========");
        System.out.println("===================================");
        System.out.println("Name   : " + this.name);
        System.out.println("Health : " + this.health);
        this.weapon.display();
        this.armor.display();
        System.out.println("===================================");
    }

}

// Weapon
class Weapon {
    double attackPower;
    String name;

    // constructor
    Weapon(String name, double attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    void display() {
        System.out.println("Weapon : " + this.name + ", Power : " + attackPower);
    }
}

// Armor
class Armor {
    String name;
    double defencePower;

    // constructor
    Armor(String name, double defencePower) {
        this.name = name;
        this.defencePower = defencePower;
    }

    void display() {
        System.out.println("Armor  : " + this.name + ", Defence : " + defencePower);
    }

}

class Battle {

    Battle(Player player1, Player player2) {

    }
}

public class Main {
    public static void main(String[] args) {
        // built a new object player
        Player player1 = new Player("fadlil", 100.00);
        Player player2 = new Player("pipit", 100.00);

        // built new weapon
        Weapon sword = new Weapon("sword", 15.00);
        Weapon palu = new Weapon("palu", 25.00);

        // build new armor
        Armor steelArmor = new Armor("Steel Armor", 10.00);
        Armor queenArmor = new Armor("Queen Armor", 15.00);

        // Player 1
        player1.equipWeapon(sword);
        player1.equipArmor(steelArmor);
        player1.display();

        // Player 2
        player2.equipWeapon(palu);
        player2.equipArmor(queenArmor);
        player2.display();

        // BATTLE
        player1.attack(player2);
        player2.attack(player1);
    }
}