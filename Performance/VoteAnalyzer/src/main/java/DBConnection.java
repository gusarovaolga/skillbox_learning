import java.sql.*;

public class DBConnection {
    public static Connection connection;
    public static PreparedStatement preparedStatement;

    private static String dbName = "voters";
    private static String dbUser = "root";
    private static String dbPass = "testtest";

    private static StringBuilder insertQueryForVoters = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");

                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void countVoter(String name, String birthDay) throws SQLException {

        String birthDate = birthDay.replace('.', '-');
        insertQueryForVoters.append(insertQueryForVoters.length() == 0 ? "" : ",")
                .append("('")
                .append(name)
                .append("','")
                .append(birthDate)
                .append("', 1)");
    }

    public static void executeMultiInsert() throws SQLException {
        String sql = " INSERT INTO voter_count(name, birthDate, `count`) " +
                "VALUES " + insertQueryForVoters.toString() +
                " ON DUPLICATE KEY UPDATE `count`=`count` + 1";
        DBConnection.getConnection().createStatement().execute(sql);
    }


    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT voter.id, voter.name, voter.birthDate, count(*) c " +
                "FROM voters.voter_count voter  " +
                "group by concat(name, birthDate) having c > 1 " +
                "order by name";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);

        while (rs.next()) {
            System.out.println(new StringBuilder()
                    .append("\t")
                    .append(rs.getString("name"))
                    .append(" (").append(rs.getString("birthDate"))
                    .append(") - ")
                    .append(rs.getInt("c")));
        }
        rs.close();
    }

    public static int customSelect() throws SQLException {
        String sql = "SELECT id FROM voter_count WHERE name='Исаичев Эмилиан'";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        if (!rs.next()) {
            return -1;
        } else {
            return rs.getInt("id");
        }
    }
}
