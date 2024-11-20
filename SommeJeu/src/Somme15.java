public class Somme15 extends SommeJeu {

    public Somme15(){
        super(15);
    }

    public void jouer(){
        
        for(int i = 0 ; i< 9 ; i++){
            nombre[i] = i+1;
        }

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
