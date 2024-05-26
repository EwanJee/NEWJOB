package com.newjob.consultant.controller.admin;

import com.newjob.consultant.controller.admin.dto.AdminForm;
import com.newjob.consultant.controller.consultant.dto.ConsultantForm;
import com.newjob.consultant.service.admin.AdminService;
import com.newjob.consultant.service.consultant.ConsultantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final ConsultantService consultantService;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("admin", new AdminForm());
        return "admin/adminLogin";
    }

    @PostMapping
    public String isAdmin(@ModelAttribute("admin") AdminForm adminForm, Model model) {
        if (adminService.isAdmin(adminForm.getId())) {
            model.addAttribute("consultantList", consultantService.findAll());
            return "admin/consultantList";
        } else {
            return "redirect:/admin";
        }
    }

    @GetMapping("/list")
    public String consultantList(Model model) {
        model.addAttribute("consultantList", consultantService.findAll());
        return "admin/consultantList";
    }

    @GetMapping("/list/{id}/edit")
    public String editConsultant(@PathVariable("id") Long id, Model model) {
        model.addAttribute("consultant", consultantService.findById(id));
        return "admin/updateConsultantForm";
    }

    @PostMapping("/list/{id}/edit")
    public String editedConsultant(@PathVariable("id") Long id, @ModelAttribute("consultantForm") ConsultantForm consultantForm) {
        consultantService.updateForm(id, consultantForm);
        return "redirect:/admin/list";
    }

    @GetMapping("/list/{id}/delete")
    public String deletedConsultant(@PathVariable("id") Long id) {
        consultantService.deleteForm(id);
        return "redirect:/admin/list";
    }
}
