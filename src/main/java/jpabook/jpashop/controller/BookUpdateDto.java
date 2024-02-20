package jpabook.jpashop.controller;

import lombok.Data;

@Data
public class BookUpdateDto {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;

}
