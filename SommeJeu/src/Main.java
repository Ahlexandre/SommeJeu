import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez le jeu : 1 pour Somme15, 2 pour Somme10, 3 pour Somme3, 4 pour Bataille de Parité, 5 pour Echelle de Trois");
        int choix = scanner.nextInt();

        SommeJeu jeu = null;

        if (choix == 1){
            jeu = new Somme15();
        }else if (choix == 2){
            jeu = new Somme10();
        }
        else if (choix == 3){
            jeu = new Somme3();
        }
        else if (choix == 4){
            jeu = new BatailleParite();
        }
        else if (choix == 5){
            jeu = new EchelleDeTrois();
        }else{
            System.out.println("Choix invalide");
        }

        jeu.jouer();

        scanner.close();

    }
}
