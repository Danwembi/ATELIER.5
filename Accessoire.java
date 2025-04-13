public class Accessoire extends Produit { 
    public Accessoire(String nom, double prix, int stock) { 
        super(nom, prix, stock); 
    } 
 
    public void afficher() { 
        System.out.println("Accessoire: " + nom + " - Prix: " + prix + "$ - Stock: " + stock); 
    } 
}
