package com.newjob.consultant.controller;

import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.service.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultant")
public class ConsultantController {
    private final ConsultantService consultantService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("signupForm", new ConsultantForm());
        model.addAttribute("loginForm", new Login());
        return "consultant/login";
    }

    @PostMapping("/signup")
    public String signUp(ConsultantForm consultantForm) {
        Consultant consultant = new Consultant(consultantForm.getEmail(), consultantForm.getName(), consultantForm.getPhoneNumber(), consultantForm.getPassword(), consultantForm.getCompany());
        consultantService.join(consultant);
        return "redirect:/consultant/login";
    }

    @PostMapping("/welcome")
    public String postLogin(Login login, Model model) {
        Consultant consultant = consultantService.findByEmailAndPassword(login.getEmail(), login.getPassword());
        model.addAttribute("consultant", consultant);
        return "consultant/welcome";
    }

    @GetMapping("{id}/welcome")
    public String welcome(@PathVariable("id") Long id, Model model) {
        Consultant consultant = consultantService.findById(id);
        model.addAttribute("consultant", consultant);
        return "consultant/welcome";
    }

    @GetMapping("/{id}/mypage")
    public String myPage(@PathVariable("id") Long id, Model model) {
        Consultant consultant = consultantService.findById(id);
        model.addAttribute("consultant", consultant);
        return "consultant/mypage";
    }

    @GetMapping("/{id}/client")
    public String myClientList(@PathVariable("id") Long id, Model model) {
        /*model.addAttribute("careerTest",
                consultantService.getCareerList());*/
        model.addAttribute("careerTest", consultantService.getCList(id));
        //consultantService.findCareerTestResultList(id);
        /*model.addAttribute("mrAndersonTest",
                consultantService.getMrAndersonList());*/
        model.addAttribute("mrAndersonTest", consultantService.getMList(id));
        //consultantService.findMrAndersonTestResultList(id);
        model.addAttribute("id", id);
        return "consultant/clientList";
    }
}
