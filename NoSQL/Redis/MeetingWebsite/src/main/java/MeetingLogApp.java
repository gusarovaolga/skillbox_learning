public class MeetingLogApp {

    public static void main(String[] args) {
        RedisStorage storage = new RedisStorage();
        storage.start();
    }


}
