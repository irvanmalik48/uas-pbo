package Birds;

public class Matilda extends Birds {
    public Matilda() {
        super("Matilda", "white", 3);
    }

    @Override
    public void power() {
        System.out.println(super.getName() + " meluncur dan mengeluarkan telur berkecepatan tinggi kearah pasukan babi!");
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
