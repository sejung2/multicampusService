package game_project.start;

import game_project.view.*;
import game_project.controller.Controller;
import game_project.game.GaBaBo;
import game_project.game.Guess;
import game_project.info.AppInfo;

import java.util.*;

public class Start {
    private boolean isLoggedIn;
    private Scanner sc;

    private Controller controller = Controller.getInstance();

    private MemberInsertView insertView = new MemberInsertView();
    private MemberUpdateView updateView = new MemberUpdateView();
    private MemberDeleteView deleteView = new MemberDeleteView();
    private MemberListView listView = new MemberListView();

    public Start() {
        isLoggedIn = false;
        sc = new Scanner(System.in);
    }

    public void run() {
        AppInfo appInfo = new AppInfo();
        GaBaBo gaBaBo = new GaBaBo();
        Guess guess = new Guess();

        System.out.println("*********************************");
        System.out.println("  Welcome to the Game Project!");
        System.out.println("**********************************");

        while (true) {
            showMenu();
            System.out.print("메뉴 번호 입력: ");

            try {
                int inputMenu = sc.nextInt();
                sc.nextLine();
                System.out.println("***********************************");

                switch (inputMenu) {
                    case 1 -> System.out.println(appInfo);
                    case 2 -> {
                        if (!isLoggedIn) {
                            System.out.println("로그인이 필요합니다. 먼저 로그인해주세요.");
                            break;
                        }
                        gaBaBo.startGame();
                    }
                    case 3 -> {
                        if (!isLoggedIn) {
                            System.out.println("로그인이 필요합니다. 먼저 로그인해주세요.");
                            break;
                        }
                        guess.startGame();
                    }
                    case 4 -> {
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return;
                    }
                    case 5 -> {
                        if (isLoggedIn) {
                            System.out.println("이미 로그인되어 있습니다.");
                            break;
                        }
                        isLoggedIn = login();
                    }
                    case 6 -> insertView.insert(sc);
                    case 7 -> listView.getAllMember();
                    case 8 -> updateView.updatePassword(sc);
                    case 9 -> deleteView.deleteMember(sc);
                    default -> System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    private void showMenu() {
        System.out.println("       메뉴       ");
        System.out.println("--------------------------------");
        System.out.println("1. 애플리케이션 정보");
        System.out.println("2. 가위 바위 보 게임");
        System.out.println("3. 숫자 맞추기 게임");
        System.out.println("4. 종료");
        System.out.println("5. 로그인");
        System.out.println("6. 회원가입");
        System.out.println("7. 회원 목록 조회");
        System.out.println("8. 비밀번호 변경");
        System.out.println("9. 회원 탈퇴");
        System.out.println("--------------------------------");
    }

    private boolean login() {
        System.out.println("\n*******************************");
        System.out.println("로그인");
        System.out.println("*********************************");
        System.out.print("아이디: ");
        String id = sc.nextLine();
        System.out.print("비밀번호: ");
        String pass = sc.nextLine();

        return controller.login(id, pass);
    }
}