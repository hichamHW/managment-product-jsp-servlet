package models;

public class products {



    private int id_p;
    private String nom_p;
    private  float prix_p;
    private int quantite ;


    private int id_c;
    private String date_delev_p;



    public String getNom_p() {
        return nom_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDate_delev_p() {
        return date_delev_p;
    }

    public void setDate_delev_p(String date_delev_p) {
        this.date_delev_p = date_delev_p;
    }



    public int getId_p() {
        return id_p;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public float getPrix_p() {
        return prix_p;
    }

    public void setPrix_p(float prix_p) {
        this.prix_p = prix_p;
    }
}
