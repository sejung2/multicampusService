package game_project.start;

import game_project.model.IMemberDAO;
import game_project.model.MemberDAO;
import game_project.model.MemberDTO;
import game_project.game.GaBaBo;
import game_project.game.Guess;
import game_project.info.AppInfo;

import java.util.*;

public class Start {

    private boolean isLoggedIn; // 로그인 상태를 나타내는 변수

    public void Start() {
        isLoggedIn = false; // 초기 로그인 상태는 false로 설정
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        // 게임 시작을 위한 객체 생성
        AppInfo appInfo = new AppInfo();
        GaBaBo gaBaBo = new GaBaBo();
        Guess guess = new Guess();
        // 로그인 관련 기능
        IMemberDAO member = new MemberDAO(); // MemberDAO 인터페이스를 구현한 객체 생성

        System.out.println("*********************************");
        System.out.println("  Welcome to the Game Project!");
        System.out.println("**********************************");
        while (true) {
            System.out.println("       메뉴       ");
            System.out.println("--------------------------------");
            System.out.println("1. 애플리케이션 정보");
            System.out.println("2. 가위 바위 보 게임");
            System.out.println("3. 숫자 맞추기 게임");
            System.out.println("4. 종료");
            System.out.println("5. 로그인");
            System.out.println("6. 회원가입");
            System.out.println("--------------------------------");
            System.out.print("메뉴 번호 입력: ");
            try { // try catch를 사용하여 예외 처리
                int inputMenu = sc.nextInt(); // 사용자로부터 메뉴 번호 입력 받기
                System.out.println("***********************************");
                switch (inputMenu) {
                    case 1 -> System.out.println(appInfo); // 애플리케이션 정보 출력
                    case 2 -> {
                        if (!isLoggedIn) { // 로그인 상태가 아니면 게임을 시작할 수 없음
                            System.out.println("로그인이 필요합니다. 먼저 로그인해주세요.");
                            break;
                        }
                        gaBaBo.startGame();
                    }
                    case 3 -> {
                        if (!isLoggedIn) { // 로그인 상태가 아니면 게임을 시작할 수 없음
                            System.out.println("로그인이 필요합니다. 먼저 로그인해주세요.");
                            break;
                        }
                        guess.startGame(); // 숫자 맞추기 게임 시작
                    }
                    case 4 -> {
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return; // 프로그램 종료
                    }
                    case 5 -> {
                        if (isLoggedIn) {
                            System.out.println("이미 로그인되어 있습니다.");
                            break;
                        }
                        isLoggedIn = login(sc, member);
                    }
                    case 6 -> { // 회원가입 기능
                        register(sc, member);
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            } catch (InputMismatchException e) { // 입력된 값이 숫자가 아닐 때
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.next(); // 잘못된 입력을 제거
                continue; // 다시 메뉴를 출력
            }
        }
    }

    private void register(Scanner sc, IMemberDAO member) { // 회원가입 기능
        System.out.println("회원가입");
        System.out.println("아이디, 비밀번호, 이름을 입력해주세요.");
        System.out.print("아이디: ");
        String id = sc.next();
        System.out.print("비밀번호: ");
        String pass = sc.next();
        System.out.print("이름: ");
        String name = sc.next();
        // 회원가입 기능을 MemberDAO 클래스의 insertMember 메소드를 통해 호출
        member.insertMember(new MemberDTO(id, pass, name));
    }

    private boolean login(Scanner sc, IMemberDAO member) { // 로그인 기능
        System.out.println("로그인");
        System.out.println("아이디와 비밀번호를 입력해주세요.");
        System.out.print("아이디: ");
        String id = sc.next();
        System.out.print("비밀번호: ");
        String pass = sc.next();
        // 로그인 기능을 MemberDAO 클래스의 login 메소드를 통해 호출
        boolean login = member.login(id, pass);
        return login; // 로그인 성공 여부 반환
    }
}
