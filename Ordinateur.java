public class Ordinateur extends Produit { 
    public Ordinateur(String nom, double prix, int stock) { 
        super(nom, prix, stock); 
    } 
 
    public void afficher() { 
        System.out.println("Ordinateur: " + nom + " - Prix: " + prix + "$ - Stock: " + stock); 
    } 
}
