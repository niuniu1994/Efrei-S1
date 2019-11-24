import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Partie1 {

    public class Arc {
        int in, out, valeur;

        public Arc(int in, int out, int valeur) {
            this.in = in;
            this.out = out;
            this.valeur = valeur;
        }
    }

    private int n;//nombre de sommet
    private int m;//nombre de arc
    private int[][] maAdj;
    private String[][] maValeur;
    private ArrayList<Arc> list;
    Boolean j = true;

    public Partie1() {
        this.n = 0;
        this.m = 0;
        this.list = new ArrayList<>();
    }

    public void LireGraphe(String fileName) {
        n = readFile(fileName, list);
        m = list.size();
        maAdj = new int[n][n];
        maValeur = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maValeur[i][j] = "*";
            }
        }
        try {
            RemplirMatrice();
        } catch (Exception e) {
            System.out.println("le numero de sommet doit inferieur de nombre de sommet");
            j = false;
        }
    }

    private int readFile(String filename, ArrayList<Arc> arcs) {

        int n = 0;//nombre de sommet

        if (filename == null) {
            System.out.println("filename is null");
            return -1;
        }

        Scanner scanner;
        File file = new File(filename);
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
            } else
                return -1;
        } catch (FileNotFoundException e) {
            System.out.println("Can not open" + filename);
            return -1;
        }

        int index = 0;

        while (scanner.hasNextLine()) {
            if (index == 0) {
                n = scanner.nextInt();
                index = 1;
            } else {
                arcs.add(new Arc(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
            }
        }
        return n;
    }

    private void RemplirMatrice() throws Exception {
        ArrayList<Integer>[] s = new ArrayList[n];
        for (int i = 0; i < m; i++) {
            maAdj[list.get(i).in][list.get(i).out] = 1;
            maValeur[list.get(i).in][list.get(i).out] = String.valueOf(list.get(i).valeur);
        }
    }

    public String AffichageMatriceAdj() {
        if (j) return AffichageMatriceAdj(maAdj);
        else return "echouer a afficher la Matrice de adjacent";

    }

    private String AffichageMatriceAdj(int[][] maAdj) {

        StringBuilder resA = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        resA.append(" ");
                        continue;
                    }
                    resA.append(" " + (j - 1));
                    if (j == n)
                        resA.append("\n");
                } else if (i != 0 && j == 0) {
                    resA.append(i - 1);
                } else {
                    resA.append(" " + maAdj[i - 1][j - 1]);
                    if (j == n)
                        resA.append("\n");
                }
            }
        }

        return resA.toString();
    }

    public String AffichageMatriceValeur() {
        if (j) return AffichageMatriceValeur(maValeur);
        else return "echouer a afficher la Matrice de Valeur";
    }

    private String AffichageMatriceValeur(String[][] maValeur) {
        StringBuilder resA = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        resA.append(" ");
                        continue;
                    }
                    resA.append(" " + (j - 1));
                    if (j == n)
                        resA.append("\n");
                } else if (i != 0 && j == 0) {
                    resA.append(i - 1);
                } else {
                    resA.append(" " + maValeur[i - 1][j - 1]);
                    if (j == n)
                        resA.append("\n");
                }
            }
        }
        return resA.toString();
    }

    public String Rang() {
        StringBuilder res = new StringBuilder();
        res.append("Calcul des rangs\n");
        res.append("Méthode d’élimination des points d’entrée\n");

        //vu que on a besoin de stocker les sommets er leur demi-degres correspontants
        // (deux dimension et le nombre d'element de la premiere dimension est fix
        // par contre ce qui pour la deuxieme dimension n'est pas sur)
        //je les mets dans map
        HashMap<Integer, ArrayList<Integer>> s = new HashMap<>();
        int d[] = new int[n];
        int k = 0;
        ArrayList<Integer> a = new ArrayList<>();

        //pour gagner demi-degere
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i] += maAdj[j][i];
            }

            //trouver et intialiser la racine
            if (d[i] == 0) {
                a.add(i);
                s.put(0, a);
            }
        }

        while (k < n) {
            ArrayList<Integer> arr = new ArrayList<>();
            res.append("Rang Courant = " + k + "\n");
            res.append("Point d'entree : \n");
            try {
                int somme = 0;
                //si il y un circuit, on rencontre forcement s.get(k) = vide avant k arrive au maximal
                //Donc "for (int sommet : s.get(k))" engendre surment une NullPointerException.
                for (int sommet : s.get(k)) {
                    res.append(sommet + " ");
                    for (int j = 0; j < n; j++) {
                        if (maAdj[sommet][j] == 1) {
                            d[j] -= 1;
                            if (d[j] == 0) {
                                arr.add(j);
                                s.put(k + 1, arr);
                            }
                            somme++;
                        }
                    }

                    // en cas que il y a plus de sommet
                    if (somme == 0) {
                        res.append("\n");
                        res.append("Graphe vide\n");
                        res.append("Rangs calculés : \n");
                        for (int i = 0; i < s.size(); i++) {
                            res.append("Rang" + i + " : ");
                            for (int g : s.get(i))
                                res.append(g + " ");
                            res.append("\n");
                        }
                        return res.toString();
                    }
                }
                res.append("\n");
                k++;
            } catch (NullPointerException e) {
                return  new String("il exist au moin un circut dan le graphe\n");
            }
        }

        return res.toString();
    }

    //par Algorithme de Warshall je trouve la matice de transitive ferme
    //Et je detecte les point sur la diagonale;
    public String DecCircut() {
        StringBuilder res = new StringBuilder();
        int[][] fer = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(maAdj[i], 0, fer[i], 0, n);
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (fer[x][y] == 1)
                    for (int i = 0; i < n; i++) {
                        fer[x][i] = fer[x][i] | fer[y][i];
                    }
            }
        }
        res.append("Detection de circuit\n");
        res.append("Methode1 : Juger par la matrice de transitive ferme\n");
        res.append(AffichageMatriceAdj(fer));

        for (int i = 0; i < n; i++) {
            if (fer[i][i] == 1) {
                res.append("Le graphe contient au mois un circuit\n");
                return res.toString();
            }
        }

        res.append("Le graphe ne contient pas de circuit\n");
        return res.toString();

    }

    public int getN() {
        return n;
    }

    public String[][] getMaValeur() {
        return maValeur;
    }

    public int getM() {
        return m;
    }

    public int[][] getMaAdj() {
        return maAdj;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("nombre sommets : " + n + "\n");
        res.append("nombre arc : " + m + "\n");
        for (Arc arc : list) {
            res.append(arc.in + " " + arc.out + " " + arc.valeur + "\n");
        }
        return res.toString();
    }
}