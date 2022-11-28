package com.bandlogs.supermarketstore;

import com.bandlogs.supermarketstore.domain.*;
import com.bandlogs.supermarketstore.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class SupermarketStoreApplicationTests {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductServices productServices;
    @Autowired
    private VendorService vendorService;
    @Autowired
    private LPOService lpoService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @Test
    void simpleCategoryTest() {
        Category category = Category.builder().id(1).name("Electronics").Description("All electronics from all brands").build();
        categoryService.addCategory(category);

        System.out.println("\n ************ Original Category ****************");
        categoryService.findAll().forEach(System.out::println);

        //age up the students

        System.out.println("\n ******************** Category *********************");
        categoryService.findAll().forEach(System.out::println);
        categoryService.deleteAll();
        System.out.println(" \n **************** Category removed *************************** ");
        categoryService.findAll().forEach(System.out::println);
    }

    @Test
    void simpleProductTest() throws ParseException {

        String exp_dateInString = "7-Jun-2023";
        String mf_dateString = "7-Jun-2022";

        Date exp_date = formatter.parse(exp_dateInString);
        Date mf_date = formatter.parse(mf_dateString);

        Category category = Category.builder().id(1).name("Electronics")
                .Description("All electronics from all brands").build();

        Category cat = categoryService.addCategory(category);


        Products products = Products.builder().id(1).name("Smart Phone").description("Brand new ")
                .exp_date(exp_date).mf_date(mf_date).price(30023.45)
                .unit(30).status("available").category(cat).build();
        productServices.addProduct(products);


        System.out.println("\n ************ Original Products ****************");
        productServices.findAll().forEach(System.out::println);

        System.out.println(" \n **************** Products  vendors  *************************** ");

        System.out.println("\n ******************** Products  *********************");
        productServices.findAll().forEach(System.out::println);
        productServices.deleteAll();
        vendorService.deleteAll();
        categoryService.deleteAll();

        System.out.println(" \n **************** Products  removed *************************** ");
        productServices.findAll().forEach(System.out::println);
    }

    @Test
    void simpleMakeOrdersToSuppliersTest() throws ParseException {
        String exp_dateInString = "7-Jun-2023";
        String mf_dateString = "7-Jun-2022";

        Date exp_date = formatter.parse(exp_dateInString);
        Date mf_date = formatter.parse(mf_dateString);

        Category category = Category.builder().id(1).name("Electronics")
                .Description("All electronics from all brands").build();

        Category cat = categoryService.addCategory(category);
        String today_dateString = "28-Nov-2022";

        Date today_date = formatter.parse(today_dateString);
        Products products = Products.builder().name("Smart Phone").description("Brand new ")
                .exp_date(exp_date).mf_date(mf_date).price(30023.45)
                .unit(30).status("available").category(cat).build();
        Products product_1 = Products.builder().name("I Phone").description("From apple store ")
                .exp_date(exp_date).mf_date(mf_date).price(90000.00)
                .unit(30).status("available").category(cat).build();
        Products prod_1 = productServices.addProduct(products);
        Products prod_2 = productServices.addProduct(product_1);
        Vendors vendors = Vendors.builder().email("vendor@email.com").name("Vendor").other_details("***")
                .address("Mombasa").phone("+39 4923 023 434").build();
        Vendors ven = vendorService.saveVendor(vendors);
        LPO lpo = LPO.builder().lpo_issue_date(today_date).vendor(ven).build();
        LPO lp = lpoService.saveOrder(lpo);

        OrderDetails orderDetails = OrderDetails.builder().order_date(today_date).quantity(3).unit_price(1000000.00).total(300000.00).product(prod_1).lpo(lp).build();
        OrderDetails orderDetails_1 = OrderDetails.builder().order_date(today_date).quantity(3).unit_price(700000.00).total(210000.00).product(prod_2).lpo(lp).build();

        orderDetailsService.saveOrder(orderDetails);
        orderDetailsService.saveOrder(orderDetails_1);


        System.out.println("\n ************ Original Products ****************");
        productServices.findAll().forEach(System.out::println);

        System.out.println(" \n **************** Products  vendors  *************************** ");

        System.out.println("\n ******************** Products  *********************");
        productServices.findAll().forEach(System.out::println);
        productServices.deleteAll();
        vendorService.deleteAll();
        categoryService.deleteAll();

        System.out.println(" \n **************** Products  removed *************************** ");
        productServices.findAll().forEach(System.out::println);


    }

    @Test
    void simpleReceiveProductsFromSuppliers() {

    }


}
