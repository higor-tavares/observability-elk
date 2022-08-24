package com.higortavares.products.controller;

import com.higortavares.products.domain.Product;
import com.higortavares.products.port.ProductPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/products")
@Slf4j
public class ProductController {

  @Autowired
  private ProductPort productPort;

  @GetMapping("/cart/{userId}")
  public ResponseEntity<?> cart(@PathVariable("userId") String userId){
    log.info("Getting products for user {} ...", userId);
    var products = productPort.listItems(userId);
    log.info("Products {}", products);
    return ResponseEntity.ok(products);
  }
}
