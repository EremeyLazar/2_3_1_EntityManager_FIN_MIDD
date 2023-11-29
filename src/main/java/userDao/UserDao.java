package userDao;

import model.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class UserDao {

    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "roo";

    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    int ID_COUNT = 0;
    User user1 = new User (++ID_COUNT, "Aleksander", "+79096496543", "Argentina", 80, "ADL-678-12");
    User user2 = new User (++ID_COUNT, "Artemr", "+74552878965", "Columbia", 85, "AMB-512-22");
    User user3 = new User (++ID_COUNT, "Zhanna", "+79095152334", "Brazil", 90, "DRR-558-01");

    private List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3));


    public List<User> getAll() {
//        return userList;
        List <User> mySqlList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setCell(resultSet.getString("cell"));
                user.setCountry(resultSet.getString("country"));
                user.setSalary(resultSet.getInt("salary"));
                user.setDl(resultSet.getString("dl"));

                mySqlList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mySqlList;
    }

    public User getSingleUser (int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save (User user) {
//        user.setId(++ID_COUNT);
//        userList.add(user);

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO users VALUES(" + ++ID_COUNT + ", '" + user.getName() + "', '" + user.getCell() + "', '" + user.getCountry() + "', " + user.getSalary() + ", '" + user.getDl() +"')";
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteUser (User user) {
        userList.remove(user);
    }

    public void update (int id, User userUpdated) {
//        int id = userUpdated.getId();
        User toBeUpdated = getSingleUser(id);
        toBeUpdated.setName(userUpdated.getName());
        toBeUpdated.setCell(userUpdated.getCell());
        toBeUpdated.setCountry(userUpdated.getCountry());
        toBeUpdated.setDl(userUpdated.getDl());
        toBeUpdated.setSalary(userUpdated.getSalary());
    }








    public List<User> getCarsFromList(int num) {
        return userList.stream().limit(num).collect(Collectors.toList());
        }
}
