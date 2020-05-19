package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Clrvn
 */
@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("USER");
        session.invalidate();
        session.getServletContext().removeAttribute(session.getId());
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpSession session, Model model) {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    /**
     * 用户管理
     */
    @GetMapping("/userManage")
    public String userManage() {
        return "userManage";
    }

    @GetMapping("/userAdd")
    public String userAdd() {
        return "userAdd";
    }

    @GetMapping("/userEdit")
    public String userEdit() {
        return "userEdit";
    }

    @GetMapping("/userView")
    public String userView() {
        return "userView";
    }

    @GetMapping("/editMine")
    public String editMine() {
        return "editMine";
    }

    @GetMapping("/editPassword")
    public String editPassword() {
        return "editPassword";
    }

    @GetMapping("/loginLogManage")
    public String loginLogManage() {
        return "loginLogManage";
    }

    /**
     * 消费分析
     */
    @GetMapping("/studentAnalysis")
    public String studentAnalysis() {
        return "studentAnalysis";
    }

    @GetMapping("/canteenAnalysis")
    public String canteenAnalysis() {
        return "canteenAnalysis";
    }


}
