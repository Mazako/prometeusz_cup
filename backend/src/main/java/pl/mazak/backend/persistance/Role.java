package pl.mazak.backend.persistance;

public enum Role {
    TOP(1), JUNGLE(2), MID(3), ADC(4), SUPPORT(5);
    private int ordinal;

    Role(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }
}
