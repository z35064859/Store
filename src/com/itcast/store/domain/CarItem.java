package com.itcast.store.domain;

public class CarItem {
    private Product product;//商品
    private int num;//数量
    private double subTotal;//某种商品 总价
    
    public CarItem() {
        super();
    }
    public CarItem(Product product, int num, double subTotal) {
        super();
        this.product = product;
        this.num = num;
        this.subTotal = subTotal;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal() {
        this.subTotal = product.getShop_price()*num;
    }
    @Override
    public String toString() {
        return "CatItem [product=" + product + ", num=" + num + ", subTotal=" + subTotal + "]";
    }
    
}
