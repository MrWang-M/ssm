package com.ssm.template.services.impl;

import com.ssm.template.dao.ItemDAO;
import com.ssm.template.handlers.ZanHandler;
import com.ssm.template.pojos.Item;
import com.ssm.template.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private ZanHandler zanHandler;

    public List<Item> getItems() {
        List<Item> list = itemDAO.getItems();
        for (int i = 0; i < list.size(); i++){
            list.get(i).setZan(zanHandler.getZan(list.get(i).getId()));
        }
        return list;
    }
}
