package com.example.command.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item { 
	
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "uri", nullable = false)
    private String uri;
    @Column(name = "libelle", nullable = false)
    private String libelle;
    @Column(name = "tarif", nullable = false)
    private String tarif;
    @Column(name = "quantite", nullable = false)
    private String quantite;
    @Column(name = "commande_id", nullable = false)
    private String commande_id;

    Item(){
     //pour JPA	
    }

    public Item(String uri, String libelle, String tarif, String quantite, String commande_id) {
        this.uri = uri;
        this.libelle = libelle;
        this.tarif = tarif;
        this.quantite = quantite;
        this.commande_id = commande_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(String commande_id) {
        this.commande_id = commande_id;
    }
        
}
