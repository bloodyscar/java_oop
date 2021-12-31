/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latihan;

class Player{
    private String name;
    private int baseHealth;
    private int baseAttack;
    private int totalDamage;
    Weapon weapon;
    Armor armor;

    public Player(String name, int baseHealth, int baseAttack) {
        this.name = name;
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
    }
    
    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    
    public void equipArmor(Armor armor){
        this.armor = armor;
    }
    
    public int totalAttack(){
        return this.baseAttack = this.baseAttack + this.weapon.getAttack();
    }
    
    public int totalHP(){
        return this.baseHealth += this.armor.totalArmorHP();
    }
    
    void display(){
        System.err.println("Name \t\t= " + this.name);
        System.err.println("Max HP \t\t= " + this.totalHP()+ "/" + this.baseHealth);
        System.err.println("Weapon \t\t= " + this.weapon.getWeapon() + "\n====================================");
    }
    
    public void attackingPlayer(Player enemy){
        System.err.println(this.name + " attacking " + enemy.name + " with " + this.weapon.getWeapon());
        enemy.receiveAttack(this.totalAttack());
        
    }
    
    public void receiveAttack(int attack){
        int deltaDamage;
        if ( attack > this.armor.getDeff()){
            deltaDamage =  attack - this.armor.getDeff();
        } else {
            deltaDamage = 0;
        }
        
        
        System.out.println(this.name + " receiving " + attack + " damage");
    }
    
    
}

class Weapon{
    private String nameWeapon;
    private int attackPower;

    public Weapon(String name, int attack){
        this.nameWeapon = name;
        this.attackPower = attack;
    }
    
    public String getWeapon(){
        return this.nameWeapon;
    }
    
    public int getAttack(){
        return this.attackPower;
    }
}

class Armor{
    private String name;
    private int strength;
    private int addHealthPoint;
    private int deff;
    
    public Armor(String name, int strength, int hp, int deff){
        this.name = name;
        this.strength = strength;
        this.addHealthPoint = hp;
        this.deff = deff;
    }
    
    public String getArmor(){
        return this.name;
    }
    
    public int getDeff(){
        return this.deff;
    }
    
    public int totalArmorHP(){
        return this.strength + this.addHealthPoint;
    }
    
}

public class Main {
    public static void main(String[] args){
        // create object player
        Player player1 = new Player("Thor", 100, 50);
        Player player2 = new Player("Kratos", 100, 10);
        
        // create object weapon
        Weapon hammer = new Weapon("God Hammer", 30);
        Weapon leviathan = new Weapon("Leviathan Axe", 0);
        
        // create object armor
        Armor cuirras = new Armor("Cuirras Armor", 10, 10, 10);
        Armor golden = new Armor("Golden Armor", 25, 25, 50);
        
        // equip weapon
        player1.equipWeapon(hammer);
        player2.equipWeapon(leviathan);
        
        // equip armor
        player1.equipArmor(cuirras);
        player2.equipArmor(golden);
        
        
//        player1.attackingPlayer(player2);
          player2.attackingPlayer(player1);
          player1.display();
        
    }
}
