package Pigs;

import Pigs.Interface.Pig;

public abstract class Pigs implements Pig {
    private String name, codename;
    private int hitpoints, amount;

    public Pigs(String name, String codename, int hitpoints) {
        this.name = name;
        this.codename = codename;
        this.hitpoints = hitpoints;
    }

    public String getCodename() {
        return codename;
    }

    public String getName() {
        return name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getAmount() {
        return amount;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public abstract String currentStatus();
}
