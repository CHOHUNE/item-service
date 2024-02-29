package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();  // static
    private static long sequence = 0L; // static

    // Spring Container 안에서 쓰면 싱글톤이어서 static을 안써도 상관 없지만
    // 따로 new 해서 쓸 때엔 새로 생성될 수 있음을 미연에 방지차 사용

    public Item save(Item item){
        item.setId(sequence++);
        store.put(item.getId(),item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());

    }

    public void clearStore() {
        store.clear();
    }




}
