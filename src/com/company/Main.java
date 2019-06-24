package com.company;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();


    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket timsbasket = new Basket("Tim");
        sellItem(timsbasket, "car", 1);
        System.out.println(timsbasket);

        //sellItem(timsbasket, "car", 1);
        System.out.println(timsbasket);

        sellItem(timsbasket, "spanner", 1);
        System.out.println(timsbasket);

        sellItem(timsbasket, "juice", 1);
        sellItem(timsbasket, "bread", 1);
        sellItem(timsbasket, "cup", 1);
        System.out.println(timsbasket);

        sellItem(timsbasket, "cake", 8);

        System.out.println(stockList);

//        temp = new StockItem("pen", 1.22);
//        stockList.Items().put(temp.getName(), temp);

        stockList.Items().get("car").adjustStock(2000);
        stockList.Items().get("car").adjustStock(-1000);
        System.out.println(stockList);
        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs" + price.getValue());
        }

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        if (stockItem.quantityInStock() < quantity) {
            System.out.println("We can not sell " + quantity + " " + stockItem.getName() + ". We have only " + stockItem.quantityInStock());
        }
        return 0;
    }
}
