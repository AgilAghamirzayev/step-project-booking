package models;

public enum Airline {
    AZAL("AZ"),
    AIR_SEUL("AS"),
    INTERJET("IJ"),
    JET_STAR("JS"),
    LACOMPAGINE("B7"),
    DELTA("DL"),
    OMAN_AIR("OA"),
    MANGO("MG"),
    KOREAN_AIR("KA"),
    TURKISH_AIRLINES("TA"),
    WESTJET("WJ"),
    XIAMEN_AIRLINES("XA"),
    PEGASUS_AIRLINES("PA");

    private final String code;


    Airline(String code) {
        this.code=code;
    }

    public String getCode(){
        return code;
    }
}
