package Obstacles;

import Obstacles.Interface.Obstacle;

public abstract class Obstacles implements Obstacle {
    private String name, color;
    private int hardness, amount;

    public Obstacles(String name, String color, int hardness) {
        this.name = name;
        this.setColor(color);
        this.hardness = hardness;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHardness() {
        return hardness;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String currentStatus();
}
