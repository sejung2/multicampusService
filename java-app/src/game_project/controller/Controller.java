package game_project.controller;

import game_project.model.MemberDAO;
import game_project.model.MemberDTO;
import game_project.view.MemberListView;
import game_project.view.ResultView;

import java.util.List;

public class Controller {
    private static Controller instance = new Controller();
    private MemberDAO dao = new MemberDAO();

    private Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }

    // 회원가입
    public void insert(String memId, String memPass) {
        try {
            if (dao.insert(memId, memPass)) {
                ResultView.succMsg("회원가입이 완료되었습니다");
            } else {
                ResultView.errorMsg("회원가입에 실패했습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("회원가입 처리 중 오류가 발생했습니다");
        }
    }

    // 로그인
    public boolean login(String memId, String memPass) {
        try {
            if (dao.login(memId, memPass)) {
                ResultView.succMsg("로그인 성공!");
                return true;
            } else {
                ResultView.errorMsg("아이디 또는 비밀번호가 잘못되었습니다");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("로그인 처리 중 오류가 발생했습니다");
            return false;
        }
    }

    // 전체 회원 조회
    public void getAllMember() {
        try {
            List<MemberDTO> dataSet = dao.getAllMember();

            if (dataSet != null && dataSet.size() > 0) {
                MemberListView.showAllMember(dataSet);
            } else {
                ResultView.succMsg("등록된 회원이 없습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("회원 조회 중 오류가 발생했습니다");
        }
    }

    // 비밀번호 변경
    public void updatePassword(String memId, String newPassword) {
        try {
            if (dao.updateById(memId, newPassword)) {
                ResultView.succMsg("비밀번호가 변경되었습니다");
            } else {
                ResultView.errorMsg("비밀번호 변경에 실패했습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("비밀번호 변경 중 오류가 발생했습니다");
        }
    }

    // 회원 탈퇴
    public void deleteMember(String memId) {
        try {
            if (dao.deleteById(memId)) {
                ResultView.succMsg("회원탈퇴가 완료되었습니다");
            } else {
                ResultView.errorMsg("회원탈퇴에 실패했습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("회원탈퇴 처리 중 오류가 발생했습니다");
        }
    }

    // 회원 정보 조회
    public void getMemberInfo(String memId) {
        try {
            MemberDTO member = dao.selectById(memId);
            if (member != null) {
                ResultView.succMsg("회원번호: " + member.getMemNo() +
                        ", 아이디: " + member.getMemId());
            } else {
                ResultView.errorMsg("해당 회원을 찾을 수 없습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("회원 정보 조회 중 오류가 발생했습니다");
        }
    }
}