import java.util.ArrayList; 
import java.util.Scanner;
import java.awt.*;
import org.json.*;
import java.swing.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;


 
public class Admin { 
    private static final String PIN = "1234"; 
    private static ArrayList<Produit> produits = new ArrayList<>(); 
    private static Scanner scanner = new Scanner(System.in); 
 
    public static void main(String[] args) { 
        if (verifierPin()) { 
            menuAdmin(); 
        } else { 
            System.out.println("Accès refusé."); 
      } 
    } 
 
    private static boolean verifierPin() { 
        System.out.print("Entrez le code PIN administrateur : "); 
        String saisie = scanner.nextLine(); 
        return saisie.equals(PIN); 
    } 
 
    private static void menuAdmin() { 
        while (true) { 
            System.out.println("\n=== GESTION DU MAGASIN ==="); 
            System.out.println("1. Ajouter un produit"); 
            System.out.println("2. Supprimer un produit"); 
            System.out.println("3. Modifier un produit"); 
            System.out.println("4. Afficher les produits"); 
            System.out.println("5. Quitter"); 
            System.out.print("Choisissez une option : "); 
             
            int choix = scanner.nextInt(); 
            scanner.nextLine();  
            switch (choix) { 
                case 1: ajouterProduit(); 
                break; 
                case 2: supprimerProduit(); 
                break; 
                case 3: modifierProduit(); 
                break; 
                case 4: afficherProduits(); 
                break; 
                case 5: System.out.println("Déconnexion..."); 
                return; 
                default: System.out.println("Option invalide."); 
            } 
        } 
    } 
 
    private static void ajouterProduit() { 
        System.out.println("Choisissez le type de produit : \n 1. Téléphone \n 2. Ordinateur \n 3. Accessoire"); 
        int type = scanner.nextInt(); 
        scanner.nextLine(); 
         
        System.out.print("Nom du produit : "); 
        String nom = scanner.nextLine(); 
        System.out.print("Prix : "); 
        double prix = scanner.nextDouble(); 
        System.out.print("Stock : "); 
        int stock = scanner.nextInt(); 
        scanner.nextLine(); 
         
        switch (type) { 
            case 1: produits.add(new Telephone(nom, prix, stock)); break; 
            case 2: produits.add(new Ordinateur(nom, prix, stock)); break; 
            case 3: produits.add(new Accessoire(nom, prix, stock)); break; 
            default: System.out.println("Type invalide."); 
        } 
    } 
 
    private static void supprimerProduit() { 
        System.out.print("Nom du produit à supprimer : "); 
        String nom = scanner.nextLine(); 
        produits.removeIf(p -> p.getNom().equalsIgnoreCase(nom)); 
        System.out.println("Produit supprimé."); 
    } 
 
    private static void modifierProduit() { 
        System.out.print("Nom du produit à modifier : "); 
        String nom = scanner.nextLine(); 
        for (Produit p : produits) { 
            if (p.getNom().equalsIgnoreCase(nom)) { 
                System.out.print("Nouveau prix : "); 
                double prix = scanner.nextDouble(); 
                System.out.print("Nouveau stock : "); 
                int stock = scanner.nextInt(); 
                scanner.nextLine(); 
                p.setPrix(prix); 
                p.setStock(stock); 
                System.out.println("Produit mis à jour."); 
                return; 
            } 
        } 
        System.out.println("Produit introuvable."); 
    } 
 
    private static void afficherProduits() { 
        if (produits.isEmpty()) { 
            System.out.println("Aucun produit en stock."); 
        } else { 
            for (Produit p : produits) { 
                p.afficher(); 
            } 
        } 
    } 
}