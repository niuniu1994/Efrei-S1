package Personne;

public abstract class Person {

    private String nom;
    private String prenom;
    private String telephone;
    private String adress;
    private String identifiant;

    public Person(String nom, String prenom, String telephone, String adress, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adress = adress;
        this.identifiant = identifiant;
    }

    public Person(String nom, String adress, String telephone, String identifiant) {
        this.nom = nom;
        this.telephone = telephone;
        this.adress = adress;
        this.identifiant = identifiant;
    }

    public String getNom(){
        return this.nom;
     };
     public String getIdentifiant(){
         return this.identifiant;
     };
     public String getTelephone(){
         return this.telephone;
     };
     public String getAdress(){
         return this.adress;
     }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom){
         this.nom = nom;
     }
     public void setTelephone(String telephone){
         this.telephone = telephone;
     };

    public void setAdress(String adress) {
       this.adress = adress;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
}
