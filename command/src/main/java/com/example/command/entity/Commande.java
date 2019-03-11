package com.example.command.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "commande")
public class Commande { 
	
    @Id
    private String ID;
    private String CREATED_AT;
    private String UPDATED_AT; 
    private String LIVRAISON;	
    private String NOM;
    private String MAIL;  	
    private String MONTANT;  	
    private String REMISE;  	
    private String TOKEN;  	
    private String CLIENT_ID;
    private String REF_PAIEMENT;  

    Commande(){
     //pour JPA	
    }

    public Commande(String CREATED_AT, String UPDATED_AT, String LIVRAISON, String NOM, String MAIL, String MONTANT, String REMISE, String TOKEN, String CLIENT_ID, String REF_PAIEMENT) {
        this.CREATED_AT = CREATED_AT;
        this.UPDATED_AT = UPDATED_AT;
        this.LIVRAISON = LIVRAISON;
        this.NOM = NOM;
        this.MAIL = MAIL;
        this.MONTANT = MONTANT;
        this.REMISE = REMISE;
        this.TOKEN = TOKEN;
        this.CLIENT_ID = CLIENT_ID;
        this.REF_PAIEMENT = REF_PAIEMENT;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(String CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public String getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setUPDATED_AT(String UPDATED_AT) {
        this.UPDATED_AT = UPDATED_AT;
    }

    public String getLIVRAISON() {
        return LIVRAISON;
    }

    public void setLIVRAISON(String LIVRAISON) {
        this.LIVRAISON = LIVRAISON;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getMAIL() {
        return MAIL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public String getMONTANT() {
        return MONTANT;
    }

    public void setMONTANT(String MONTANT) {
        this.MONTANT = MONTANT;
    }

    public String getREMISE() {
        return REMISE;
    }

    public void setREMISE(String REMISE) {
        this.REMISE = REMISE;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(String CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public String getREF_PAIEMENT() {
        return REF_PAIEMENT;
    }

    public void setREF_PAIEMENT(String REF_PAIEMENT) {
        this.REF_PAIEMENT = REF_PAIEMENT;
    }

    
    
}
