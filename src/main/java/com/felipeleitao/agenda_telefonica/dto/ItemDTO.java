package com.felipeleitao.agenda_telefonica.dto;

import com.felipeleitao.agenda_telefonica.models.Item;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private BigDecimal price;

    public ItemDTO(Item entity){
        name = entity.getName();
        price = entity.getPrice();
    }

    public List<ItemDTO> converterItemListToitemDTOList(List<Item> itemList){
        List<ItemDTO> itemDtoList = new ArrayList<>();
        itemList.forEach(x -> itemDtoList.add(new ItemDTO(x)));
        return itemDtoList;
    }
}