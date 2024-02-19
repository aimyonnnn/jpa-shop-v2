package jpabook.jpashop.service;

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

}
