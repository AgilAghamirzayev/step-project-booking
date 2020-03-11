package models;

public enum  Airport {

    ALYASKA("PA"),
    HAWAII("PH"),
    BAKU("HEIA"),
    ITALY("TAR"),
    MEXICO("TAM"),
    ESTONIA("EETU"),
    COLOMBIA("TBC"),
    ARIZONA("TBC"),
    RUSSIA("UUOT"),
    SPAIN("TCI"),
    INDIA("VOTK"),
    CHINA("ZUTC"),
    BRAZIL("SBTL"),
    LONDON("LAL"),
    BARCELONA("BAR"),
    KIEV("KV");
    private final String code;

    Airport(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
