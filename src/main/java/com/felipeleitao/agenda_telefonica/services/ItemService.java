package com.felipeleitao.agenda_telefonica.services;

import com.felipeleitao.agenda_telefonica.models.Item;
import com.felipeleitao.agenda_telefonica.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository ItemRepository;

    public List<Item> findAll() {
        return ItemRepository.findAll();
    }

}
