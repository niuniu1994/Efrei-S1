package Personne;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Beneficiaire extends Person {


    private String date;


    public Beneficiaire(String identifiant, String nom, String adress, String telephone, String prenom, String date){
        super(nom,prenom,telephone,adress,identifiant);
        this.date = date;

    }


    //Lire les fichiers donnés en pièces jointes pour constituer l’ensemble des personnes
    public static List<Beneficiaire> fileOperation(String filename,ArrayList<Beneficiaire> listBenef) {
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile(filename,list);
        SimpleDateFormat sdf =   new SimpleDateFormat( " dd/MM/yyyy");
        for(int i = 0; i < list.size()/6;i++){

            listBenef.add(new Beneficiaire(list.get(i*6),list.get(1 + i*6),list.get(2 + i*6),list.get(3 + i*6),list.get(4 + i*6),list.get(5 + i*6)));
            System.out.println();
        }
        return listBenef;
    }

    public void remove(ArrayList<Beneficiaire> listBenef ) {
    }

    public static Beneficiaire rechercheParTel(ArrayList<Beneficiaire> listBenef,String telephone){
        if(listBenef == null)
            throw new NullPointerException("la list de beneficiaire ne peut pas d'etre vide");
        for(Beneficiaire b : listBenef){
            if(b.getTelephone() == telephone)
                return b;
        }
        return null;
    }

    public static Beneficiaire rechercheParNom(ArrayList<Beneficiaire> listBenef,String nom) {
        if(listBenef == null)
            throw new NullPointerException("la list de beneficiaire ne peut pas d'etre vide");
        for(Beneficiaire b : listBenef){
            if(b.getNom() == nom)
                return b;
        }
        return null;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return getIdentifiant() + ";" + getNom() + ";" + getAdress() + ";" + getPrenom() + ";" + getNom() + ";" ;
    }
}
