package REPO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import MODEL.Charakter;

public class ObjectWithIDRepo {

    private final Map<Integer, Charakter> data = new HashMap<>();

    /**
     * Creates a new object in the repository.
     *
     * @param obj the object to be added
     */
    public void add(Charakter obj) {
        data.putIfAbsent(obj.getId(), obj);
    }

    /**
     * Updates an object in the repository.
     *
     * @param obj the object to be updated
     */
    public void update(Charakter obj) {
        data.replace(obj.getId(), obj);
    }
    

    /**
     * Removes an object from the repository by its ID.
     *
     * @param id the unique identifier of the object to delete.
     */
    public void delete(int id) {
        data.remove(id);
    }

    /**
     * Retrieves an object from the repository by its ID.
     *
     * @param id the unique identifier of the object to retrieve.
     * @return the object with the specified ID, or null if not found.
     */
    public Charakter get(int id) {
        return data.get(id);
    }

    /**
     * Retrieves all objects from the repository.
     *
     * @return A list of all objects in the repository.
     */
    public List<Charakter> getAll() {
        return data.values().stream().toList();
    }
}
