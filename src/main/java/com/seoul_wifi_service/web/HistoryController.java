package com.seoul_wifi_service.web;

import com.seoul_wifi_service.domain.History;
import com.seoul_wifi_service.service.HistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;
    @GetMapping("/history")
    public String history(Model model){
        List<History> historyList = historyService.findAll();
        model.addAttribute("historyList", historyList);
        return "history/history";
    }

    @PostMapping("/history/delete")
    public String deleteHistory(@RequestParam long id){
        historyService.delete(id);
        return "redirect:/history";
    }

}
