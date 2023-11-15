package net.salesianos.store;
import java.util.ArrayList;

public class Store {
    private ArrayList<String> vegetablesAmount = new ArrayList<>();
    private int storeCapacity = 10;

    public synchronized int getVegetablesList() {
        return vegetablesAmount.size();
    }

    public synchronized int getStoreCapacity() {
        return storeCapacity;
    }

    public synchronized void addVegetables(String vegetable) throws InterruptedException{
        vegetablesAmount.add(vegetable);
        notifyAll();
    }
    public synchronized void decreaseVegetables(int position) throws InterruptedException{
        while(vegetablesAmount.size() == 0){
            wait();
        }
        vegetablesAmount.remove(position);
    }
    public synchronized ArrayList<String> showVegetablesList() {
        return vegetablesAmount;
    }
}

