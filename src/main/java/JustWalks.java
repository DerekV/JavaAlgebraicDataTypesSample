import org.jetbrains.annotations.NotNull;

public enum JustWalks implements TransportModeADT {
    SHOES,BOOTS,SANDLES,BAREFOOT;

    @Override
    public void acceptMatcher(@NotNull Matcher m) {
        m.match(this);
    }


}
