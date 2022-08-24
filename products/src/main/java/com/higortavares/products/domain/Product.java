package com.higortavares.products.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  private String id;
  private String name;
  private Double price;
}
