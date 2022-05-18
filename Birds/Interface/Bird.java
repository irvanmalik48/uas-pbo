package Birds.Interface;

public interface Bird {
    public int getDamage();
    public int getAmount();
    public void setDamage(int damage);
    public void setAmount(int amount);
    public void launch();
    public String currentStatus();
    public void power();
}
