package Don;

public enum  Traitement {
    ACCPTE("Accept"),REFUSEE("Refuse");

    private String s;
    private Traitement(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
