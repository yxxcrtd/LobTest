package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Lob;
import org.example.service.LobService;
import org.example.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

import static org.example.util.JsonResult.jsonResult;

/**
 * Lob Controller
 */
@Slf4j
@RestController
public class LobController {

    @Autowired
    private LobService lobService;

    /**
     * List
     */
    @GetMapping("")
    ModelAndView list(HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", lobService.findAll());
        mav.setViewName("LobList");
        return mav;
    }

    /**
     * Edit
     */
    @GetMapping("add")
    ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("obj", new Lob());
        mav.setViewName("LobEdit");
        return mav;
    }

    /**
     * Save
     */
    @PostMapping("save")
    ModelAndView save(@ModelAttribute("lob") @Valid Lob lob, @RequestParam(value = "blobFile", required = false) MultipartFile blobFile) throws IOException {
        lob.setBlob(blobFile.getBytes());
        lobService.save(lob);
        return new ModelAndView("redirect:/");
    }

    /**
     * FindById
     */
    @GetMapping("findById/{id}")
    JsonResult findById(@PathVariable(value = "id") Long id) {
        return jsonResult("SUCCESS", lobService.findById(id).getBlob());
    }

}
