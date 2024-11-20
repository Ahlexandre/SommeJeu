public class BatailleParite extends SommeJeu {

    public BatailleParite() {
        super(0);
    }

    @Override
    public boolean verifierGagnant(){
    
        // Vérification des lignes & colonnes pairs 
        for(int i = 0 ; i < 3 ; i++){
            if (grille[i][0] !=0 && grille[i][1] !=0 && grille[i][2] !=0){
                if (grille[i][0] %2==0 && grille[i][1] %2==0 && grille[i][2] %2==0){
                    System.out.println( i + 1 + "ème ligne : " + grille[i][0] + " " + grille[i][1] + " " + grille[i][2] + " est pair");
                    return true;
                }
            }
            if (grille[0][i] !=0 && grille[1][i] != 0 && grille[2][i] !=0){
                if (grille[0][i] %2==0 && grille[1][i] %2==0 && grille[2][i] %2==0){
                    System.out.println( i + 1  + "ème colonne : "  + grille[0][i] + " " + grille[1][i] + " " + grille[2][i] + " est pair");
                    return true;
                }
            }
        }


        // Vérification des lignes & colonnes impairs 
        for(int i = 0 ; i < 3 ; i++){
            if (grille[i][0] !=0 && grille[i][1] !=0 && grille[i][2] !=0){
                if (grille[i][0] %2!=0 && grille[i][1] %2!=0 && grille[i][2] %2!=0){
                    System.out.println( i + 1 + "ème ligne : " + grille[i][0] + " " + grille[i][1] + " " + grille[i][2] + " est impair");
                    return true;
                }
            }
            if (grille[0][i] !=0 && grille[1][i] != 0 && grille[2][i] !=0){
                if (grille[0][i] %2!=0 && grille[1][i] %2!=0 && grille[2][i] %2!=0){
                    System.out.println( i + 1  + "ème colonne : "  + grille[0][i] + " " + grille[1][i] + " " + grille[2][i] + " est impair");
                    return true;
                }
            }
        }


        // Vérification de la première diagonale pair
        if (grille[0][0] !=0 && grille[1][1] != 0 && grille[2][2] !=0){
            if (grille[0][0] %2==0 && grille[1][1] %2==0 && grille[2][2] %2==0){
                System.out.println("Première Diagonale : " + grille[0][0] + " " + grille[1][1] + " " + grille[2][2]  + " est pair");
                return true;
            }
        }

        // Vérification de la première diagonale impair
        if (grille[0][0] !=0 && grille[1][1] != 0 && grille[2][2] !=0){
            if (grille[0][0] %2!=0 && grille[1][1] %2!=0 && grille[2][2] %2!=0){
                System.out.println("Première Diagonale : " + grille[0][0] + " " + grille[1][1] + " " + grille[2][2] + " est impair");
                return true;
            }
        }

        // Vérification de la deuxième diagonale pair
        if (grille[0][2] !=0 && grille[1][1] != 0 && grille[2][0] !=0){
            if (grille[0][2] %2==0 && grille[1][1] %2==0 && grille[2][0] %2==0){
                System.out.println("Deuxième Diagonale : " + grille[0][2]  + " " + grille[1][1] + " " + grille[2][0] + " est pair");
                return true;
            }
        }

        // Vérification de la deuxième diagonale impair
        if (grille[0][2] !=0 && grille[1][1] != 0 && grille[2][0] !=0){
            if (grille[0][2] %2!=0 && grille[1][1] %2!=0 && grille[2][0] %2!=0){
                System.out.println("Deuxième Diagonale : " + grille[0][2]  + " " + grille[1][1] + " " + grille[2][0] + " est impair");
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
