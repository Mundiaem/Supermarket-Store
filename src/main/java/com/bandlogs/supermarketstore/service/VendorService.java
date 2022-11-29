package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.Vendors;
import com.bandlogs.supermarketstore.repository.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 15:46
 * ⚡  - Supermarket Store
 */
@Service
public class VendorService {
    @Autowired
    private VendorsRepository vendorsRepository;

    public Vendors saveVendor(Vendors vendor) {
        return vendorsRepository.save(vendor);
    }

    public void deleteAll() {
        vendorsRepository.deleteAll();
    }

    public List<Vendors> findALlVendors() {
        return vendorsRepository.findAll();
    }

    public boolean vendorExists(String name){
        return vendorsRepository.existsByName(name);
    }
}
