package userDao;

import model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class UserDao {

    int ID_COUNT = 0;
    User user1 = new User (++ID_COUNT, "Aleksander", "+79096496543", "Argentina", 80, "ADL-678-12");
    User user2 = new User (++ID_COUNT, "Artemr", "+74552878965", "Columbia", 85, "AMB-512-22");
    User user3 = new User (++ID_COUNT, "Zhanna", "+79095152334", "Brazil", 90, "DRR-558-01");

    private List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3));


    public List<User> getAll() {
        return userList;
    }

    public User getSingleUser (int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save (User user) {
        user.setId(++ID_COUNT);
        userList.add(user);
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
