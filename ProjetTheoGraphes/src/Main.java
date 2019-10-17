import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Partie1 partie1 = new Partie1();
        Partie2 partie2 = new Partie2();
        partie1.LireGraphe("src/tt.txt");
        partie2.LireGraphe("src/file.txt");
        System.out.println(partie1.AffichageMatriceAdj());
        System.out.println(partie1.Rang());
        /*
        int [] a = partie2.Plustard();
        int [] b = partie2.Plustot();
        int [] c = partie2.marge();
        for(int i : c){
            System.out.print(i + " ");
        }
         */

        //partie1.LireGraphe("src/file.txt");
        //System.out.println(partie1);

        // System.out.println(partie1.AffichageMatriceAdj());
        //System.out.println(partie1.AffichageMatriceValeur());
        // System.out.println(partie1.DecCircut());
        //System.out.println(partie1.Rang());


    }
}
