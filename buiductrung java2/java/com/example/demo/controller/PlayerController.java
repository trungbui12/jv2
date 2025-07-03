package com.example.demo.controller;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.NationalRepository;
import com.example.demo.entity.National;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final NationalRepository nationalRepository;

    public PlayerController(PlayerRepository playerRepository, NationalRepository nationalRepository) {
        this.playerRepository = playerRepository;
        this.nationalRepository = nationalRepository;
    }

    // Hiển thị tất cả người chơi
    @GetMapping()
    public String getAllPlayers(Model model) {
        List<Player> list = playerRepository.findAll();
        model.addAttribute("players", list);
        model.addAttribute("content", "players/list");
        return "layout/main";
    }

    // Form tạo mới người chơi
    @GetMapping("create")
    public String formCreate(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("nationals", nationalRepository.findAll());
        model.addAttribute("content", "players/create_form");
        return "layout/main";
    }

    // Xử lý tạo mới người chơi
    @PostMapping("create")
    public String createPlayer(@ModelAttribute Player player) {
        playerRepository.save(player);
        return "redirect:/players";
    }

    // Form chỉnh sửa người chơi
    @GetMapping("edit/{id}")
    public String editPlayer(@PathVariable Long id, Model model) {
        Player player = playerRepository.findById(id).orElseThrow();
        model.addAttribute("player", player);
        model.addAttribute("nationals", nationalRepository.findAll());
        model.addAttribute("content", "players/edit_form");
        return "layout/main";
    }

    // Xử lý cập nhật người chơi
    @PostMapping("edit")
    public String updatePlayer(@ModelAttribute Player player) {
        playerRepository.save(player);
        return "redirect:/players";
    }

    // Xóa người chơi
    @GetMapping("delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        Player player = playerRepository.findById(id).orElseThrow();
        playerRepository.delete(player);
        return "redirect:/players";
    }
    @GetMapping("/search")
    public String searchPlayer(@RequestParam("keyword") String keyword, Model model) {
        List<Player> list = playerRepository.findByPlayerNameContainingIgnoreCase(keyword);
        model.addAttribute("players", list);
        model.addAttribute("content", "players/list");
        return "layout/main";
    }
    @GetMapping("/top10")
    public String displayTop10(Model model) {
        List<Player> list = playerRepository.findTop10ByOrderByHighScoreDesc();
        model.addAttribute("players", list);
        model.addAttribute("content", "players/list");
        return "layout/main";
    }

}
