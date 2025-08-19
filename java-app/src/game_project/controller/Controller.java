package game_project.controller;

import game_project.model.MemberDAO;
import game_project.model.MemberDTO;
import game_project.view.MemberListView;
import game_project.view.ResultView;

import java.util.List;
import java.util.Vector;

// View 별로 컨트롤러를 구성해서 사용하면 DAO 접근통로가 많아져
// db 사용제어가 불가능함
// Singleton 으로 구성: 하나의 객체만 생성 - 공유해서 사용
public class Controller {
    // 본인 객체 인스턴스를 본인이 제공 - private static으로 객체 구성
    private static Controller instance = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }

    // 데이터 처리 method
    MemberDAO dao = new MemberDAO(); //MemberDAO가 갖고 있는 모든 메소드 사용 가능

    public void insert(MemberDTO newDto) {
        // dao의 insert 호출
        try {
            MemberDTO dto = new MemberDTO();
            dto.setMemNo(newDto.getMemNo());
            dto.setMemId(newDto.getMemId());
            dto.setMemPass(newDto.getMemPass());
            dto.setMemName(newDto.getMemName());

            if (dao.insert(dto)) {
                ResultView.succMsg("도서 정보가 등록되었습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.succMsg("도서 정보 등록 오류: ");
        }
    }

    public void getAllMember() {
        try {
            List<MemberDTO> dataSet = dao.getAllMember();

            if (dataSet.size() >= 0) { // 데이터 존재 시
                MemberListView.showAllMember(dataSet);
            } else {
                ResultView.succMsg("검색 결과가 없습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("잠시후에 재요청 바랍니다");
        }
    }

    public void update(MemberDTO newDto) {
        try {
            MemberDTO dto = new MemberDTO();
            dto.setMemNo(newDto.getMemNo());
            dto.setMemId(newDto.getMemId());
            dto.setMemPass(newDto.getMemPass());
            dto.setMemName(newDto.getMemName());

            if (dao.update(dto)) {
                ResultView.succMsg("회원 정보가 수정되었습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.succMsg("회원 정보 수정 오류: ");
        }
    }

    public void delete(String MemberNo) {
        try {
            MemberDTO dto = new MemberDTO();
            dto.setMemNo(MemberNo);

            if (dao.delete(dto)) {
                ResultView.succMsg(MemberNo + " 도서를 삭제하였습니다. 결과는 도서정보 조회에서 확인");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultView.errorMsg("도서 정보 삭제 오류");
        }
    }
}
