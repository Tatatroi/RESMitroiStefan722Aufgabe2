package MODEL;

import java.util.List;

public class Charakter {
    private int id;
    private String name;
    private String herkunftOrt;
    private List<Product> products;

    public Charakter(int id, String name, String herkunftOrt, List<Product> products) {
        this.id = id;
        this.name = name;
        this.herkunftOrt = herkunftOrt;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftOrt() {
        return herkunftOrt;
    }

    public void setHerkunftOrt(String herkunftOrt) {
        this.herkunftOrt = herkunftOrt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", herkunftOrt='" + herkunftOrt + '\'' +
                ", products=" + products +
                '}';
    }
}
