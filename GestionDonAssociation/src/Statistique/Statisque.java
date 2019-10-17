package Statistique;

import Don.*;
import Don.Entrepot.DepotVente;
import Personne.Beneficiaire;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Statisque {

    public static long tempsEntreRR(Don don){
        long day= 0;

        try {
            SimpleDateFormat sdf =   new SimpleDateFormat( "dd/MM/yyyy" ); if(don.getDateDedeReception().equals(null)){
                System.out.println("ce don n'exist pas");
                return -1;
            }

            String dateDeReception = don.getDateDedeReception();
            Date dateRece = sdf.parse(dateDeReception);

            if(don.getDateDeRetrait().equals(null)){
                System.out.println("le don n'est pas vendu ou donnee");
                return -1;
            }

            String dateDeRetait = don.getDateDeRetrait();
            Date dateRetait = sdf.parse(dateDeRetait);

            day = (dateRetait.getTime() - dateRece.getTime())/(24*60*60*1000);
            return day;
        }catch (ParseException e){
            System.out.println("date doit entree sous forme dd/mm/yyyy");
        }

        return -1;
    }

    public static long prixMoyenneDespotVentes(List<DepotVente> listDV){
        int sum  = 0;
        int quantite = 0;
        for(DepotVente d : listDV){
            quantite +=  d.getSize();
            sum += (1000 - d.getMontant());
        }

      return sum / quantite ;
    }

    public static long moyenneAgeBeneficiaires(List<Beneficiaire> listB) {
        long sum = 0;

        for (Beneficiaire b : listB) {
            long year = 0;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                String dateDeNai = b.getDate();
                Date dateDeNaissance = sdf.parse(dateDeNai);

                Date date = new Date();
                String dateAujourdhui = sdf.format(date);
                Date dateDeAujourdhui = sdf.parse(dateAujourdhui);

                year = (dateDeAujourdhui.getTime() - dateDeNaissance.getTime()) / (24 * 60 * 60 * 1000 );
                year = year / 365;
                sum += year;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return sum/listB.size();
    }
}
