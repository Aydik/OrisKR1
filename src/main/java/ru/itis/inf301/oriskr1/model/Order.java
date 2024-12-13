package ru.itis.inf301.oriskr1.model;


public class Order {
    private Long id;
    private String dish_list;
    private int table_number;
    private String waiter;

    public Order() {}

    public Order(Long id, String dish_list, int table_number, String waiter) {
        this.id = id;
        this.dish_list = dish_list;
        this.table_number = table_number;
        this.waiter = waiter;
    }

    public Long getId() {
        return id;
    }

    public String getDish_list() {
        return dish_list;
    }

    public int getTableNumber() {
        return table_number;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDish_list(String dish_list) {
        this.dish_list = dish_list;
    }

    public void setTableNumber(int table_number) {
        this.table_number = table_number;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }
}