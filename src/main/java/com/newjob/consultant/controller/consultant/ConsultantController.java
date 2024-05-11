package com.newjob.consultant.controller.consultant;

import com.newjob.consultant.controller.consultant.dto.ConsultantForm;
import com.newjob.consultant.controller.consultant.dto.ConsultantLoginForm;
import com.newjob.consultant.service.consultant.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultant")
public class ConsultantController {
    private final ConsultantService consultantService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("signupForm", new ConsultantForm());
        model.addAttribute("loginForm", new ConsultantLoginForm());
        return "consultant/login";
    }

    @PostMapping("/signup")
    public String signUp(ConsultantForm consultantForm) {
        consultantService.join(consultantForm);
        return "redirect:/consultant/login";
    }

    @PostMapping("/welcome")
    public String postLogin(ConsultantLoginForm consultantLoginForm, Model model) {
        model.addAttribute("consultant", consultantService.findByEmailAndPassword(consultantLoginForm.getEmail(), consultantLoginForm.getPassword()));
        return "consultant/welcome";
    }

    @GetMapping("{id}/welcome")
    public String welcome(@PathVariable("id") Long id, Model model) {
        model.addAttribute("consultant", consultantService.findById(id));
        return "consultant/welcome";
    }

    @GetMapping("/{id}/mypage")
    public String myPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("consultant", consultantService.findById(id));
        return "consultant/mypage";
    }

    @GetMapping("/{id}/client")
    public String myClientList(@PathVariable("id") Long id, Model model) {
        model.addAttribute("careerTest", consultantService.getCList(id));
        model.addAttribute("mrAndersonTest", consultantService.getMList(id));
        model.addAttribute("id", id);
        return "consultant/clientList";
    }
}
