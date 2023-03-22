package MMP_Use_Interface;

import MMP.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 메모리실에서 User 정보를 관리하는 클래스
public class UserServiceInMemory implements UserService {
    private List<User> users;

    // 빈 리스트를 가지고 생성될 수도 있고
    public UserServiceInMemory() {
        this.users = new ArrayList<>();
    }

    // 유저 리스트를 가지고 생성될 수도 있음
    public UserServiceInMemory(List<User> users) {
        this.users = users;
    }

    @Override // 회원 등록
    public void addUser(User user) {
        users.add(user);
    }

    @Override // 회원 정보 수정
    public boolean updateUser(User user) {
        int findIdx = -1;
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(user.getEmail())){
                findIdx = i;
                users.remove(i);
                break;
            }
        }
        if (findIdx > -1) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean exists(String email) {
        if(findIndex(email) >= 0)
            return true;
        else
            return false;
    }

    // 이메일에 해당하는 회원정보가 있으면 0 이상의 값 반환 (코드 중복x)
    private int findIndex (String email){
        int findIdx = -1;
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(email)){
                findIdx = i;
                break;
            }
        }
        return findIdx;
    }

    @Override // 회원 삭제
    public boolean deleteUser(String email) {
        int findIdx = findIndex(email);
        if (findIdx > -1) {
            users.remove(findIdx);
            return true;
        } else {
            return false;
        }
    }

    // users 정보를 그대로 리턴? <- 외부에서 users 정보를 건드릴 수 있다.
    // users 정보를 복사 후 리턴? <- 데이터 관리가 어렵다.
    @Override
    public Iterator<User> getUsers() {
        // 읽기전용으로써 외부에서 건드릴 수 없다.
        return users.iterator();
    }
}
