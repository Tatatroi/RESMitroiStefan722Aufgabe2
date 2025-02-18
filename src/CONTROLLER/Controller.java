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
    public void addObjWithName(String name, double price, String region) {
        objectWithNameRepo.add(new Product(name, price, region));
    }

    /**
     * Adds an object to the ... repo.
     */
    public void addObjWithID(String name, String region, List<Product> productList) {
        //new Object(++newObjID, ...);
        objectWithIDRepo.add(new Charakter(++newObjID, name, region, productList));
    }

    /**
     * Updates an object in the .... repo.
     */
    public void updateObjWithName(String name, double price, String region) {
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
    public void deleteObjWithName(String name) {
        objectWithNameRepo.delete(name);
    }

    /**
     * Removes an object from the ... repo
     *
     * @param id the id of the ...
     */
    public void deleteObjWithID(int id) {
        objectWithIDRepo.delete(id);
    }

    /**
     * Retrieves an object from the .... repo by its name.
     *
     * @param name the name of the ....
     * @return the object
     */
    public Object getObjWithName(String name) {
        return objectWithNameRepo.get(name);
    }

    /**
     * Retrieves an object from the ... repo by its id.
     *
     * @param id the id of the ...
     * @return the object
     */
    public Object getObjWithID(int id) {
        return objectWithIDRepo.get(id);
    }

    /**
     * Retrieves all ....
     *
     * @return a list of all ....
     */
    public List<Product> getAllObjWithName() {
        return objectWithNameRepo.getAll();
    }

    /**
     * Retrieves all ...
     *
     * @return a list of all ...
     */
    public List<Charakter> getAllObjWithID() {
        return objectWithIDRepo.getAll();
    }

//    public List<Team> filterByNameTeam(String name) {
//        return getAllTeams().stream().filter(team -> team.getCity().equals(name)).collect(Collectors.toList());
//    }
//
//    public List<Spieler> getPlayersOfTeam(String name){
//        return getAllTeams().stream()
//                .filter(t -> t.getName().equals(name))
//                .findFirst()
//                .map(Team::getPlayers)
//                .orElse(Collections.emptyList());
//    }
//
//    public List<Spieler> sortByValue(int teamId, String sortMode){
//        List<Spieler> players = teamRepo.get(teamId).getPlayers();
//        players.sort((m1,m2)->sortMode.equals("asc") ? Integer.compare(m1.getValue(),m2.getValue()) : Integer.compare(m2.getValue(),m1.getValue()));
//        return players;
//    }

}
