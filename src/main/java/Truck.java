import org.jetbrains.annotations.NotNull;

public class Truck extends Vehicle implements TransportModeADT {
    private long towCapacity;

    public Truck(@NotNull String name, @NotNull Brand brand, long towCapacity) {
        super(name, brand);
        this.towCapacity = towCapacity;
    }

    public long getTowCapacity() {
        return towCapacity;
    }

    public void setTowCapacity(long towCapacity) {
        this.towCapacity = towCapacity;
    }


    @Override
    public void acceptMatcher(@NotNull Matcher m) {
        m.match(this);
    }
}
