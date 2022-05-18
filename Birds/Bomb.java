package Birds;

public class Bomb extends Birds {
    public Bomb() {
        super("Bomb", "black", 4);
    }

    @Override
    public void power() {
        System.out.println(super.getName() + " meluncur dan meledakkan diri di markas babi!");
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
