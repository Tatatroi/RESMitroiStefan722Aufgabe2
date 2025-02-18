//import CONTROLLER.Controller;
//import REPO.ObjectWithIDRepo;
//import REPO.ObjectWithNameRepo;
//import UI.Ui;

import CONTROLLER.Controller;
import REPO.ObjectWithIDRepo;
import REPO.ObjectWithNameRepo;
import UI.Ui;
import MODEL.Product;
import MODEL.Charakter;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ObjectWithNameRepo productsRepo = new ObjectWithNameRepo();
        ObjectWithIDRepo charaktersRepo = new ObjectWithIDRepo();

        Product p1 = new Product("Kunai", 50.0, "Konoha");
        Product p2 = new Product("Shuriken", 30.0, "Konoha");
        Product p3 = new Product("Heiltrank", 100.0, "Sunagakure");
        Product p4 = new Product("Schwert", 200.0, "Kirigakure");
        Product p5 = new Product("Sprengsiegel", 75.0, "Iwagakure");
        Product p6 = new Product("Riesenfächer", 300.0, "Sunagakure");
        Product p7 = new Product("Giftklinge", 150.0, "Kirigakure");
        Product p8 = new Product("Explosionskugel", 250.0, "Iwagakure");
        Product p9 = new Product("Schattendolch", 180.0, "Konoha");
        Product p10 = new Product("Wasserperle", 90.0, "Kirigakure");



        productsRepo.add(p1);
        productsRepo.add(p2);
        productsRepo.add(p3);
        productsRepo.add(p4);
        productsRepo.add(p5);
        productsRepo.add(p6);
        productsRepo.add(p7);
        productsRepo.add(p8);
        productsRepo.add(p9);
        productsRepo.add(p10);




        List<Product> lp1 = new ArrayList<>();
        lp1.add(p1);
        lp1.add(p4);
        lp1.add(p9);
        lp1.add(p6);

        List<Product> lp2 = new ArrayList<>();
        lp2.add(p3);
        lp2.add(p5);
        lp2.add(p7);
        lp2.add(p2);

        List<Product> lp3 = new ArrayList<>();
        lp3.add(p2);
        lp3.add(p3);
        lp3.add(p4);
        lp3.add(p8);
        lp3.add(p10);


        Charakter c1 = new Charakter(1, "Naruto Uzumaki", "Konoha",lp1);
        Charakter c2 = new Charakter(2, "Gaara", "Sunagakure",lp2);
        Charakter c3 = new Charakter(3, "Kisame Hoshigaki", "Kirigakure",lp3);

        charaktersRepo.add(c1);
        charaktersRepo.add(c2);
        charaktersRepo.add(c3);

        // add objects in the repos
        Controller controller = new Controller(charaktersRepo,productsRepo);
        Ui ui = new Ui(controller);

        ui.run();
    }
}