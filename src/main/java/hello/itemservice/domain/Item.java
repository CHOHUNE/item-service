package hello.itemservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
//    int 로 쓰면 null 값이 안들어간다


    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
