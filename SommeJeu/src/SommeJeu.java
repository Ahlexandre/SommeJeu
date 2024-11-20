import java.util.Random;

public abstract class SommeJeu {

    protected int[][] grille = new int[3][3];
    protected int[] nombre = new int[9];
    protected int somme;
    int joueurActuel = 1;

    public SommeJeu(int somme){
        this.somme = somme;
    }

    public void afficherGrille(){
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean verifierGagnant(){
    
        // Vérification des lignes
        for(int i = 0 ; i < 3 ; i++){
            if (grille[i][0] !=0 && grille[i][1] != 0 && grille[i][2] !=0){
                if (grille[i][0] + grille[i][1] + grille[i][2] == somme){
                    System.out.println( i + 1 + "ème ligne : " + grille[i][0] + " " + grille[i][1] + " " + grille[i][2] + " = " + somme);
                    return true;
                }
            }
        }
        // Vérification des colonnes
        for(int i = 0 ; i < 3 ; i++){
            if (grille[0][i] !=0 && grille[1][i] != 0 && grille[2][i] !=0){
                if (grille[0][i] + grille[1][i] + grille[2][i] == somme){
                    System.out.println(i +1 + "ème colonne : "  + grille[0][i] + " " + grille[1][i] + " " + grille[2][i] + " = " + somme);
                    return true;
                }
            }
        }


        // Vérification de la première diagonale
        if (grille[0][0] !=0 && grille[1][1] != 0 && grille[2][2] !=0){
            if (grille[0][0] + grille[1][1] + grille[2][2] == somme){
                System.out.println("Première Diagonale : " + grille[0][0] + " " + grille[1][1] + " " + grille[2][2] + " = " + somme);
                return true;
            }
        }

        // Vérification de la deuxième diagonale
        if (grille[0][2] !=0 && grille[1][1] != 0 && grille[2][0] !=0){
            if (grille[0][2] + grille[1][1] + grille[2][0] == somme){
                System.out.println("Deuxième Diagonale : " + grille[0][2]  + " " + grille[1][1] + " " + grille[2][0] + " = " + somme);
                return true;
            }
        }

        return false;
    }

    public boolean estRemplieGrille(){
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                if(grille[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void placerRandomNumber(){
        Random rand = new Random();

        int randomIndex = rand.nextInt(9);
        while(nombre[randomIndex] == 0){
            randomIndex = rand.nextInt(9);
        }

        int number = nombre[randomIndex];
        int ligne;
        int colonne;

        do{
            ligne = rand.nextInt(3);
            colonne = rand.nextInt(3);
        }while(grille[ligne][colonne] != 0);
        
        grille[ligne][colonne] = number;
        System.out.println("Nombre utilisé: " + number);
        nombre[randomIndex] = 0;
    }

    public void changementJoueur(){
        if(joueurActuel == 1){
            joueurActuel = 2;
        }else{
            joueurActuel = 1;
        }
    }

    public void jouer(){
        while(true){
            afficherGrille();
            System.out.println("Joueur " + joueurActuel + " place un nombre");

            placerRandomNumber();
            afficherGrille();
            System.out.println(" ");

            if (verifierGagnant()) {
                afficherGrille();
                System.out.println("Joueur " + joueurActuel + " a gagné !");
                break;
            }

            changementJoueur();

            if (estRemplieGrille()) {
                afficherGrille();
                System.out.println("Match nul");
                break;
            }
        }
    }
}