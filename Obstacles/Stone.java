package Obstacles;

public class Stone extends Obstacles {
    public Stone() {
        super("batu", "grey", 3);
    }

    @Override
    public void setHardness(int hardness) {
        if (hardness > 0)
            super.setHardness(hardness);
        else {
            if (getAmount() > 0) {
                super.setAmount(super.getAmount() - 1);
                super.setHardness(3);
            }
        }
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
