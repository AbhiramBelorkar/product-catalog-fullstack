package com.ecom.product.catalog.config;

import com.ecom.product.catalog.domain.Category;
import com.ecom.product.catalog.domain.Product;
import com.ecom.product.catalog.repo.CategoryRepo;
import com.ecom.product.catalog.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public DataSeeder(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // clear all existing data
        productRepo.deleteAll();
        categoryRepo.deleteAll();

        // create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        Category books = new Category();
        books.setName("Books");

        Category sports = new Category();
        sports.setName("Sports");

        Category beauty = new Category();
        beauty.setName("Beauty");

        Category groceries = new Category();
        groceries.setName("Groceries");

        Category furniture = new Category();
        furniture.setName("Furniture");

        Category toys = new Category();
        toys.setName("Toys");

        Category automotive = new Category();
        automotive.setName("Automotive");

        categoryRepo.saveAll(Arrays.asList(
                electronics,
                clothing,
                home,
                books,
                sports,
                beauty,
                groceries,
                furniture,
                toys,
                automotive
        ));

//        categoryRepo.findAll().forEach(cat -> System.out.println("Saved category: " + cat.getId() + " - " + cat.getName()));

        // create product;
        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest mode smartphone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High-performance laptop with 16GB RAM and 512GB SSD.");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(1200.00);
        laptop.setCategory(electronics);

        Product tablet = new Product();
        tablet.setName("Tablet");
        tablet.setDescription("10-inch tablet with a long-lasting battery.");
        tablet.setImageUrl("https://placehold.co/600x400");
        tablet.setPrice(399.99);
        tablet.setCategory(electronics);

        Product tShirt = new Product();
        tShirt.setName("T-Shirt");
        tShirt.setDescription("Comfortable cotton t-shirt, available in various sizes.");
        tShirt.setImageUrl("https://placehold.co/600x400");
        tShirt.setPrice(15.99);
        tShirt.setCategory(clothing);

        Product jeans = new Product();
        jeans.setName("Jeans");
        jeans.setDescription("Classic denim jeans for casual wear.");
        jeans.setImageUrl("https://placehold.co/600x400");
        jeans.setPrice(39.99);
        jeans.setCategory(clothing);

        Product jacket = new Product();
        jacket.setName("Jacket");
        jacket.setDescription("Stylish leather jacket for colder weather.");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(79.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("Powerful blender with multiple speed settings.");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(49.99);
        blender.setCategory(home);

        Product microwave = new Product();
        microwave.setName("Microwave Oven");
        microwave.setDescription("800W microwave oven with multiple cooking presets.");
        microwave.setImageUrl("https://placehold.co/600x400");
        microwave.setPrice(120.99);
        microwave.setCategory(home);

        Product vacuumCleaner = new Product();
        vacuumCleaner.setName("Vacuum Cleaner");
        vacuumCleaner.setDescription("Lightweight vacuum cleaner with HEPA filtration.");
        vacuumCleaner.setImageUrl("https://placehold.co/600x400");
        vacuumCleaner.setPrice(120.00);
        vacuumCleaner.setCategory(home);

        Product novel = new Product();
        novel.setName("Novel: The Great Adventure");
        novel.setDescription("An exciting tale of exploration and discovery.");
        novel.setImageUrl("https://placehold.co/600x400");
        novel.setPrice(9.99);
        novel.setCategory(books);

        Product biography = new Product();
        biography.setName("Biography: Life of a Legend");
        biography.setDescription("A detailed biography of a legendary figure.");
        biography.setImageUrl("https://placehold.co/600x400");
        biography.setPrice(14.99);
        biography.setCategory(books);

        Product football = new Product();
        football.setName("Football");
        football.setDescription("High-quality football for outdoor play.");
        football.setImageUrl("https://placehold.co/600x400");
        football.setPrice(25.00);
        football.setCategory(sports);

        Product tennisRacket = new Product();
        tennisRacket.setName("Tennis Racket");
        tennisRacket.setDescription("Lightweight racket for better grip and power.");
        tennisRacket.setImageUrl("https://placehold.co/600x400");
        tennisRacket.setPrice(79.99);
        tennisRacket.setCategory(sports);

        Product skincareSet = new Product();
        skincareSet.setName("Skincare Set");
        skincareSet.setDescription("Complete skincare set for glowing skin.");
        skincareSet.setImageUrl("https://placehold.co/600x400");
        skincareSet.setPrice(59.99);
        skincareSet.setCategory(beauty);

        Product lipstick = new Product();
        lipstick.setName("Lipstick");
        lipstick.setDescription("Long-lasting matte lipstick in various shades.");
        lipstick.setImageUrl("https://placehold.co/600x400");
        lipstick.setPrice(19.99);
        lipstick.setCategory(beauty);

        Product rice = new Product();
        rice.setName("Rice");
        rice.setDescription("Premium quality rice, ideal for cooking.");
        rice.setImageUrl("https://placehold.co/600x400");
        rice.setPrice(10.99);
        rice.setCategory(groceries);

        Product flour = new Product();
        flour.setName("Flour");
        flour.setDescription("High-quality all-purpose flour.");
        flour.setImageUrl("https://placehold.co/600x400");
        flour.setPrice(3.99);
        flour.setCategory(groceries);

        Product diningTable = new Product();
        diningTable.setName("Dining Table");
        diningTable.setDescription("Wooden dining table with four chairs.");
        diningTable.setImageUrl("https://placehold.co/600x400");
        diningTable.setPrice(250.00);
        diningTable.setCategory(furniture);

        Product chair = new Product();
        chair.setName("Chair");
        chair.setDescription("Ergonomic office chair for comfort.");
        chair.setImageUrl("https://placehold.co/600x400");
        chair.setPrice(150.00);
        chair.setCategory(furniture);

        Product actionFigure = new Product();
        actionFigure.setName("Action Figure");
        actionFigure.setDescription("Collectible action figure of your favorite superhero.");
        actionFigure.setImageUrl("https://placehold.co/600x400");
        actionFigure.setPrice(19.99);
        actionFigure.setCategory(toys);

        Product boardGame = new Product();
        boardGame.setName("Board Game");
        boardGame.setDescription("Fun family board game for all ages.");
        boardGame.setImageUrl("https://placehold.co/600x400");
        boardGame.setPrice(25.00);
        boardGame.setCategory(toys);

        Product carTire = new Product();
        carTire.setName("Car Tire");
        carTire.setDescription("Durable all-weather car tire.");
        carTire.setImageUrl("https://placehold.co/600x400");
        carTire.setPrice(80.00);
        carTire.setCategory(automotive);

        Product carSeatCover = new Product();
        carSeatCover.setName("Car Seat Cover");
        carSeatCover.setDescription("Comfortable and durable car seat cover.");
        carSeatCover.setImageUrl("https://placehold.co/600x400");
        carSeatCover.setPrice(45.00);
        carSeatCover.setCategory(automotive);

        productRepo.saveAll(Arrays.asList(
                phone,
                laptop,
                tablet,
                tShirt,
                jeans,
                jacket,
                blender,
                microwave,
                vacuumCleaner,
                novel,
                biography,
                football,
                tennisRacket,
                skincareSet,
                lipstick,
                rice,
                flour,
                diningTable,
                chair,
                actionFigure,
                boardGame,
                carTire,
                carSeatCover
        ));

//        productRepo.findAll().forEach(product -> System.out.println("Saved product: " + product.getId() + " - " + product.getName()));

    }
}
