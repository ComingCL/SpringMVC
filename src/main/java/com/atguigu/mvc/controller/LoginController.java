package com.atguigu.mvc.controller;
import com.atguigu.mvc.dao.mapper.UserMapper;

import com.atguigu.mvc.dao.pojo.User;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    private int Start_ID = 0;

    public int getStart_ID() {
        return Start_ID;
    }

    public void setStart_ID(int start_ID) {
        Start_ID = start_ID;
    }

    @RequestMapping(value = {"/", "index"})
    public String index(){
        return "index";
    }
    @RequestMapping("/homepage")
    public String Home(){
        return "choose_list";
    }
    @RequestMapping("/loginpage")
    public String Login(){
        return "login";
    }
    @RequestMapping("/stock")
    public String stock(){ return "stock";}
    @RequestMapping("/accounting_management")
    public String accounting_management(){return "accounting_management";}
    @RequestMapping("/system_management")
    public String system_management(){return "system_management";}
    @RequestMapping("/login")
//    一般不用request获取, 因为springmvc已经获取过了
    /*通过控制器的形参获取请求参数, 保证名字一样即可, 如果出现同名, 可以在控制器方法的形参位置设置字符串类型或字符串数组接收此参数
     * 若使用字符串类型的形参, 最终结果为请求参数的每一个值之间使用逗号进行拼接*/
    public ModelAndView Get(
//            此处可重点关注RequestParam的用法
            @RequestParam(value = "username", required = false, defaultValue = "default")
                    String username,// 请求参数是username也可以
            String password, HttpServletRequest request) throws IOException {
//        System.out.println("username: " + username + "password: " + password);
        ModelAndView mav = new ModelAndView();

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin(username, password);
        System.out.println("111111111111");
        if(user != null){
            request.getSession().setAttribute("User", user);
            mav.setViewName("choose_list");
        }
        else mav.setViewName("error");
        return mav;
    }

    @RequestMapping("/register_check")
    public ModelAndView Register_check(String username, String password) throws IOException {
        ModelAndView mav = new ModelAndView();
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.checkUser(username);
        if(user != null){
//            用户名重复
            mav.setViewName("error");
        }else{
            int id = mapper.insertUser(username, password);
//        System.out.println("username: " + username + "password: " + password);
//        System.out.println(user);
            if(id == getStart_ID() + 1){
                mav.setViewName("success");
                setStart_ID(id);
            }else{
                mav.setViewName("error");
            }
        }
        return mav;
    }
    @RequestMapping("/register")
    public String Register(){
        return "register";
    }
    @RequestMapping("/forget")
    public String Forget(){
        return "forget";
    }
}
