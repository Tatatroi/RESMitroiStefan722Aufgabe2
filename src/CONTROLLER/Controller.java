package CONTROLLER;



import MODEL.Charakter;
import MODEL.Product;
import REPO.ObjectWithIDRepo;
import REPO.ObjectWithNameRepo;


import java.util.List;

public class Controller {

    private final ObjectWithIDRepo objectWithIDRepo;
    private final ObjectWithNameRepo objectWithNameRepo;
    private int newObjID = 0;

    /**
     * Constructs a new Controller with the given repositories.
     *
     * @param objectWithIDRepo the repository for
     * @param objectWithNameRepo the repository for
     */
    public Controller(ObjectWithIDRepo objectWithIDRepo, ObjectWithNameRepo objectWithNameRepo) {
        this.objectWithIDRepo = objectWithIDRepo;
        this.objectWithNameRepo = objectWithNameRepo;
    }

    /**
     * Adds an object to the .... repo.
     */
    public void addProduct(String name, double price, String region) {
        objectWithNameRepo.add(new Product(name, price, region));
    }

    /**
     * Adds an object to the ... repo.
     */
    public void addCharakter(String name, String region, List<Product> productList) {
        //new Object(++newObjID, ...);
        objectWithIDRepo.add(new Charakter(++newObjID, name, region, productList));
    }

    /**
     * Updates an object in the .... repo.
     */
    public void updateProduct(String name, double price, String region) {
        //new Object(name, ...);
        objectWithNameRepo.update(new Product(name, price, region));
    }

    /**
     * Updates an object in the ... repo.
     */
    public void updateObjWithID(int id, String name, String region, List<Product> productList) {
        //new Object(id, name, ...);
        objectWithIDRepo.update(new Charakter(id,name, region, productList));
    }

    /**
     * Removes an object from the .... repo
     *
     * @param name the name of the ....
     */
    public void deleteProduct(String name) {
        objectWithNameRepo.delete(name);
    }

    /**
     * Removes an object from the ... repo
     *
     * @param id the id of the ...
     */
    public void deleteCharakter(int id) {
        objectWithIDRepo.delete(id);
    }

    /**
     * Retrieves an object from the .... repo by its name.
     *
     * @param name the name of the ....
     * @return the object
     */
    public Product getProduct(String name) {
        return objectWithNameRepo.get(name);
    }

    /**
     * Retrieves an object from the ... repo by its id.
     *
     * @param id the id of the ...
     * @return the object
     */
    public Charakter getCharakter(int id) {
        return objectWithIDRepo.get(id);
    }

    /**
     * Retrieves all ....
     *
     * @return a list of all ....
     */
    public List<Product> getAllProducts() {
        return objectWithNameRepo.getAll();
    }

    /**
     * Retrieves all ...
     *
     * @return a list of all ...
     */
    public List<Charakter> getCharakters() {
        return objectWithIDRepo.getAll();
    }

    /**
     * filter characters by their dorfs
     * @param dorf
     * @return a list of charakters
     */
    public List<Charakter> filterByDorf(String dorf){
        return getCharakters().stream().filter(c -> c.getHerkunftOrt().equals(dorf)).toList();
    }

    public List<Charakter> filterProducts(String region){
        return getCharakters().stream().filter(c -> c.getProducts().stream().findFirst().get().getRegion().equals(region)).toList();
    }




}
