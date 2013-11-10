import org.jetbrains.annotations.NotNull;

public class PassengerCar extends Vehicle implements TransportModeADT {
    private int capacity;

    public PassengerCar(@NotNull String name, @NotNull Brand brand, int capacity) {
        super(name, brand);
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public void acceptMatcher(Matcher m) {
        m.match(this);
    }
}
