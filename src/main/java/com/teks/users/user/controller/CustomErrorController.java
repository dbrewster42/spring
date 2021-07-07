//package com.teks.users.user.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//public class CustomErrorController implements ErrorController {
//    private static final String ERROR_PATH = "/error";
//    private static final String ERROR_TEMPLATE = "customError";
//
//    private final ErrorAttributes errorAttributes;
//
//    @Autowired
//    public CustomErrorController(ErrorAttributes errorAttributes){
//        this.errorAttributes = errorAttributes;
//    }
//
//    @RequestMapping(ERROR_PATH)
//    public String error(Model model, HttpServletRequest request){
//        Map<String, Object> error = getErrorAttributes(request, true);
//
//        model.addAttribute("status", error.get("status"));
//        model.addAttribute("error", error.get("error"));
//        model.addAttribute("message", error.get("message"));
//        model.addAttribute("path", error.get("path"));
//
//        return ERROR_TEMPLATE;
//    }
//}
