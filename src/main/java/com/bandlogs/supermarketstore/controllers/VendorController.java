package com.bandlogs.supermarketstore.controllers;

import com.bandlogs.supermarketstore.domain.Vendors;
import com.bandlogs.supermarketstore.service.VendorService;
import com.bandlogs.supermarketstore.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created with love by mundiaem
 * created on 29/11/2022
 * Time: 11:45
 * ⚡  - Supermarket Store
 */
@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {
    public static final Logger logger = LoggerFactory.getLogger(VendorController.class);
    @Autowired
    private VendorService vendorService;

    @PostMapping(value = "/", consumes = {"application/json"})
    public ResponseEntity<?> createVendor(@RequestBody Vendors vendors) {

        if (vendorService.vendorExists(vendors.getName())) {
            logger.error("Unable to create. A Vendor with name {} already exist", vendors.getName());
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to create. A Vendor with name " +
                    vendors.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        Vendors vendor = vendorService.saveVendor(vendors);

        return new ResponseEntity<Vendors>(vendor, HttpStatus.CREATED);


    }

    @GetMapping
    public ResponseEntity<?> getAllVendors() {
        List<Vendors> vendors = vendorService.findALlVendors();
        if (vendors.isEmpty()) {
            return new ResponseEntity<>(new CustomErrorType("No Vendor at the moment"), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Vendors>>(vendors, HttpStatus.OK);
    }
}
