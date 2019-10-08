package com.ssm.template.dao;

import com.ssm.template.pojos.Item;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface ItemDAO {
    List<Item> getItems();
}
