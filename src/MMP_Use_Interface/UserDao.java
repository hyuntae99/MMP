package MMP_Use_Interface;

import MMP.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// List<MMP.User> 정보를 저장하거나 읽어오는 기능
public class UserDao {
    private String filename;

    public UserDao(String filename) {
        this.filename = filename;
    }

    // User를 목록을 받는다. (저장)
    public void saveUser(Iterator<User> iter) {
        List<User> users = new ArrayList<>(); // 배열 생성
        while (iter.hasNext()) { // 하나씩 접근하면서 (Bool타입으로 반환)
            User user = iter.next(); // 적합한 타입으로 user에 저장
            users.add(user); // 추가
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(users); // 저장
            } catch(Exception ex){
                ex.printStackTrace();
        }
    }

    // User의 정보를 읽어오는 기능
    public List<User> getUsers() {
        File file = new File(filename); // file 생성
        if (file.exists()) { // 파일이 존재하지 않으면
            return new ArrayList<>(); // 비어있는 배열 반환
        }

        List<User> list = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            list = (List<User>) in.readObject(); // List를 리턴
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }


}
