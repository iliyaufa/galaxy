package com.exemple.galaxy.controller;

import com.exemple.galaxy.entity.Lord;
import com.exemple.galaxy.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static java.lang.Integer.parseInt;

@Controller
public class LordController {
    @Autowired
    private LordService lordService;
    @GetMapping
    public String main( Map<String,Object> model) {
        Iterable<Lord> lords = lordService.findAll();
         model.put("lords", lords);
        return "main";
    }
    @PostMapping
    public String addLord(@RequestParam String name,@RequestParam String age, Map<String,Object> model){
        if(name != null && name.isEmpty()){
            if (age != null && age.isEmpty()) {
                Lord lord = new Lord(name,parseInt(age));
                lordService.save(lord);

                Iterable<Lord> lords = lordService.findAll();
                model.put("lords", lords);
                return "main";
            }else return "main";
        }else return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String,Object> model){
        Iterable<Lord> lords;
        if(filter != null && !filter.isEmpty() ){
            lords = lordService.findByName(filter);
        }else {
            lords = lordService.findAll();
        }
        model.put("lords", lords);
        return "main";
    }
}
