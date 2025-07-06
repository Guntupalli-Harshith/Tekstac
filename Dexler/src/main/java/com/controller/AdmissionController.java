package com.controller;

import com.model.Admission;
import com.service.AdmissionService;
import com.validate.CustomValidator;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private CustomValidator custValidator;

    @RequestMapping(value = "/showPage", method = RequestMethod.GET)
    public String showPage(@ModelAttribute("admission") Admission admission) {
        return "showPage";
    }

    @ModelAttribute("programNames")
    public ArrayList<String> populateAvailablePrograms() {
        ArrayList<String> programs = new ArrayList<>();
        programs.add("Play Group");
        programs.add("Nursery");
        programs.add("Euro Junior");
        programs.add("Euro Senior");
        return programs;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPreschooler(@Valid @ModelAttribute("admission") Admission admission,
                                      BindingResult result, ModelMap model) {
        custValidator.validate(admission, result);

        if (result.hasErrors()) {
            return "showPage";
        }

        double fee = admissionService.calculateProgramFee(admission);
        model.addAttribute("message", "Preschool registration successful for " +
                admission.getChildName() + ", Program Fees: " + fee);
        return "success";
    }
}