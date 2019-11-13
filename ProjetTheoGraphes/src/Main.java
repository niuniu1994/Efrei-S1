import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Partie1 p1 = new Partie1();
        Partie2 p2 = new Partie2();
        p2.LireGraphe("src/graphe/g5.txt");
        //System.out.println(p2.AffichageMatriceAdj());
        int[] calTot = p2.Plustot();
        int[] calTard = p2.Plustard();

        for (int i : calTot){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i :calTard){
            System.out.print(i + " ");
        }

    }
}
