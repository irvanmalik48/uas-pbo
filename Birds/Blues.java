package Birds;

public class Blues extends Birds {
    public Blues() {
        super("The Blues", "blue", 3);
    }

    @Override
    public void power() {
        System.out.println(super.getName() + " berubah menjadi 3 dan menghancurkan kaca-kaca!");
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
