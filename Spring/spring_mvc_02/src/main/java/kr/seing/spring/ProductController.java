package kr.seing.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ProductController {

    @RequestMapping("/product/productForm")
    public String productForm() {
        return "product/productForm";
    }

    @RequestMapping("/product/productForm3")
    public String productForm3() {
        return "product/productForm3";
    }

    @RequestMapping("/product/productForm4")
    public String productForm4() {
        return "product/productForm4";
    }

    @RequestMapping("/product/productSearchForm")
    public String productSearch() {
        return "product/productSearchForm";
    }

    @RequestMapping("/product/newProduct")
    public String showResult(String prdNo, String prdName, String prdPrice, String prdCompany, String prdDate, String prdStock, Model model) {

        model.addAttribute("prdNo", prdNo);
        model.addAttribute("prdName", prdName);
        model.addAttribute("prdPrice", prdPrice);
        model.addAttribute("prdCompany", prdCompany);
        model.addAttribute("prdDate", prdDate);
        model.addAttribute("prdStock", prdStock);

        return "product/productResult";
    }

    @RequestMapping("/product/newProduct3")
    public String showResult3(Product product) {
        return "product/productResult3";
    }

    @RequestMapping("/product/newProduct4")
    public String showResult4(@ModelAttribute("productInfo") Product product) {
        return "product/productResult4";
    }

    @RequestMapping("product/productDetailView/{prdName}")
    public String productDetailView(@PathVariable String prdName) {
        System.out.println("제품 상세보기, 품명: " + prdName);
        return "product/productResult";
    }

    @RequestMapping("product/productDetailView/{prdName}/{prdStock}/{prdNo}")
    public String productDetailView1(@PathVariable String prdName, @PathVariable String prdStock, @PathVariable String prdNo) {
        System.out.println("제품 상세보기, 품명: " + prdName);
        System.out.println("제품 상세보기, 재고: " + prdStock);
        System.out.println("제품 상세보기, 품번: " + prdNo);
        return "product/productResult";
    }

    @RequestMapping("/project/product/productSearch")
    public String productSearch(@RequestParam HashMap<String, Object> param, Model model) {
        System.out.println(param.get("type"));
        System.out.println(param.get("keyword"));

        Product product1 = new Product();
        product1.setPrdNo("P001");
        product1.setPrdName("삼성 노트북");
        product1.setPrdPrice("1500000");
        product1.setPrdMaker("삼성전자");

        Product product2 = new Product();
        product2.setPrdNo("P002");
        product2.setPrdName("삼성 모니터");
        product2.setPrdPrice("300000");
        product2.setPrdMaker("삼성전자");

        ArrayList<Product> prdList = new ArrayList<>();
        prdList.add(product1);
        prdList.add(product2);

        model.addAttribute("prdList", prdList);
        return "product/productSearchResult";

    }
}
