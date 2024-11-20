public class Somme3 extends SommeJeu {

    public Somme3(){
        super(3);
    }

    public void jouer(){

        for(int i = 0; i< nombre.length ; i++){
            nombre[i] = (int) Math.pow(-1, i);
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
