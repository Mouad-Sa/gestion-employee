package com.enset;

import java.util.Arrays;
import java.util.Scanner;

class GestionEmployes {
    private static final int MAX_EMPLOYES = 50;
    private static Employe[] employes = new Employe[MAX_EMPLOYES];
    private static int compteur = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("\n--- Menu Gestion des Employés ---");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher tous les employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("8. Quitter");
        System.out.print("Choix: ");
    }

    public static void ajouterEmploye() {
        if (compteur >= MAX_EMPLOYES) {
            System.out.println("Le tableau des employés est plein.");
            return;
        }
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Poste: ");
        String poste = scanner.nextLine();
        System.out.print("Salaire: ");
        double salaire = scanner.nextDouble();
        employes[compteur++] = new Employe(id, nom, poste, salaire);
    }

    public static void modifierEmploye(int id) {
        for (int i = 0; i < compteur; i++) {
            if (employes[i].getId() == id) {
                scanner.nextLine();
                System.out.print("Nouveau Nom: ");
                employes[i].setNom(scanner.nextLine());
                System.out.print("Nouveau Poste: ");
                employes[i].setPoste(scanner.nextLine());
                System.out.print("Nouveau Salaire: ");
                employes[i].setSalaire(scanner.nextDouble());
                return;
            }
        }
        System.out.println("Employé introuvable.");
    }

    public static void supprimerEmploye(int id) {
        for (int i = 0; i < compteur; i++) {
            if (employes[i].getId() == id) {
                employes[i] = employes[compteur - 1];
                employes[compteur - 1] = null;
                compteur--;
                return;
            }
        }
        System.out.println("Employé introuvable.");
    }

    public static void afficherEmployes() {
        for (int i = 0; i < compteur; i++) {
            System.out.println(employes[i]);
        }
    }

    public static void rechercherEmploye(String critere) {
        for (int i = 0; i < compteur; i++) {
            if (employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)) {
                System.out.println(employes[i]);
                return;
            }
        }
        System.out.println("Aucun employé trouvé.");
    }

    public static void calculerMasseSalariale() {
        double total = 0;
        for (int i = 0; i < compteur; i++) {
            total += employes[i].getSalaire();
        }
        System.out.println("Masse salariale totale: " + total);
    }

    public static void trierEmployesParSalaire(boolean ordreCroissant) {
        Arrays.sort(employes, 0, compteur, ordreCroissant ? Employe.compareParSalaire() : Employe.compareParSalaire().reversed());
        afficherEmployes();
    }

    public static void main(String[] args) {
        int choix;
        do {
            printMenu();
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    ajouterEmploye();
                    break;
                case 2:
                    System.out.print("ID de l'employé à modifier: ");
                    modifierEmploye(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("ID de l'employé à supprimer: ");
                    supprimerEmploye(scanner.nextInt());
                    break;
                case 4:
                    afficherEmployes();
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Nom ou poste à rechercher: ");
                    rechercherEmploye(scanner.nextLine());
                    break;
                case 6:
                    calculerMasseSalariale();
                    break;
                case 7:
                    System.out.print("Trier par salaire (1: Croissant, 0: Décroissant) : ");
                    trierEmployesParSalaire(scanner.nextInt() == 1);
                    break;
                case 8:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 8);
    }
}
