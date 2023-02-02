package krg.petr.otusjava.currencies;

public enum CorrenciesEnum {
    RUR("RUR"), KZT("KZT" );

    private final String description;

    CorrenciesEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
