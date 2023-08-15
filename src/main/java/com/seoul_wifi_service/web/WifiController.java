package com.seoul_wifi_service.web;

import com.seoul_wifi_service.domain.BookmarkGroup;
import com.seoul_wifi_service.dto.LocationDTO;
import com.seoul_wifi_service.dto.WifiDTO;
import com.seoul_wifi_service.service.BookmarkGroupService;
import com.seoul_wifi_service.service.BookmarkService;
import com.seoul_wifi_service.service.HistoryService;
import com.seoul_wifi_service.service.WifiService;
import com.seoul_wifi_service.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WifiController {

    private final WifiService wifiService;
    private final HistoryService historyService;
    private final BookmarkService bookmarkService;
    private final BookmarkGroupService bookmarkGroupService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("loc", new LocationDTO());
        return "index.html";
    }

    @GetMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "0.0") String lat,
                       @RequestParam(required = false, defaultValue = "0.0") String lnt,
                       Model model) {
        List<WifiDTO> wifiList = wifiService.selectTop20Wifi(new LocationDTO(lat, lnt));

        model.addAttribute("loc", new LocationDTO(lat, lnt));
        model.addAttribute("wifiList", wifiList);
        return "list.html";
    }

    @PostMapping("/list")
    public String list(@ModelAttribute LocationDTO loc,
                       HttpServletRequest request,
                       RedirectAttributes redirectAttributes) {
        log.info("session saved lat:{} , lnt:{}", loc.getLat(), loc.getLnt());
        historyService.save(loc);

        //위치 세션
        setLocationSession(loc, request);

        redirectAttributes.addAttribute("lat", loc.getLat());
        redirectAttributes.addAttribute("lnt", loc.getLnt());
        return "redirect:/list";
    }

    @GetMapping("/detail/{manageNumber}")
    public String detail(@PathVariable String manageNumber,
                         @SessionAttribute(name = SessionConst.LOCATION, required = false) LocationDTO loc,
                         Model model) {
        WifiDTO find = wifiService.findByManageNumberWithLocation(manageNumber, loc);
        List<BookmarkGroup> bookmarkGroupList = bookmarkGroupService.findAll();

        model.addAttribute("wifi", find);
        model.addAttribute("bookmarkGroupList", bookmarkGroupList);
        return "wifi/detail";
    }

    @PostMapping("/detail/{manageNumber}")
    public String addBookmark(@PathVariable String manageNumber,
                              @SessionAttribute(name = SessionConst.LOCATION, required = false) LocationDTO loc,
                              @RequestParam String select,
                              RedirectAttributes redirectAttributes) {

        bookmarkService.save(manageNumber, select);
        redirectAttributes.addAttribute("manageNumber", manageNumber);
        return "redirect:/detail/{manageNumber}";
    }

    private void setLocationSession(LocationDTO loc, HttpServletRequest request) {
        HttpSession session = request.getSession();//세션이 있으면 있는 세션 반환, 없으면 신규세션 생성
        session.setAttribute(SessionConst.LOCATION, loc);
        log.info("session saved lat:{} , lnt:{}", loc.getLat(), loc.getLnt());
    }


}
