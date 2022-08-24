package com.higortavares.products.port;

import com.higortavares.products.domain.Product;
import java.util.List;

public interface ProductPort {
  List<Product> listItems(String userId);
}
