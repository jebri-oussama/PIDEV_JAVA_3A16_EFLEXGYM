package gestion_produit.entities;

public class categorie {
  private  int id;
  private type type;
  private String description;
  private int id_produit;


    public categorie(int id, gestion_produit.entities.type type, String description, int id_produit) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.id_produit = id_produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public gestion_produit.entities.type getType() {
        return type;
    }

    public void setType(gestion_produit.entities.type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    @Override
    public String toString() {
        return "categorie{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", id_produit=" + id_produit +
                '}';
    }
}
