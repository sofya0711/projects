package education.storage;

import education.model.User;
import education.util.FileUtil;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {


    private Map<String , User> userMap = new HashMap<>();
//    private User[] users = new User[20];
//    private int size;

    public void add(User user) {
            userMap.put(user.getEmail(),user);
        FileUtil.serializeUserMap(userMap);

//        if (users.length == size) {
//            extend();
//        }
//        users[size++] = user;
    }

//    private void extend() {
//        User[] tmp = new User[users.length + 20];
//        System.arraycopy(users, 0, tmp, 0, users.length);
//        users = tmp;
//    }


    public User getByEmail(String email) {
        return userMap.get(email);
//        for (int i = 0; i < size; i++) {
//            if (users[i].getEmail().equals(email)) {
//                return users[i];
//            }
//        }
//        return null;
    }
}
