package Birds;

import Birds.Interface.Bird;

public abstract class Birds implements Bird {
    private String name, color;
    private int amount, damage;

    public Birds(String name, String color, int damage) {
        this.name = name;
        this.color = color;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAmount() {
        return amount;
    }

    public int getDamage() {
        return damage;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public abstract void power();
    
    public void launch() {
        System.out.println(this.name + " telah meluncur!");
    };
}
