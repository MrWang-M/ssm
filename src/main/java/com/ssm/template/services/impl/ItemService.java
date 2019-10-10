package com.ssm.template.services.impl;

import com.ssm.template.dao.ItemDAO;
import com.ssm.template.handlers.ZanHandler;
import com.ssm.template.pojos.Item;
import com.ssm.template.services.IItemService;
import com.ssm.template.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private ZanHandler zanHandler;


    public List<ItemVO> getItems(String userId) {
        List<Item> list = zanHandler.getItems();
        List<ItemVO> items = new ArrayList<ItemVO>();

        for (Item item: list) {
            ItemVO vo = new ItemVO();
            vo.setId(item.getId());
            vo.setName(item.getName());
            vo.setZan(zanHandler.getZan(item.getId()));
            vo.setUser(zanHandler.getUser(userId, item.getId()));
            items.add(vo);
        }
        return items;
    }
}
