package MMP_Use_Interface;

import MMP.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class UserUI {
    private BufferedReader br;

    public UserUI() {
        // 입출력 속도 향상을 위해 사용
        // Buffer : 데이터를 전송하는 동안 일시적으로 데이터를 보관하는 메모리 영역

        // Scanner = 띄어쓰기, 엔터를 경계로 입력 값을 인식
        // BufferReader = 엔터만 경계로 인식, String으로 고정
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu() {

        // 안내
        System.out.println();
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 목록");
        System.out.println("3. 회원 정보 수정");
        System.out.println("4. 회원 삭제");
        System.out.println("5. 종료");

        int menuId = -1;
        try {
            String line = br.readLine(); // 한줄 입력받기
            menuId = Integer.parseInt(line); // 문자열을 정수로 변환
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return menuId;
    }

    // 1. 회원 등록
    public User regUser() {
        try {
            System.out.println("이메일을 입력하세요. ex) hyuntae@naver.com");
            System.out.println("(이메일은 수정이 불가능하니 유의해주세요!)");
            String email = br.readLine();
            System.out.println("이름을 입력하세요. ex) 조현태");
            String name = br.readLine();
            System.out.println("생년을 입력하세요. ex) 1999");
            String strBirthYear = br.readLine();
            int birthYear = Integer.parseInt(strBirthYear); // 문자열로 받기때문에 정수로 변환

            // 정보를 입력받고 user 객체를 반환
            User user = new User(email, name, birthYear);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // 2. 회원 목록 (출력)
    public void printUserList(Iterator<User> iter) {
        System.out.println("      email                이름       생년");
        System.out.println("==========================================");
        while (iter.hasNext()) {
            User user = iter.next();
            System.out.print(user.getEmail());
            System.out.print("     ");
            System.out.print(user.getName());
            System.out.print("      ");
            System.out.print(user.getBrithYear());
            System.out.println();
        }

    }

    // 3, 4. 회원 정보 수정 + 회원 삭제
    // 수정/삭제할 email 받기
    public String inputEmail() {
        System.out.println("email을 입력해주세요.");
        String email = "";
        try {
            email = br.readLine(); // email 입력받기
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return email;
    }

    // 수정한 email로 회원정보 수정
    public User inputUser(String email) {
        try {
            System.out.println(email + " 회원의 정보를 수정합니다.");
            System.out.println("이름을 입력하세요. ");
            String name = br.readLine();
            System.out.println("생년을 입력하세요. ");
            String strBirthYear = br.readLine();
            int birthYear = Integer.parseInt(strBirthYear); // 문자열로 받기때문에 정수로 변환

            // 정보를 입력받고 user 객체를 반환
            User user = new User(email, name, birthYear);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
