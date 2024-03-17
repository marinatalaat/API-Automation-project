package Enum;
import lombok.Getter;
public enum EndPoints {

    PET("/api/v3/pet");
    @Getter
    private final String value;
    EndPoints(String value) {
        this.value = value;
    }


}
