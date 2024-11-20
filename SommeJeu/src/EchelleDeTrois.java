public class EchelleDeTrois extends SommeJeu {

    public EchelleDeTrois() {
        super(0);
    }

    public boolean verifierSuite(int a, int b, int c) {
        if (a != 0 && b != 0 && c != 0) {
            if ((a+1 == b && b == c-1) || (a-1 == b && b == c+1)) { //5 6 7 || 7 6 5
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean verifierGagnant(){
    
        // Vérification des lignes & colonnes pairs 
        for(int i = 0 ; i < 3 ; i++){
            if (grille[i][0] !=0 && grille[i][1] !=0 && grille[i][2] !=0){
                if (verifierSuite(grille[i][0], grille[i][1], grille[i][2])){
                    System.out.println( i + 1 + "ème ligne : " + grille[i][0] + " " + grille[i][1] + " " + grille[i][2] + " se suivent");
                    return true;
                }
            }
            if (grille[0][i] !=0 && grille[1][i] != 0 && grille[2][i] !=0){
                if (verifierSuite(grille[0][i], grille[1][i], grille[2][i])){
                    System.out.println( i + 1  + "ème colonne : "  + grille[0][i] + " " + grille[1][i] + " " + grille[2][i] + " se suivent");
                    return true;
                }
            }
        }


        // Vérification de la première diagonale pair
        if (grille[0][0] !=0 && grille[1][1] != 0 && grille[2][2] !=0){
            if (verifierSuite(grille[0][0], grille[1][1], grille[2][2])){
                System.out.println("Première Diagonale : " + grille[0][0] + " " + grille[1][1] + " " + grille[2][2]  + " se suivent");
                return true;
            }
        }

        // Vérification de la première diagonale impair
        if (grille[0][2] !=0 && grille[1][1] != 0 && grille[2][0] !=0){
            if (verifierSuite(grille[0][2], grille[1][1], grille[2][0])){
                System.out.println("Deuxième Diagonale : " + grille[0][2]  + " " + grille[1][1] + " " + grille[2][0] + " se suivent");
                return true;
            }
        }
        
        return false;
    }


    public void jouer() {

        for (int i = 0; i < 9; i++) {
            nombre[i] = i + 1;
        }

        while (true) {
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
