import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";
        int year = 2018;

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT pl.course_name, count(pl.course_name) / (max(MONTH(pl.subscription_date)) - MIN(MONTH(pl.subscription_date)) + 1) average_purchases" +
                            " from purchaselist pl" +
                            " where YEAR(pl.subscription_date) =" + year +
                            " GROUP BY pl.course_name");
            System.out.println("Среднее количество покупок в месяц для каждого курса Skillbox за " + year + " год: ");
            System.out.println();
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String averagePurchases = resultSet.getString("average_purchases");
                String result = String.format("%.2f",Double.parseDouble(averagePurchases));
                System.out.println("курс \"" + courseName + "\"" + " среднее количество покупок в месяц: " + result);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
