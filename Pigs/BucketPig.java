package Pigs;

public class BucketPig extends Pigs {
    public BucketPig() {
        super("babi bertopi", "bucketpig", 2);
    }

    @Override
    public String currentStatus() {
        return String.format("\nSisa %s: %d", super.getName(), super.getAmount());
    }
}
