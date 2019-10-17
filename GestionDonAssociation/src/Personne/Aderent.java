package Personne;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

public class Aderent extends Person {



    private String fonction;

    public Aderent(String identifiant,String nom,String adress,String telephone,String prenom,String fonction){
        super(nom,prenom,telephone,adress,identifiant);
        this.fonction = fonction;

    }

    public Aderent() {
        this(null,null,null,null,null,null);
    }

    public static List<Aderent> fileOperation(String filename, ArrayList<Aderent> listAderent) {
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile(filename,list);
        for(int i = 0; i < list.size()/6;i++){
            listAderent.add(new Aderent(list.get(i*6),list.get(1 + i*6),list.get(2 + i*6),list.get(3 + i*6),list.get(4 + i*6),list.get(5 + i*6)));
            System.out.println();
        }
        return listAderent;
    }


    //si jamais l'aderent a oublie son identifient ,ce fonction nous permets de trouver ses information par son nom;
    public Aderent rechercheparNom(List<Aderent> listA,String nom){
        if(listA== null)
            throw new NullPointerException("la list de beneficiaire ne peut pas d'etre vide");
        for(Aderent b : listA){
            if(b.getNom() == nom)
                return b;
        }
        return null;
    }



    @Override
    public String toString(){
        return getIdentifiant() + ";" + getNom() + ";" + getAdress() + ";" + getPrenom() + ";" + getNom() + ";" + fonction;
    }

}
