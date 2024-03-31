package org.cris6h16.Spring_Security_Filters.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Principal {

    @GetMapping("/principal")
    @ResponseBody
    public String principal() {
        return "principal";
    }
}
