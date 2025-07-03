package com.example.demo.controller;

import com.example.demo.entity.National;
import com.example.demo.repository.NationalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nationals")
public class NationalController {

    private final NationalRepository nationalRepository;

    public NationalController(NationalRepository nationalRepository) {
        this.nationalRepository = nationalRepository;
    }

    // Hiển thị tất cả quốc tịch
    @GetMapping()
    public String getAllNationals(Model model) {
        List<National> list = nationalRepository.findAll();
        model.addAttribute("nationals", list);
        model.addAttribute("content", "nationals/list");
        return "layout/main";
    }

    // Form tạo mới quốc tịch
    @GetMapping("create")
    public String formCreate(Model model) {
        model.addAttribute("national", new National());
        model.addAttribute("content", "nationals/create_form");
        return "layout/main";
    }

    // Xử lý tạo mới quốc tịch
    @PostMapping("create")
    public String createNational(@ModelAttribute National national) {
        nationalRepository.save(national);
        return "redirect:/nationals";
    }

    // Form chỉnh sửa quốc tịch
    @GetMapping("edit/{id}")
    public String editNational(@PathVariable Long id, Model model) {
        National n = nationalRepository.findById(id).orElseThrow();
        model.addAttribute("national", n);
        model.addAttribute("content", "nationals/edit_form");
        return "layout/main";
    }

    // Xử lý cập nhật quốc tịch
    @PostMapping("edit")
    public String updateNational(@ModelAttribute National national) {
        nationalRepository.save(national);
        return "redirect:/nationals";
    }

    // Xoá quốc tịch
    @GetMapping("delete/{id}")
    public String deleteNational(@PathVariable Long id) {
        National n = nationalRepository.findById(id).orElseThrow();
        nationalRepository.delete(n);
        return "redirect:/nationals";
    }
}
