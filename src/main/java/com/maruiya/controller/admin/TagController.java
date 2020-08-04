package com.maruiya.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maruiya.pojo.Tag;
import com.maruiya.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Controller
@RequestMapping("/admin123")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("/addTag")
    public String addTag(Tag tag){
        if (tag.getId() == null){
            tagService.addTag(tag);
        }else {
            tagService.updateTag(tag);
        }
        return "redirect:/admin123/tagList";
    }

    @GetMapping("/tag/{id}/update")
    public String update(@PathVariable int id, Model model){
        Tag tag = tagService.queryTagById(id);
        model.addAttribute("tag", tag);
        return "admin/tag-input";
    }

    @GetMapping("/tag/{id}/delete")
    public String delete(@PathVariable int id){
        tagService.deleteTag(id);
        return "redirect:/admin123/tagList";
    }

}
