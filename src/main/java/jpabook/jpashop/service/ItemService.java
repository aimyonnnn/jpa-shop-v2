package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    // 상품 등록
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 상품 조회 - 단건
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    // 상품 조회 - 전체
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    /**
     * 영속성 컨텍스트가 자동 변경
     *
     * 엔티티를 변경할 때는 항상 변경 감지를 사용하세요
     * 1. 컨트롤러에서 어설프게 엔티티를 생성하지 마세요.
     * 2. 트랜잭션이 있는 서비스 계층에 식별자( `id` )와 변경할 데이터를 명확하게 전달하세요.(파라미터 or dto)
     * 3. 트랜잭션이 있는 서비스 계층에서 영속 상태의 엔티티를 조회하고, 엔티티의 데이터를 직접 변경하세요.
     * 4. 트랜잭션 커밋 시점에 변경 감지가 실행됩니다.
     */
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity, String author, String isbn) {
        Book item = (Book) itemRepository.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        item.setAuthor(author);
        item.setIsbn(isbn);
    }
}
