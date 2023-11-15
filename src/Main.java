import net.salesianos.consumer.Consumer;
import net.salesianos.producer.Producer;
import net.salesianos.store.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producerManolo = new Producer("Manolo",store);
        Producer producerPaco = new Producer("Paco",store);
        Consumer consumerPepe = new Consumer("Pepe",store);
        Consumer consumerJuan = new Consumer("Juan",store);

        producerManolo.start();
        producerPaco.start();
        consumerPepe.start();
        consumerJuan.start();
    }
}