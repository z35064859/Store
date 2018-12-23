package com.itcast.store.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    // 个数不确定的购物项
    private double total=0;//
    // 总计/积分
    Map<String, CarItem> map = new HashMap<String, CarItem>();
    
    public double getTotal() {
        Collection<CarItem> values = map.values();
        for (CarItem carItem : values) {
            total+=carItem.getSubTotal();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Map<String, CarItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CarItem> map) {
        this.map = map;
    }

    // 添加
    public void addCatItemToCar(CarItem carItem) {
        String pid = carItem.getProduct().getPid();
        if (map.containsKey(carItem.getProduct().getPid())) {
            
        } else {
            CarItem oldItem = map.get(pid);
            carItem.setNum(oldItem.getNum()+carItem.getNum());
            map.put(pid,carItem);
        }

    }

    // 移除
    public void removeCatItem(String pid) {
        map.remove(pid);
    }

    // 清空
    public void clearCatItem() {
        map.clear();
    }
}
