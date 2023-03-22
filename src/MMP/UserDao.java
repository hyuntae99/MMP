package MMP;

import MMP.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// List<MMP.User> 정보를 저장하거나 읽어오는 기능
public class UserDao {
    private String filename;

    public UserDao (String filename) {
        this.filename = filename;
    }

    // User를 목록을 받는다. (저장)
    public void saveUser(List<User> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(list);
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
