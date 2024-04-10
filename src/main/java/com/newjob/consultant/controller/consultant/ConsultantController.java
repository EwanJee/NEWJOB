package com.newjob.consultant.controller.consultant;

import com.newjob.consultant.entity.consultant.dto.ConsultantForm;
import com.newjob.consultant.entity.consultant.dto.ConsultantLoginForm;
import com.newjob.consultant.entity.consultant.Consultant;
import com.newjob.consultant.service.consultant.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultant")
public class ConsultantController {
    private final ConsultantService consultantService;
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("signupForm",new ConsultantForm());
        model.addAttribute("loginForm",new ConsultantLoginForm());
        return "consultant/login";
    }
    @PostMapping("/signup")
    public String signUp(ConsultantForm consultantForm){
        consultantService.join(consultantForm);
        return "redirect:/consultant/login";
    }
    @PostMapping("/welcome")
    public String postLogin(ConsultantLoginForm consultantLoginForm, Model model){
        Consultant consultant = consultantService.findByEmailAndPassword(consultantLoginForm.getEmail(), consultantLoginForm.getPassword());
        model.addAttribute("consultant",consultant);
        return "consultant/welcome";
    }
    @GetMapping("{id}/welcome")
    public String welcome(@PathVariable("id")Long id, Model model){
        Optional<Consultant> consultant = consultantService.findById(id);
        Consultant c = consultant.orElse(null);
        model.addAttribute("consultant",c);
        return "consultant/welcome";
    }

    @GetMapping("/{id}/mypage")
    public String myPage(@PathVariable("id")Long id, Model model){
        Optional<Consultant> consultant = consultantService.findById(id);
        Consultant c = consultant.orElse(null);
        model.addAttribute("consultant",c);
        return "consultant/mypage";
    }
    @GetMapping("/{id}/client")
    public String myClientList(@PathVariable("id")Long id, Model model){
        Consultant consultant = consultantService.findById(id).orElse(null);
        /*model.addAttribute("careerTest",
                consultantService.getCareerList());*/
        model.addAttribute("careerTest",consultantService.getCList(id));
        //consultantService.findCareerTestResultList(id);
        /*model.addAttribute("mrAndersonTest",
                consultantService.getMrAndersonList());*/
        model.addAttribute("mrAndersonTest",consultantService.getMList(id));
        //consultantService.findMrAndersonTestResultList(id);
        model.addAttribute("id",id);
        return "consultant/clientList";
    }
}
