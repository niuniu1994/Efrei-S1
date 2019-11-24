import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Partie1 p1 = new Partie1();
        Partie2 p2 = new Partie2();
        p1.LireGraphe("src/graphe/g5.txt");
        //System.out.println(p2.AffichageMatriceAdj());
        /*
        int[] calTot = p2.Plustot();
        int[] calTard = p2.Plustard();
        int[] marge = p2.margeTotal();
        int[] margelibre = p2.margeLibre();
        for (int i : calTot){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i :calTard){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: marge){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: margelibre){
            System.out.print(i + " ");
        }

         */

      System.out.println(  p1.Rang());
    }
}
