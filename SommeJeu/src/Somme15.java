public class Somme15 extends SommeJeu {

    public Somme15(){
        super(15);
    }

    @Override
    public void jouer(){

        for(int i = 0 ; i< 9 ; i++){
            nombre[i] = i+1;
        }

        super.jouer();
        
    }
    
}
