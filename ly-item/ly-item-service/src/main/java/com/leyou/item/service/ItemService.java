package com.leyou.item.service;

import com.leyou.item.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created with IDEA
 *
 * @author：JiangYuzhen
 * @date：2019/7/21
 * @time: 18:37
 * @description: TODO
 */
@Service
public class ItemService {
    public Item saveItem(Item item){
        int id = new Random().nextInt(100);
        item.setId(id);
        return item;
    }
}
