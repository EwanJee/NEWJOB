package com.newjob.consultant.controller;

import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.service.CareerTestService;
import com.newjob.consultant.service.ConsultantService;
import com.newjob.consultant.service.DataMapper;
import com.newjob.consultant.service.PdfService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultant")
public class CareerTestController {
    private final ConsultantService consultantService;
    private final CareerTestService careerTestService;
    private final DataMapper dataMapper;
    private final SpringTemplateEngine springTemplateEngine;
    private final PdfService pdfService;
    @GetMapping("/{id}/test/career")
    public String linkCareer(@PathVariable("id")Long id, Model model){
        Optional<Consultant> optionalConsultant = consultantService.findById(id);
        Consultant consultant = optionalConsultant.orElse(null);
        CareerTestResult careerTestResult = new CareerTestResult();
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResult);
        if(!consultantService.isValid4Test(consultant)){
            return "careerTest/false";
        }
        else if(consultant.getNumberOfAvailableCareerTests()<=0){
            return "careerTest/invalid";
        }
        else{
            //횟수가 나타나게 바구기..
            return "careerTest/valid";
        }
    }
    @GetMapping("/{id}/test/career/result")
    @ResponseBody
    public CareerTestResultForm careerResult(@PathVariable("id") Long id, Model model, @ModelAttribute("form")CareerTestResultForm careerTestResultForm){
        return careerTestResultForm;
    }
    @GetMapping("/{id}/test/career/start")
    public String careerTestLocation(@PathVariable("id") Long id, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",new CareerTestResultForm());
        return "careerTest/careerStart";
    }
    @PostMapping("/{id}/test/career/location")
    public String careerTestStart(@PathVariable("id") Long id, @ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        CareerTestResult careerTestResult = new CareerTestResult(careerTestResultForm.getMemberName(), careerTestResultForm.getConsultantName(), careerTestResultForm.getOrganization(), careerTestResultForm.getConsultantCompany());
        careerTestService.join(careerTestResult);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("testId",careerTestResult.getId());
        return "careerTest/careerLocation";
    }
    @PostMapping("/{id}/test/career/{testId}/second")
    public String careerTestSecond(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateLocation(testId,careerTestResultForm.getCareerLocation());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("testId",testId);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/careerSecond";
    }
    @PostMapping("/{id}/test/career/{testId}/third")
    public String careerTestThird(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore1(testId,careerTestResultForm.getScore1(),careerTestResultForm.getScore2(),careerTestResultForm.getScore3(),careerTestResultForm.getScore4(),careerTestResultForm.getScore5(),careerTestResultForm.getScore6(),careerTestResultForm.getScore7(),careerTestResultForm.getScore8());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        System.out.println(careerTestResultForm.getCareerLocation());
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/careerThird";
    }
    @PostMapping("/{id}/test/career/{testId}/fourth")
    public String careerTestFourth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore2(testId,careerTestResultForm.getScore9(),careerTestResultForm.getScore10(),careerTestResultForm.getScore11(),careerTestResultForm.getScore12(),careerTestResultForm.getScore13(),careerTestResultForm.getScore14(),careerTestResultForm.getScore15(),careerTestResultForm.getScore16());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career4";
    }
    @PostMapping("/{id}/test/career/{testId}/fifth")
    public String careerTestFifth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore3(testId,careerTestResultForm.getScore17(),careerTestResultForm.getScore18(),careerTestResultForm.getScore19(),careerTestResultForm.getScore20(),careerTestResultForm.getScore21(),careerTestResultForm.getScore22(),careerTestResultForm.getScore23(),careerTestResultForm.getScore24());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career5";
    }
    @PostMapping("/{id}/test/career/{testId}/sixth")
    public String careerTestSixth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore4(testId,careerTestResultForm.getScore25(),careerTestResultForm.getScore26(),careerTestResultForm.getScore27(),careerTestResultForm.getScore28(),careerTestResultForm.getScore29(),careerTestResultForm.getScore30(),careerTestResultForm.getScore31(),careerTestResultForm.getScore32());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career6";
    }
    @PostMapping("/{id}/test/career/{testId}/seventh")
    public String careerTestSeventh(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore5(testId,careerTestResultForm.getScore33(),careerTestResultForm.getScore34(),careerTestResultForm.getScore35(),careerTestResultForm.getScore36(),careerTestResultForm.getScore37(),careerTestResultForm.getScore38(),careerTestResultForm.getScore39(),careerTestResultForm.getScore40());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career7";
    }
    @PostMapping("/{id}/test/career/{testId}/eighth")
    public String careerTestEight(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore6(testId,careerTestResultForm.getScore41(),careerTestResultForm.getScore42(),careerTestResultForm.getScore43(),careerTestResultForm.getScore44(),careerTestResultForm.getScore45(),careerTestResultForm.getScore46(),careerTestResultForm.getScore47(),careerTestResultForm.getScore48());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career8";
    }
    @PostMapping("/{id}/test/career/{testId}/nineth")
    public String careerTestNineth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore7(testId,careerTestResultForm.getScore49(),careerTestResultForm.getScore50(),careerTestResultForm.getScore51(),careerTestResultForm.getScore52(),careerTestResultForm.getScore53(),careerTestResultForm.getScore54(),careerTestResultForm.getScore55(),careerTestResultForm.getScore56());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career9";
    }
    @PostMapping("/{id}/test/career/{testId}/tenth")
    public String careerTestTenth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore8(testId,careerTestResultForm.getScore57(),careerTestResultForm.getScore58(),careerTestResultForm.getScore59(),careerTestResultForm.getScore60(),careerTestResultForm.getScore61(),careerTestResultForm.getScore62(),careerTestResultForm.getScore63(),careerTestResultForm.getScore64());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career10";
    }
    @PostMapping("/{id}/test/career/{testId}/11th")
    public String careerTest11th(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore9(testId,careerTestResultForm.getScore65(),careerTestResultForm.getScore66(),careerTestResultForm.getScore67(),careerTestResultForm.getScore68(),careerTestResultForm.getScore69(),careerTestResultForm.getScore70(),careerTestResultForm.getScore71(),careerTestResultForm.getScore72());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career11";
    }
    @PostMapping("/{id}/test/career/{testId}/last")
    public String careerTestLast(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore10(testId,careerTestResultForm.getScore73(),careerTestResultForm.getScore74(),careerTestResultForm.getScore75(),careerTestResultForm.getScore76(),careerTestResultForm.getScore77(),careerTestResultForm.getScore78(),careerTestResultForm.getScore79(),careerTestResultForm.getScore80());
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        //model.addAttribute("questions",careerTestService.getCareerQuestions());
        //CareerTestResult careerTestResult = careerTestService.mapQuestions(careerTestResultForm);
        consultantService.addCareerTest(id, testId);
        Consultant consultant1 = consultantService.findById(id).orElse(null);
        consultantService.updateNumberOfUsedCareerTests(id);
        return "redirect:/consultant/" + id + "/test/career/finish/" + testId;
    }
    @GetMapping("/{id}/test/career/finish/{testId}")
    public String careerTestFinish(@PathVariable("id") Long id, @PathVariable("testId")Long testId, Model model){
        CareerTestResult careerTestResult = careerTestService.findById(testId);
        model.addAttribute("result",careerTestResult);
        model.addAttribute("consultantId",id);
        List<String> lowest2 = careerTestService.findLowest2(careerTestResult);
        model.addAttribute("lowest",lowest2);
        return "careerTest/careerAssessment";
    }
    @PostMapping("/{id}/test/career/finish/{testId}")
    public String careerTestFinishPost(@PathVariable("id") Long id, @PathVariable("testId")Long testId, Model model){
        CareerTestResult careerTestResult = careerTestService.findById(testId);
        String html = null;
        Context context = dataMapper.setData(careerTestResult);
        html = springTemplateEngine.process("template",context);
        String s = pdfService.html2Pdf(html);
        return s;
    }
}
