import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RedisStorage {

    private final static String KEY = "Users";
    private RedissonClient redisson;
    private RKeys rKeys;
    private RScoredSortedSet<String> users;


    private double getTs() {
        return new Date().getTime() / 1000;
    }

    public void start() {
        List<Integer> userInts = init();
        print(userInts);
        shutdown();
    }

    private List<Integer> init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(Exc.getMessage());
        }

        removeKey();
        rKeys = redisson.getKeys();
        users = redisson.getScoredSortedSet(KEY, StringCodec.INSTANCE);

        List<Integer> userInts = parseToInt(users);
        Collections.sort(userInts);

        rKeys.delete(KEY);
        logPageVisit();

        return userInts;
    }

    private void logPageVisit() {
        for (int i = 1; i <= 20; i++) {
            users.add(getTs(), String.valueOf(i));
        }
    }

    private List<Integer> parseToInt(RScoredSortedSet<String> users) {

        return users.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void print(List<Integer> userInts) {
        for (Integer user : userInts) {
            System.out.println("- На главной странице показываем пользователя " + user);
            try {
                Thread.sleep(1000);
                if (Math.random() < 0.10) {
                    Random r1 = new Random();
                    int i = r1.nextInt(users.size() - 1);
                    donate(String.valueOf(i));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        print(userInts);
    }

    private void donate(String element) throws InterruptedException {

        System.out.printf("> Пользователь %s оплатил платную услугу\n", element);
        System.out.printf("- На главной странице показываем пользователя %s\n", element);
        Thread.sleep(1000);
    }

    private void removeKey() {
        redisson.getRemoteService(KEY);
    }

    private void shutdown() {
        redisson.shutdown();
    }
}

