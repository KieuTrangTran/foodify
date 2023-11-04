package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    //@GetMapping(path = "/")
    //public ModelAndView showHelloWorldPage() {
      //  return new ModelAndView("helloworld");
    //}

   /* // Nur als Notiz aus der Vorlesung
    @GetMapping(path = "/path2")
    public String index2() {
        return ("Greeting from webtech2");
    }

    @GetMapping(path = "/user/{userid}")
    public String nameEgal(@PathVariable int userid) {
        return "Greetings from webtech, " +userid + "!";
    }

    @GetMapping(path = "/user/{userid}/password/{password}")
    public String nameEgal2(@PathVariable int userid, @PathVariable String password) {
        return "Greetings from webtech, " +userid + "! Dein Passwort lautet: " + password;
    }

    @GetMapping(path = "/user")
    public String nameEgal3(@RequestParam int userid, @RequestParam String password) {
        return "Greetings from webtech, " +userid + "! Dein Passwort lautet: " + password;
        //LINK.com/user?password=password&userid=42
    }

    //Immer neustarten bei Änderungen, wenn man im Browser testen will */
}
