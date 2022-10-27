import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarNumberLoader {

    public void loadCarNumber() throws Exception {

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numberOfCores);

        for (int regionCode = 1; regionCode < 100; regionCode++) {
            service.submit(new CarNumberGenerator(regionCode));
        }
        service.shutdown();
    }
}

