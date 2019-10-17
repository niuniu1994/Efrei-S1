package Personne;

public class PersonesMorales extends Person {

    private String typeAct;

    public PersonesMorales(String identifiant, String nom, String adress, String telephone, String typeAct) {
        super(nom,adress,telephone,identifiant);
        this.typeAct = typeAct;
    }


    public String getTypeAct() {
        return typeAct;
    }

    public void setTypeAct(String typeAct) {
        this.typeAct = typeAct;
    }
}
