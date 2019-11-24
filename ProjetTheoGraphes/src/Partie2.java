import java.util.*;

public class Partie2 {
    private Partie1 p;
    int[][] matAdj;
    String[][] matVal;
    int n;
    private Map<Integer, LinkedList<Integer>> adj;
    private Map<Integer, Integer> val;// je remplace LinkedList<Integer> a Integer parce que pour un sommet dans graphe d'ordonnacemant tout ses valeu sont identique;

    public Partie2() {
        p = new Partie1();
    }

    public void LireGraphe(String fileName) {
        p.LireGraphe(fileName);
        n = p.getN();
        this.matAdj = p.getMaAdj();
        this.matVal = p.getMaValeur();
    }

    public String AffichageMatriceAdj() {
        return p.AffichageMatriceAdj();
    }

    public String AffichageMatriceValeur() {
        return p.AffichageMatriceValeur();
    }

    // on transformer la matrice d'adjacence et valeur vers la list d'adjacence et valeur
    private void MatriceVersList() {
        adj = new TreeMap<>();
        val = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> arr1 = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (matAdj[i][j] == 1) {
                    arr1.add(j);
                    adj.put(i, arr1);
                    val.put(i, Integer.valueOf(matVal[i][j]));
                }
            }
        }
    }

    //ensemble des verifi
    private boolean Verification() {
        if (VerificatonES()) {
            if (DecCircuit()) {
                if (VerifValeurIdentiqueEtNonNegatif()) {
                    if (VerifiValeurEntreeNulle()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //- un seul point d’entrée,
    //- un seul point de sortie
    private boolean VerificatonES() {
        int sommeE = 0;
        int sommeS = 0;

        for (int i = 0; i < p.getN(); i++) {
            int entree = 0;
            int sortie = 0;
            for (int j = 0; j < p.getN(); j++) {
                if (p.getMaAdj()[i][j] == 1) sortie++;
                if (p.getMaAdj()[j][i] == 1) entree++;
            }
            if (entree == 0) sommeE++;
            if (sortie == 0) sommeS++;
        }

        if (sommeE == 1 && sommeS == 1) {
            return true;
        }
        return false;
    }

    //pas de circuit
    private boolean DecCircuit() {
        int[][] fer = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matAdj[i], 0, fer[i], 0, n);
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (fer[x][y] == 1)
                    for (int i = 0; i < n; i++) {
                        fer[x][i] = fer[x][i] | fer[y][i];
                    }
            }
        }

        for (int i = 0; i < n; i++) {
            if (fer[i][i] == 1) {
                return false;
            }
        }
        return true;
    }

    //- valeurs identiques pour tous les arcs incidents vers l’extérieur à un sommet,
    //- pas d’arcs à valeur négative.
    private boolean VerifValeurIdentiqueEtNonNegatif() {
        int n = p.getN();
        String[][] mat = p.getMaValeur();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != "*") {
                    if (Integer.valueOf(mat[i][j]) < 0)
                        return false;
                    set.add(Integer.valueOf(mat[i][j]));
                }
            }
            if (set.size() > 1) return false;
        }
        return true;
    }

    //- arcs incidents vers l’extérieur au point d’entrée de valeur nulle,
    private boolean VerifiValeurEntreeNulle() {
        int n = p.getN();
        String[][] mat = p.getMaValeur();
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (mat[j][i] == "*") temp++;
            }
            if (temp == n) {
                for (int k = 0; k < n; k++) {
                    if (mat[i][k] != "*") {
                        if (Integer.valueOf(mat[i][k]) == 0)
                            return true;
                        else return false;
                    }
                }
            }
        }
        return false;
    }

    //tri topologique prof a presente dans ppt
    public Stack<Integer> TopologiqueDfs() {
        MatriceVersList();
        Stack<Integer> stack = new Stack<>();
        int n = p.getN();
        Boolean[] dv = new Boolean[n];// marque deja vu
        for (int i = 0; i < n; i++) {
            dv[i] = false;
        }

        for (int i = 0; i < n; i++) {
            if (dv[i] == false) {
                Visite(i, dv, stack);
            }
        }

        return stack;
    }

    //le methode qu'on va utiliser pour le tri topologique
    private void Visite(int i, Boolean[] dv, Stack stack) {

        dv[i] = true;
        Integer k;
        if (adj.containsKey(i)) {
            Iterator<Integer> it = adj.get(i).iterator();

            while (it.hasNext()) {
                k = it.next();
                if (!dv[k]) {
                    Visite(k, dv, stack);
                }
            }
        }
        stack.push(i);
    }

    //les date plustots
    public int[] Plustot() {
        if (Verification()) {
            int[] dist = new int[n];
            Stack<Integer> stack = TopologiqueDfs();
            for (int i = 0; i < n; i++) {
                dist[i] = Integer.MIN_VALUE;
            }

            dist[stack.peek()] = 0;

            while (!stack.isEmpty()) {
                int k = stack.pop();

                if (adj.containsKey(k)) {
                    Iterator<Integer> it = adj.get(k).iterator();
                    if (dist[k] != Integer.MIN_VALUE) {
                        while (it.hasNext()) {
                            int next = it.next();
                            if (dist[next] < dist[k] + val.get(k)) {
                                dist[next] = dist[k] + val.get(k);
                            }
                        }
                    }
                }

            }
            return dist;
        }
        return null;
    }

    //les date plustards
    public int[] Plustard() {
        int[] dist = Plustot();
        Stack<Integer> stack = reverseStack(TopologiqueDfs());

        while (!stack.isEmpty()) {
            int k = stack.pop();

            if (adj.containsKey(k)) {
                Iterator<Integer> it = adj.get(k).iterator();
                boolean x = false;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                while (it.hasNext()) {
                    int next = it.next();
                    if (dist[k] <= dist[next] - val.get(k)) {
                        pq.add(dist[next] - val.get(k));
                        x = true;
                    }
                }
                if (x) {
                    dist[k] = pq.poll();
                }
            }
        }
        return dist;

    }

    //les marges
    public int[] margeTotal() {
        int[] marge = new int[n];
        int[] plustot = Plustot();
        int[] plustard = Plustard();
        for (int i = 0; i < n; i++) {
            marge[i] = plustard[i] - plustot[i];
        }
        return marge;
    }

    public int[] margeLibre() {
        int[] dist = Plustot();
        Stack<Integer> stack = TopologiqueDfs();

        while (!stack.isEmpty()) {
            int k = stack.pop();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            if (adj.containsKey(k)) {
                Iterator<Integer> it = adj.get(k).iterator();
                while (it.hasNext()) {
                    int next = it.next();
                    pq.add(dist[next]);
                }
                dist[k] = pq.poll() - dist[k] - val.get(k);
            }else
                dist[k] = 0;//vu que sommet n'a pas de succsseur (le dernier sommet)
            //selon moi,il y a pas de tâches postérieur a faire donc son marge libre est toujours 0.
        }
        return dist;
    }

    private Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        return stack1;
    }
}