package com.seoul_wifi_service.controller;

import com.seoul_wifi_service.service.WifiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WifiLoadController {
    private final WifiService wifiService;

    @GetMapping("/load/waiting")
    public String loadWaiting(){
        return "wifi/load-wifi-waiting";
    }

    @GetMapping("/load/success")
    public String loadSuccess(Model model){
        int amount = 0;

        try {
            amount = wifiService.loadAllWifiOnDB();
        } catch (IOException e) {
            log.info("load fail!!!", e);
            e.printStackTrace();
        }
        log.info("load success!!!");
        model.addAttribute("amount", amount);

        return "wifi/load-success";
    }
}
