package com.ssm.template.services;

import com.ssm.template.pojos.Item;
import com.ssm.template.vo.ItemVO;

import java.util.List;

public interface IItemService {
    List<ItemVO> getItems(String userId);
}
