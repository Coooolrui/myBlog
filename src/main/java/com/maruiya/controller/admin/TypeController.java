package com.maruiya.controller.admin;

import com.maruiya.pojo.Tag;
import com.maruiya.pojo.Type;
import com.maruiya.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author MaRuiYa
 */
@Controller
@RequestMapping("/admin123")
public class TypeController {

    @Autowired
    TypeService typeService;

    @PostMapping("/addType")
    public String addType(Type type){
        System.out.println("这是type的id："+type.getId());
        if (type.getId() == null){
            typeService.addType(type);
        }else {
            typeService.updateType(type);
        }
        return "redirect:/admin123/typeList";
    }

    @GetMapping("/type/{id}/update")
    public String update(@PathVariable int id, Model model){
        Type type = typeService.queryTypeById(id);
        model.addAttribute("type", type);
        return "admin/type-input";
    }

    @GetMapping("/type/{id}/delete")
    public String delete(@PathVariable int id){
        typeService.deleteType(id);
        return "redirect:/admin123/typeList";
    }


}
