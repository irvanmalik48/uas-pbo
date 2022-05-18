package Birds;

public class Chuck extends Birds {
    public Chuck() {
        super("Chuck", "yellow", 2);
    }

    @Override
    public void power() {
        System.out.println(super.getName() + " meluncur dengan kecepatan tinggi ke arah pasukan babi!");
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
