package com.enset;

import java.util.Comparator;

class Employe {
    private int id;
    private String nom;
    private String poste;
    private double salaire;

    public Employe() {
    }

    public Employe(int id, String nom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Poste: " + poste + ", Salaire: " + salaire;
    }

    public static Comparator<Employe> compareParSalaire() {
        return Comparator.comparingDouble(Employe::getSalaire);
    }
}