package kr.seing.practice.spring_di_xml_contructor;

public class NameController {
    NameService nameService;

    public void setNameService(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController : " + nameService.showName(name));
    }
}
