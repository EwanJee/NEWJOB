package com.newjob.consultant.controller.mranderson;

import com.newjob.consultant.entity.consultant.dto.ConsultantForm;
import com.newjob.consultant.entity.mranderson.dto.MrAndersonTestResultForm;
import com.newjob.consultant.entity.mranderson.MrAndersonTestResult;
import com.newjob.consultant.service.consultant.ConsultantService;
import com.newjob.consultant.service.mranderson.MrAndersonTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultant")
public class MrAndersonTestController {
    private final ConsultantService consultantService;
    private final MrAndersonTestService mrAndersonTestService;

    @GetMapping("/{id}/test/mranderson")
    public String linkMrAnderson(@PathVariable("id") Long id, Model model) {
        ConsultantForm consultantForm = consultantService.findById(id);
        model.addAttribute("consultant",consultantForm);
        if (!consultantService.isValid4Test(consultantForm)) {
            return "careerTest/false";
        } else if (consultantForm.getNumberOfAvailableMrAndersonTests() <= 0) {
            return "careerTest/invalid";
        } else {
            return "mrAnderson/andersonValid";
        }
    }

    @GetMapping("/{id}/test/mrAnderson/start")
    public String andersonStart(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("form", new MrAndersonTestResultForm());
        return "mrAnderson/andersonStart";
    }

    @PostMapping("/{id}/test/mrAnderson/track")
    public String andersonLocation(@PathVariable("id") Long id, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model) {
        Long joined = mrAndersonTestService.join(mrAndersonTestResultForm);
        model.addAttribute("id", id);
        model.addAttribute("form", mrAndersonTestResultForm);
        model.addAttribute("testId", joined);
        return "mrAnderson/andersonFirst";
    }

    @PostMapping("/{id}/test/mrAnderson/{testId}/track2")
    public String andersonTrack2(@PathVariable("id") Long id, @PathVariable("testId") Long testId, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        return "mrAnderson/anderson2";
    }

    @PostMapping("/{id}/test/mrAnderson/{testId}/track3")
    public String andersonTrack3(@PathVariable("id") Long id, @PathVariable("testId") Long testId, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        model.addAttribute("form", new MrAndersonTestResultForm());
        return "mrAnderson/anderson3";
    }

    @PostMapping("/{id}/test/mrAnderson/{testId}/test1")
    public String andersonTest1(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model) {
        mrAndersonTestService.updateInfo(testId, mrAndersonTestResultForm.getJob(), mrAndersonTestResultForm.getOrganization2(), mrAndersonTestResultForm.getProfession(), mrAndersonTestResultForm.getIndustry());
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        model.addAttribute("form", mrAndersonTestResultForm);
        model.addAttribute("questions", mrAndersonTestService.getMrAndersonQuestions());
        return "mrAnderson/anderson4";
    }

    @PostMapping("/{id}/test/mrAnderson/{testId}/test2")
    public String andersonTest2(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model) {
        mrAndersonTestService.updateScore(testId, mrAndersonTestResultForm.getScore1(), mrAndersonTestResultForm.getScore2(), mrAndersonTestResultForm.getScore3(), mrAndersonTestResultForm.getScore4(), mrAndersonTestResultForm.getScore5(), mrAndersonTestResultForm.getScore6(), mrAndersonTestResultForm.getScore7(), mrAndersonTestResultForm.getScore8());
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        model.addAttribute("form", mrAndersonTestResultForm);
        model.addAttribute("questions", mrAndersonTestService.getMrAndersonQuestions());
        return "mrAnderson/anderson5";
    }

    @PostMapping("/{id}/test/mrAnderson/{testId}/test3")
    public String andersonTest3(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model) {
        mrAndersonTestService.updateScore(testId,mrAndersonTestResultForm.getScore9(),mrAndersonTestResultForm.getScore10(),mrAndersonTestResultForm.getScore11(),mrAndersonTestResultForm.getScore12(),mrAndersonTestResultForm.getScore13(),mrAndersonTestResultForm.getScore14(),mrAndersonTestResultForm.getScore15(),mrAndersonTestResultForm.getScore16());
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        model.addAttribute("form", mrAndersonTestResultForm);
        model.addAttribute("questions", mrAndersonTestService.getMrAndersonQuestions());
        return "mrAnderson/anderson6";
    }
    @PostMapping("/{id}/test/mrAnderson/{testId}/test4")
    public String andersonTest4(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model) {
        mrAndersonTestService.updateScore(testId,mrAndersonTestResultForm.getScore17(),mrAndersonTestResultForm.getScore18(),mrAndersonTestResultForm.getScore19(),mrAndersonTestResultForm.getScore20(),mrAndersonTestResultForm.getScore21(),mrAndersonTestResultForm.getScore22(),mrAndersonTestResultForm.getScore23(),mrAndersonTestResultForm.getScore24());
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        model.addAttribute("form", mrAndersonTestResultForm);
        model.addAttribute("questions", mrAndersonTestService.getMrAndersonQuestions());
        return "mrAnderson/anderson7";
    }
    @PostMapping("/{id}/test/mrAnderson/{testId}/test5")
    public String andersonTest5(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model) {
        mrAndersonTestService.updateScore(testId,mrAndersonTestResultForm.getScore25(),mrAndersonTestResultForm.getScore26(),mrAndersonTestResultForm.getScore27(),mrAndersonTestResultForm.getScore28(),mrAndersonTestResultForm.getScore29(),mrAndersonTestResultForm.getScore30(),mrAndersonTestResultForm.getScore31(),mrAndersonTestResultForm.getScore32());
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        model.addAttribute("form", mrAndersonTestResultForm);
        model.addAttribute("questions", mrAndersonTestService.getMrAndersonQuestions());
        return "mrAnderson/anderson8";
    }
    @PostMapping("/{id}/test/mrAnderson/{testId}/test6")
    public String andersonTest6(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model) {
        mrAndersonTestService.updateScore(testId,mrAndersonTestResultForm.getScore33(),mrAndersonTestResultForm.getScore34(),mrAndersonTestResultForm.getScore35(),mrAndersonTestResultForm.getScore36(),mrAndersonTestResultForm.getScore37(),mrAndersonTestResultForm.getScore38(),mrAndersonTestResultForm.getScore39(),mrAndersonTestResultForm.getScore40());
        model.addAttribute("id", id);
        model.addAttribute("testId", testId);
        model.addAttribute("form", mrAndersonTestResultForm);
        model.addAttribute("questions", mrAndersonTestService.getMrAndersonQuestions());
        return "mrAnderson/anderson9";
    }
    @PostMapping("/{id}/test/mrAnderson/{testId}/result")
    public String andersonResult(@PathVariable("id") Long id, @PathVariable("testId") Long testId, @ModelAttribute("form") MrAndersonTestResultForm mrAndersonTestResultForm, Model model){
        mrAndersonTestService.updateScore(testId,mrAndersonTestResultForm.getScore41(),mrAndersonTestResultForm.getScore42(),mrAndersonTestResultForm.getScore43(),mrAndersonTestResultForm.getScore44(),mrAndersonTestResultForm.getScore45(),mrAndersonTestResultForm.getScore46(),mrAndersonTestResultForm.getScore47(),mrAndersonTestResultForm.getScore48());
        consultantService.updateNumberOfUsedMrAndersonTests(id);
        consultantService.addMrAndersonTest(id,testId);
        return "redirect:/consultant/" + id + "/test/mrAnderson/finish/" + testId;
    }
    @GetMapping("/{id}/test/mrAnderson/finish/{testId}")
    public String andersonPage(@PathVariable("id")Long id, @PathVariable("testId")Long testId,Model model){
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestService.findById(testId).orElse(null);
        model.addAttribute("result",mrAndersonTestResult);
        model.addAttribute("list",mrAndersonTestService.getMyBlackBox(mrAndersonTestResult));
        model.addAttribute("consultantId",id);
        return "mrAnderson/andersonPage";
    }
}
