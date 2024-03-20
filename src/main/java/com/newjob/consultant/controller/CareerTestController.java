package com.newjob.consultant.controller;

import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.service.CareerTestService;
import com.newjob.consultant.service.ConsultantService;
import com.newjob.consultant.service.DataMapper;
import com.newjob.consultant.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

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
        Consultant consultant = consultantService.findById(id);
        model.addAttribute("consultant",consultant);
        if(consultantService.isValid4Test(consultant)){
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
        careerTestService.updateScore1(testId,careerTestResultForm);
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
        careerTestService.updateScore2(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career4";
    }
    @PostMapping("/{id}/test/career/{testId}/fifth")
    public String careerTestFifth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore3(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career5";
    }
    @PostMapping("/{id}/test/career/{testId}/sixth")
    public String careerTestSixth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore4(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career6";
    }
    @PostMapping("/{id}/test/career/{testId}/seventh")
    public String careerTestSeventh(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore5(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career7";
    }
    @PostMapping("/{id}/test/career/{testId}/eighth")
    public String careerTestEight(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore6(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career8";
    }
    @PostMapping("/{id}/test/career/{testId}/nineth")
    public String careerTestNineth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore7(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career9";
    }
    @PostMapping("/{id}/test/career/{testId}/tenth")
    public String careerTestTenth(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore8(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career10";
    }
    @PostMapping("/{id}/test/career/{testId}/11th")
    public String careerTest11th(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm,Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore9(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        model.addAttribute("questions",careerTestService.getCareerQuestions());
        return "careerTest/career11";
    }
    @PostMapping("/{id}/test/career/{testId}/last")
    public String careerTestLast(@PathVariable("id") Long id,@PathVariable("testId") Long testId,@ModelAttribute("form")CareerTestResultForm careerTestResultForm, Model model){
        ConsultantForm consultant = new ConsultantForm();
        consultant.setId(id);
        careerTestService.updateScore10(testId,careerTestResultForm);
        model.addAttribute("consultant",consultant);
        model.addAttribute("form",careerTestResultForm);
        //model.addAttribute("questions",careerTestService.getCareerQuestions());
        //CareerTestResult careerTestResult = careerTestService.mapQuestions(careerTestResultForm);
        consultantService.addCareerTest(id, testId);
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
