import org.jetbrains.annotations.NotNull;

public interface TransportModeADT {

    public void acceptMatcher(Matcher m);

    public interface Matcher {
        public void match(@NotNull PassengerCar e);
        public void match(@NotNull Truck v);
        public void match(@NotNull JustWalks o);
    }

}
