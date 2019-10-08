package com.ssm.template.services.impl;

import com.ssm.template.dao.ItemDAO;
import com.ssm.template.pojos.Item;
import com.ssm.template.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemDAO itemDAO;

    public List<Item> getItems() {
        return itemDAO.getItems();
    }
}
