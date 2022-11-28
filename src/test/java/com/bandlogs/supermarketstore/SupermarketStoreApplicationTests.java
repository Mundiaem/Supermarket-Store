package com.bandlogs.supermarketstore;

import com.bandlogs.supermarketstore.domain.Category;
import com.bandlogs.supermarketstore.domain.Products;
import com.bandlogs.supermarketstore.domain.Vendors;
import com.bandlogs.supermarketstore.service.CategoryService;
import com.bandlogs.supermarketstore.service.ProductServices;
import com.bandlogs.supermarketstore.service.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

@SpringBootTest
class SupermarketStoreApplicationTests {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductServices productServices;

    @Autowired
    private VendorService vendorService;

  private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


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

        Vendors vendor = Vendors.builder().id(1).address("***").name("Suppliers").email("suppliers@email.com").build();
       Vendors ven= vendorService.saveVendor(vendor);
        Category category = Category.builder().id(1).name("Electronics")
                .Description("All electronics from all brands").build();

       Category cat= categoryService.addCategory(category);


        Products products = Products.builder().id(1).name("Smart Phone").description("Brand new ")
                .exp_date(exp_date).mf_date(mf_date).price(30023.45)
                .unit(30).status("available").vendors(ven).category(cat).build();
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



    }

}
