package Pigs;

public class ArmorPig extends Pigs {
    public ArmorPig() {
        super("babi berarmor", "armorpig", 3);
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
