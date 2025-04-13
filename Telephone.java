public class Telephone extends Produit { 
    public Telephone(String nom, double prix, int stock) { 
        super(nom, prix, stock); 
    } 
 
    public void afficher() { 
        System.out.println("Téléphone: " + nom + " - Prix: " + prix + "$ - Stock: " + stock); 
    } 
}