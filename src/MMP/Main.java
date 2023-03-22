package MMP;

import MMP.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("안녕하세요 :D");
        System.out.println("회원 관리 프로그램입니다!");

        UserUI userUI = new UserUI(); // UI
        // C:/tmp/users.dat
        // C:/Users/홈디렉토리/data/users.dat -> 삭제 x
        UserDao userDao = new UserDao("C:\\MMP\\user.dat"); // 파일 이름
        List<User> users = userDao.getUsers(); // 메모리상의 MMP.User 정보를 관리하는 것.

        while (true) {
            int menuId = userUI.menu();
            // 종료 동작
            if (menuId == 5) {
                System.out.println("종료합니다. :)");
                userDao.saveUser(users); // 정보 저장
                break;
            }
            // 유저 등록
            else if (menuId == 1) {
                User user = userUI.regUser(); // 회원 등록
                users.add(user); // 유저 등록
                System.out.println("등록되었습니다.");
            }
            // 회원 목록
            else if (menuId == 2) {
                userUI.printUserList(users); // 회원 목록 출력
            }
            // 이메일로 회원 정보 수정
            else if (menuId == 3) {
                System.out.println("email을 통해 회원 정보를 수정할 수 있습니다.");
                String email = userUI.inputEmail();
                int findIdx = -1;
                for (int i = 0; i < users.size(); i++) {
                    User u = users.get(i);
                    // 같은 이메일을 발견하면
                    if (u.getEmail().equals(email)) {
                        findIdx = i; // findIdx에 위치를 저장
                        break;
                    }
                }
                while (true) {
                    if (findIdx != -1) { // 찾았다
                        Scanner sc = new Scanner(System.in);
                        System.out.println("회원 정보를 정말로 수정하시겠습니까? (Y/N)");
                        String ans = sc.nextLine();
                        if (ans.equals("Y") || ans.equals("y")) {
                            User updateUser = userUI.inputUser(email);
                            users.remove(findIdx); // 수정할 회원 정보 삭제
                            users.add(updateUser); // 수정된 회원 정보 추가
                            System.out.println("회원 정보가 수정되었습니다.");
                            break;
                        } else if (ans.equals("N") || ans.equals("n")) {
                            System.out.println("회원 정보 수정이 취소되었습니다.");
                            break;
                        } else {
                            System.out.println("Y/N 중에서 입력해주세요!");
                        }
                    } else { // 못찾았다
                        System.out.println("삭제할 회원 정보가 없습니다!");
                        break;
                    }
                }
            }
            // 이메일로 회원 삭제
            else if (menuId == 4) {
                System.out.println("email을 통해 회원 정보를 삭제할 수 있습니다.");
                String email = userUI.inputEmail();
                int findIdx = -1;
                for (int i = 0; i < users.size(); i++) {
                    User u = users.get(i);
                    // 같은 이메일을 발견하면
                    if (u.getEmail().equals(email)) {
                        findIdx = i; // findIdx2에 위치를 저장
                        break;
                    }
                }
                while (true) {
                    if (findIdx != -1) { // 찾았다
                        Scanner sc = new Scanner(System.in);
                        System.out.println("회원 정보를 정말로 삭제하시겠습니까? (Y/N)");
                        String ans = sc.nextLine();
                        if (ans.equals("Y") || ans.equals("y")) {
                            users.remove(findIdx); // 수정할 회원 정보 삭제
                            System.out.println("회원 정보가 삭제되었습니다.");
                            break;
                        } else if (ans.equals("N") || ans.equals("n")) {
                            System.out.println("회원 삭제가 취소되었습니다.");
                            break;
                        } else {
                            System.out.println("Y/N 중에서 입력해주세요!");
                        }
                    } else { // 못찾았다
                        System.out.println("삭제할 회원 정보가 없습니다!");
                        break;
                    }
                }
            }
        }
    }
}