package Don.Annexe.PackageSalleEtCusine;

public enum TableShape {
    RECTANGULAIRE("rectangulaire"),CARRE("Caree"),RONDE("Ronde");

    private String s;
    private TableShape(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}