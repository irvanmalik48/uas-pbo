package Pigs;

public class NormalPig extends Pigs {
    public NormalPig() {
        super("babi biasa", "pig", 1);
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
