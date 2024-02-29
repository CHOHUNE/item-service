package hello.itemservice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then

        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        //give
        Item item = new Item("item1", 1000, 10);
        Item item2 = new Item("item1", 1000, 20);
        //when

        itemRepository.save(item);
        itemRepository.save(item2);

        List<Item> result = itemRepository.findAll();

        //then

        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(item, item2);
    }

    @Test
    void updateItem() {
        Item item = new Item("item1", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        Item updateParam = new Item("item2", 2000, 30);
        itemRepository.update(itemId, updateParam);

        //then
        Item findItem = itemRepository.findById(itemId);

        Assertions.assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        Assertions.assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        Assertions.assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
}