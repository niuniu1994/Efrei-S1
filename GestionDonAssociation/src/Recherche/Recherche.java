package Recherche;

import Don.*;
import Don.Annexe.Etiqutte;
import Don.Archive.ArchiveEntree;
import Don.Archive.ArchiveSortie;
import Don.Entrepot.DepotVente;
import Don.Entrepot.Destination;

import java.io.*;

public class Recherche {

    public static void RDRefusee() {

        ArchiveSortie archiveSortie = ArchiveSortie.getArchiveSortie();
        File file = new File("src/DonRefusee.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < archiveSortie.getSize(); i++){
                if(archiveSortie.getDon(i).getTraitement() == Traitement.REFUSEE) {
                    System.out.println(archiveSortie.getDon(i));
                    writer.write(archiveSortie.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void RDVendu() {

        ArchiveSortie archiveSortie = ArchiveSortie.getArchiveSortie();
        File file = new File("src/DonVendu.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < archiveSortie.getSize(); i++){
                if(archiveSortie.getDon(i).getEtat() == Etat.VENDU) {
                    System.out.println(archiveSortie.getDon(i));
                    writer.write(archiveSortie.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void RDDonnee() {

        ArchiveSortie archiveSortie = ArchiveSortie.getArchiveSortie();
        File file = new File("src/DonDonne.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < archiveSortie.getSize(); i++){
                if(archiveSortie.getDon(i).getEtat() == Etat.DONNEE) {
                    System.out.println(archiveSortie.getDon(i));
                    writer.write(archiveSortie.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void RDPTraitement(Traitement traitement) {

        ArchiveEntree archiveEntree = ArchiveEntree.getArchiveEntree();
        File file = new File("src/ParTraitement.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < archiveEntree.getSize(); i++){
                if(archiveEntree.getDon(i).getTraitement() == traitement) {
                    System.out.println(archiveEntree.getDon(i));
                    writer.write(archiveEntree.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //a mon avis les deux fonction en dessous sont inutile au niveau de pratique, car tous les dons stocke sont dans
    //Object depotVente ou gardeMeuble,du coup c'est pas la peine de les recherche par entrepot.
    //sauf le cas ou on modifie l'etat de don par soi meme avec la fonction setEtat ou j'ai mal compris la demande.
    public static void RDStockePEntrpot(Destination entrepot){
        File file = new File("src/StockeParEntrpot.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < entrepot.getSize(); i++){
                if(entrepot.getDon(i).getEtat() == Etat.STOCKE) {
                    System.out.println(entrepot.getDon(i));
                    writer.write(entrepot.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void RPDepotVente(DepotVente depotVente){
        ArchiveEntree archiveEntree = ArchiveEntree.getArchiveEntree();
        File file = new File("src/ParDepotVente.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < archiveEntree.getSize(); i++){
                if(depotVente.ContainsDon(archiveEntree.getDon(i))) {
                    System.out.println(archiveEntree.getDon(i));
                    writer.write(archiveEntree.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void RPDEtiquette(Etiqutte typeDeMobilier){
        ArchiveEntree archiveEntree = ArchiveEntree.getArchiveEntree();
        File file = new File("src/ParEtiquette.txt");
        try {
            if(!file.exists())
                file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < archiveEntree.getSize(); i++){
                if(archiveEntree.getDon(i).getTypeMateriel().getEtiquette() == typeDeMobilier) {
                    System.out.println(archiveEntree.getDon(i));
                    writer.write(archiveEntree.getDon(i).toString() + "\r\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
