package comuser.shop.jinproject.Controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class webController {
    @GetMapping("/")
    public String MainPage(){
        return "index";
    }
    @GetMapping("index.html")
    public String IndexPage(){
        return "index";
    }
}
