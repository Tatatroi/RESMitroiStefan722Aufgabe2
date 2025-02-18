package UI;

import CONTROLLER.Controller;
import MODEL.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {

    private final Controller controller;
    private final Scanner scanner = new Scanner(System.in);

    public Ui(Controller controller) {
        this.controller = controller;
    }

    /**
     * Function that starts the user interface of the application.
     * and handles all the user input.
     */
    public void run() {
        while (true) {
            System.out.println("1. Product Operations");
            System.out.println("2. Charakter Operations");
            System.out.println("3. First filter");
            System.out.println("4. Second filter");
            System.out.println("5. Third filter");
            System.out.println("0. Exit");

            int option = Integer.parseInt(scanner.nextLine());

            try {
                switch (option) {
                    case 1:
                        //manage first object a)
                        manageFirstObject();
                        break;
                    case 2:
                        // manage second object b)
                        manageSecondObject();
                        break;
                    case 3:
                        // subpunctu c)
                        System.out.println("Enter the name of the dorf to filter:");
                        String name = scanner.nextLine();
                        controller.filterByDorf(name).forEach(System.out::println);
                        break;
                    case 4:
                        // subpunctu d)
                        System.out.println("Enter the name of the region to filter:");
                        String region = scanner.nextLine();
                        controller.filterProducts(region).forEach(System.out::println);
                        break;
                    case 5:
                        // subpunctu e)
                        System.out.println("Enter the id of the charakter tp sort the products: ");
                        int id1 = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter the sortModus(asc/desc)");
                        String sortModus = scanner.nextLine();
                        controller.sortProducts(id1,sortModus).forEach(System.out::println);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option, try again");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option");
            }
        }
    }

    private void manageFirstObject() {
        while (true) {
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. Get All products");
            System.out.println("5. Get by name product");
            System.out.println("0. Back");

            int option = Integer.parseInt(scanner.nextLine());
//            scanner.nextLine();

            switch (option) {
                case 1: // addproduct();
                    System.out.println("Enter the name of the product:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the price of the product:");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter the region of the product:");
                    String region = scanner.nextLine();
                    controller.addProduct(name, price, region);
                    break;
                case 2: // updateProduct();
                    controller.getAllProducts().forEach(System.out::println);
                    System.out.println("Enter the name of the Product you want to update: ");
                    String updateName = scanner.nextLine();

                    System.out.println("Enter the price of the Product you want to update: ");
                    double priceUpt = Double.parseDouble(scanner.nextLine());

                    System.out.println("Enter the region of the Product you want to update: ");
                    String regionUpt = scanner.nextLine();

                    // Vereine vereine = controller.getAllObjWithName.stream().filter(c -> c.getName() == updateName).findFirst().orElse(null);
                    // if(vereine != null) {
                    controller.updateProduct(updateName, priceUpt, regionUpt);
                    System.out.println("Object with name " + updateName + " updated!");
                    // }
                    break;
                case 3: //deleteProduct();
                    controller.getAllProducts().forEach(System.out::println);
                    System.out.println("Enter the name of product you want to delete: ");
                    String nameDel = scanner.nextLine();
                    controller.deleteProduct(nameDel);
                    System.out.println("Product with name " + nameDel + " deleted!");
                    break;
                case 4: //getAllProducts;
                    controller.getAllProducts().forEach(System.out::println);
                    break;
                case 5: //getSpielerByName();
                    System.out.println("Enter the name: ");
                    String nameGet = scanner.nextLine();
                    System.out.println(controller.getProduct(nameGet));
                    break;
                case 0:
                    return;
                default: System.out.println("Invalid option, try again");
                    break;
            }
        }
    }

    private void manageSecondObject() {
        while (true) {
            System.out.println("1. Add Charakter");
            System.out.println("2. Update Charakter");
            System.out.println("3. Delete Charakter");
            System.out.println("4. Get All Charakter");
            System.out.println("5. Get Charakter by ID ");
            System.out.println("0. Back");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: //addObjwithID();

                    // citire  parametri

                    System.out.println("Enter the name of the charakter:");
                    String name = scanner.nextLine();

                    System.out.println("Enter the dorf of the charakter:");
                    String dorf = scanner.nextLine();



                    // daca are lista de obiectu celalalt
                     List<Product> prodList = new ArrayList<>();
                     while (true){
                                System.out.println("Enter charater product: ");
                                String prod = scanner.nextLine();
                                if(prod.isEmpty()){
                                    break;
                                }
                                else {
                                    prodList.add(controller.getProduct(prod));
                                }
                            }
                            controller.addCharakter(name, dorf, prodList);
                    System.out.println("Object added successfully");
                    break;
                case 2: //updateObjwithID();
                    controller.getCharakters().forEach(System.out::println);
                    System.out.println("Enter the id of the object to update: ");
                    int idUpdated = Integer.parseInt(scanner.nextLine());

                    // citire restu parametrilor
                    System.out.println("Enter the name of the charakter:");
                    String nameUpt = scanner.nextLine();

                    System.out.println("Enter the dorf of the charakter:");
                    String dorfUpt = scanner.nextLine();


                    List<Product> prodList2 = new ArrayList<>();
                    while (true){
                        System.out.println("Enter charater product: ");
                        String prod = scanner.nextLine();
                        if(prod.isEmpty()){
                            break;
                        }
                        else {
                            prodList2.add(controller.getProduct(prod));
                        }
                    }
                    controller.updateObjWithID(idUpdated,nameUpt, dorfUpt, prodList2);
                    System.out.println("Object with id "+ idUpdated +" updated successfully");
                    break;
                case 3: //deleteObjwithID();
                    controller.getCharakters().forEach(System.out::println);
                    System.out.println("Enter the ID of the object you want to delete: ");
                    int idDeleted = Integer.parseInt(scanner.nextLine());
                    controller.deleteCharakter(idDeleted);
                    System.out.println("Object with id " + idDeleted + " deleted successfully");
                    break;
                case 4: //getAllObjwithID();
                    System.out.println("Here is a list with all objects:");
                    controller.getCharakters().forEach(System.out::println);
                    break;
                case 5: //getObjwithId();

                    System.out.println("Enter the ID of the object you want see: ");
                    int idGet = Integer.parseInt(scanner.nextLine());
                    System.out.println("Your object with id " + idGet + " is: " + controller.getCharakter(idGet));
                    break;
                case 0:
                    return;
                default: System.out.println("Invalid option, try again");
                    break;
            }
        }
    }

}
