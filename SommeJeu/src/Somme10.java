public class Somme10 extends SommeJeu {

    public Somme10(){
        super(10);
    }

    public void jouer(){

        for(int i = 0 ; i< 9 ; i++){
            nombre[i] = i+1;
        }

        super.jouer();
        
    }
    
}
