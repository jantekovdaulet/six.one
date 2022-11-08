package kz.bitlab.spring.six.one.spring.demo.six.one.controllers;

import kz.bitlab.spring.six.one.spring.demo.six.one.models.ApplicationRequest;
import kz.bitlab.spring.six.one.spring.demo.six.one.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value = "/")
    public String getAllApplications(Model model) {
        List<ApplicationRequest> applications = applicationService.getAllApplications();
        model.addAttribute("applications", applications);
        return "allapplications";
    }

    @GetMapping(value = "/addform")
    public String getApplicationForm() {
        return "applicationsform";
    }

    @PostMapping(value = "/addapp")
    public String addApplication(@RequestParam(name = "userName") String userName,
                                 @RequestParam(name = "courseName") String courseName,
                                 @RequestParam(name = "commentary") String commentary,
                                 @RequestParam(name = "phone") String phone) {
        applicationService.addApplication(new ApplicationRequest(null, userName, courseName, commentary, phone, false));
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String getDetails(Model model,
                             @PathVariable(name = "id") Long id) {
        ApplicationRequest application = applicationService.getApplication(id);
        if (application != null) {
            model.addAttribute("app", application);
            return "details";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/handleapp")
    public String handleApplication(@RequestParam(name = "id") Long id) {
        ApplicationRequest application = applicationService.getApplication(id);
        if (application != null) {
            application.setHandled(true);
            applicationService.saveApplication(application);
            return "redirect:/details/" + id;
        }
        return "redirect:/";
    }

    @PostMapping(value = "/deleteapp")
    public String deleteApplication(@RequestParam(name = "id") Long id) {
        ApplicationRequest application = applicationService.getApplication(id);
        if (application != null) {
            applicationService.deleteApplication(application);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/newapplications")
    public String getNewApplications(Model model) {
        List<ApplicationRequest> newApplications = applicationService.getNewApplications();
        model.addAttribute("newApplications", newApplications);
        return "newapplications";
    }

    @GetMapping(value = "/oldapplications")
    public String getOldApplications(Model model) {
        List<ApplicationRequest> oldApplications = applicationService.getOldApplications();
        model.addAttribute("oldApplications", oldApplications);
        return "oldapplications";
    }
}
