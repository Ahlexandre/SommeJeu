public class Somme3 extends SommeJeu {

    public Somme3(){
        super(3);
    }

    public void jouer(){

        for(int i = 0; i< nombre.length ; i++){
            nombre[i] = (int) Math.pow(-1, i);
        }

        super.jouer();
        
    }
    
}
