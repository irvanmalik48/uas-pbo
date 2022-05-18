package Obstacles;

public class Glass extends Obstacles {
    public Glass() {
        super("kaca", "blue", 1);
    }

    @Override
    public void setAmount(int amount) {
        if (amount >= 0)
            super.setAmount(amount);
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
