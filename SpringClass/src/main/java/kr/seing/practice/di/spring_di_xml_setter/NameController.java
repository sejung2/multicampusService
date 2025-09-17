package kr.seing.practice.di.spring_di_xml_setter;


public class NameController {
    private NameService nameService;

    public NameController() {
    }

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController : " + nameService.showName(name));
    }

    public void setNameService(NameService nameService) {
        //etter의 파라미터를 통해서 NameService 객체 인스턴스 전달받음
        this.nameService = nameService;
    }
}
