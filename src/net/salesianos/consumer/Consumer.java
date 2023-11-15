package net.salesianos.consumer;
import net.salesianos.store.Store;

public class Consumer extends Thread{
    private int eatenVegetablesLimit = 5;
    private String consumerName;
    private Store store;
    private int consumedVegetables = 0;


    public Consumer(String consumerName, Store store) {
        this.consumerName = consumerName;
        this.store = store;
    }

    @Override
    public synchronized void run() {
        while (consumedVegetables < eatenVegetablesLimit){
            int consumingTime = (int)(Math.random() * 1000);
            try{
                if(store.getVegetablesList() > 0){
                    sleep(consumingTime);
                    store.decreaseVegetables((int)(Math.random()*store.getVegetablesList()));
                    consumedVegetables++;
                    System.out.println(consumerName+" ha comido una verdura");
                    System.out.println("Almacén: "+store.showVegetablesList());
                    notifyAll();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
