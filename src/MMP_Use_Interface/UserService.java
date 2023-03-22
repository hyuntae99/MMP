package MMP_Use_Interface;

import MMP.User;

import java.util.Iterator;

public interface UserService {
    //회원정보를 등록한다.
    public void addUser(User user);

    //회원정보를 수정한다. (email로 접근하여)
    public boolean updateUser(User user);

    //회원정보를 삭제한다. (email로 접근하여)
    public boolean deleteUser(String email);

    //모든 회원정보를 반환한다.
    public Iterator<User> getUsers(); // 읽기전용!

    // 이메일에 부합하는 회원 정보가 있다면 true 반환한다.
    public boolean exists (String email);

}
