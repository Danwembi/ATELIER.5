public abstract class Produit { 
    protected String nom; 
    protected double prix; 
    protected int stock;

    public Produit(String nom, double prix, int stock) { 
        this.nom = nom; 
        this.prix = prix; 
        this.stock = stock; 
    } 
    public abstract void afficher(); 
    public String getNom() { 
        return nom; 
    } 
    public double getPrix() {
         return prix;
    } 
    public int getStock() { 
        return stock; 
    } 
    public void setPrix(double prix) {
        this.prix = prix; 
    } 
    public void setStock(int stock) {
        this.stock = stock; 
    } 
}
