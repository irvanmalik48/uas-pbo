package Birds;

public class Red extends Birds {
    public Red() {
        super("Red", "red", 1);
    }

    @Override
    public void power() {
        System.out.println(super.getName() + " marah saat meluncur dan menghancurkan kendaraan babi!");
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}