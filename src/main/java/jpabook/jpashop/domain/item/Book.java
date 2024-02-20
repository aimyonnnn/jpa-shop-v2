package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jpabook.jpashop.controller.BookUpdateDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
    
    //==비즈니스 로직==//
    public void updateBook(BookUpdateDto dto) {
        this.setName(dto.getName());
        this.setPrice(dto.getPrice());
        this.setStockQuantity(dto.getStockQuantity());
        this.setAuthor(dto.getAuthor());
        this.setIsbn(dto.getIsbn());
    }

}
