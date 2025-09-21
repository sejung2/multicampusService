package kr.seing.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/product/productForm")
    public String productForm() {
        return "product/productForm";
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

}
