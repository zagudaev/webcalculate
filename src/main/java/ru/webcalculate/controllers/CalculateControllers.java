package ru.webcalculate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.webcalculate.model.Calculate;
import ru.webcalculate.repositories.CalculateRepositories;
import org.mariuszgromada.math.mxparser.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class CalculateControllers {
    @Autowired
    private CalculateRepositories calculateRepositories;



    @RequestMapping(path = "/calculete", method = RequestMethod.GET)
    public ModelAndView get(@CookieValue("user_cookie"б) String user_cookie,HttpServletResponse response) {
        List<Calculate> calculates = null;
        ModelAndView modelAndView = new ModelAndView("calculates");
        if (user_cookie != null) {
            calculates = calculateRepositories.findAllByUser_cookie(user_cookie);
            modelAndView.addObject("calculateFromServer", calculates);
        } else {
            Date date = new Date();
            Cookie newCookieUser = new Cookie("user_cookie", date.toString() );
            response.addCookie(newCookieUser);
            modelAndView.addObject("calculateFromServer", calculates);
        }


        return modelAndView;

    }
   /* @RequestMapping(path = "/calculete")
    public String setCookie(HttpServletResponse response) {

        Date date = new Date();
        Cookie newCookieUser = new Cookie("user_cookie", date.toString() );

        response.addCookie(newCookieUser);

        return "redirect:/calculete";

    }*/


    @RequestMapping(path = "/calculete", method = RequestMethod.POST)

    public String getResult(String example, @CookieValue("user_cookie") String user_cookie) {
      Expression e = new Expression(example);

      String result = mXparser.numberToAsciiString(e.calculate());
      Calculate calculate = new Calculate();
      calculateRepositories.save(calculate);
      return "redirect:/calculete";

    }

}




