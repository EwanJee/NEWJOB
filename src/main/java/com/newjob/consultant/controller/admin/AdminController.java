package com.newjob.consultant.controller.admin;

import com.newjob.consultant.entity.admin.dto.AdminForm;
import com.newjob.consultant.entity.consultant.dto.ConsultantForm;
import com.newjob.consultant.entity.consultant.Consultant;
import com.newjob.consultant.service.admin.AdminService;
import com.newjob.consultant.service.consultant.ConsultantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final ConsultantService consultantService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("admin", new AdminForm());
        return "admin/adminLogin";
    }

    @PostMapping("/admin")
    public String isAdmin(@ModelAttribute("admin") AdminForm adminForm, Model model) {
        if (adminService.isAdmin(adminForm.getId())) {
            List<Consultant> consultantList = consultantService.findAll();
            model.addAttribute("consultantList", consultantList);
            return "admin/consultantList";
        } else {
            return "redirect:/admin";
        }
    }

    @GetMapping("/admin/list")
    public String consultantList(Model model) {
        List<Consultant> consultantList = consultantService.findAll();
        model.addAttribute("consultantList", consultantList);
        return "admin/consultantList";
    }

    @GetMapping("/admin/list/{id}/edit")
    public String editConsultant(@PathVariable("id") Long id, Model model) {
        model.addAttribute("consultant", consultantService.findById(id));
        return "admin/updateConsultantForm";
    }

    @PostMapping("/admin/list/{id}/edit")
    public String editedConsultant(@PathVariable("id") Long id, @ModelAttribute("consultantForm") ConsultantForm consultantForm) {
        adminService.updateForm(id, consultantForm.getNumberOfAvailableMrAndersonTests(), consultantForm.getNumberOfAvailableCareerTests(), consultantForm.getIsApproved());
        return "redirect:/admin/list";
    }

    @GetMapping("/admin/list/{id}/delete")
    public String deletedConsultant(@PathVariable("id") Long id) {
        adminService.deleteForm(id);
        return "redirect:/admin/list";
    }
}