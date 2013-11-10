import org.jetbrains.annotations.NotNull;

public class Vehicle {
    public Vehicle(@NotNull String name, @NotNull Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    private String name;
    private Brand brand;

    @NotNull public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }


    @NotNull public Brand getBrand() {
        return brand;
    }

    public void setBrand(@NotNull Brand brand) {
        this.brand = brand;
    }
}
