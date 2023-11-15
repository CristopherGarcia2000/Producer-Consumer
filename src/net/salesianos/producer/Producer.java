package net.salesianos.producer;
import net.salesianos.store.Store;

public class Producer extends Thread{
    private final String[] VEGETABLES = {"lettuce", "cabbage", "onion", "spinach", "potato", "celery",
            "asparagus", "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant",
            "carrot", "green bean"};
    private String producerName;
    private String vegetableName;
    private int  maxPlantedVegetables = 10;
    private int plantedVegetables = 0;
    private Store store;

    public Producer(String producerName,Store store) {
        this.producerName = producerName;
        this.store = store;
        this.vegetableName = VEGETABLES[(int)(Math.random() * VEGETABLES.length)];
    }

    @Override
    public synchronized void run() {
        while (plantedVegetables < maxPlantedVegetables){
            int growthTime = (int)(Math.random() * 1000);
            try {
                sleep(growthTime);
                store.addVegetables(vegetableName);
                plantedVegetables++;
                System.out.println(producerName + " ha producido un/a " + vegetableName);
                System.out.println("Almacén: "+store.showVegetablesList());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

