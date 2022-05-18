package Obstacles.Interface;

public interface Obstacle {
    public int getHardness();
    public int getAmount();
    public void setHardness(int hardness);
    public void setAmount(int amount);
    public String currentStatus();
}
