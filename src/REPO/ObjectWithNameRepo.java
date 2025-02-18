package REPO;

import MODEL.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectWithNameRepo {

    private final Map<String, Product> data = new HashMap<>();

    /**
     * Creates a new prodect in the repository.
     *
     * @param prod the prodect to be added
     */
    public void add(Product prod) {
        data.putIfAbsent(prod.getName(), prod);
    }

    /**
     * Updates an prodect in the repository.
     *
     * @param prod the prodect to be updated
     */
    public void update(Product prod) {
        data.replace(prod.getName(), prod);
    }

    /**
     * Removes an prodect from the repository by its name.
     *
     * @param name the name of the prodect to delete.
     */
    public void delete(String name) {
        data.remove(name);
    }

    /**
     * Retrieves an prodect from the repository by its name.
     *
     * @param name the name of the prodect to retrieve.
     * @return the prodect with the specified name, or null if not found.
     */
    public Product get(String name) {
        return data.get(name);
    }

    /**
     * Retrieves all prodects from the repository.
     *
     * @return A list of all prodects in the repository.
     */
    public List<Product> getAll() {
        return data.values().stream().toList();
    }
}
