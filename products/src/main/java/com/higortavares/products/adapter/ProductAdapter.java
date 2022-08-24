package com.higortavares.products.adapter;

import com.higortavares.products.domain.Product;
import com.higortavares.products.port.ProductPort;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProductAdapter implements ProductPort {
  @Override
  public List<Product> listItems(String userId) {
    return Arrays.asList(
        new Product(getId(), "Iphone Pro Max", 9800.0),
        new Product(getId(), "Garrafa Squeze", 20.0),
        new Product(getId(), "Livro Sistemas Operacionais", 130.9));
  }
  private String getId(){
    return UUID.randomUUID().toString();
  }
}
