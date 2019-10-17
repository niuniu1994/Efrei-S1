package Don.Annexe.PackageSalleEtCusine;

public enum TableType {
    SALON("Salon"),CUSINE("Cusine");

    private String s;

    private TableType(String s){
        this.s = s;
    }

    public String toString(){
        return "table : " + s;
    }
}
