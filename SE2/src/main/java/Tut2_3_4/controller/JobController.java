package Tut2_3_4.controller;

import Tut2_3_4.model.Company;
import Tut2_3_4.model.Employee;
import Tut2_3_4.model.Job;
import Tut2_3_4.repository.EmployeeRepository;
import Tut2_3_4.repository.JobRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/job")
public class JobController extends HelperController {
    @Autowired
    JobRepository jobRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    protected String returnPageByIndex(Optional<Integer> index, Model model, List<Job> jobs, String path) {
        int start = 0;
        if (index.isPresent()) start = index.get();
        int pages = jobs.size() / 5;
        if (jobs.size() % 5 == 0 && pages != 0) pages--;
        model.addAttribute("pages", pages);
        List<Job> list;
        if (start * 5 + 5 <= jobs.size()) {
            list = jobs.subList(start * 5, start * 5 + 5);
        } else {
            list = jobs.subList(start * 5, jobs.size());
        }
        model.addAttribute("currentPos", start);
        model.addAttribute("jobs", list);
        model.addAttribute("path", "/job/" + path);
        return "jobList";
    }

    @RequestMapping(value = {"/list/{index}", "/list"})
    public String getJobs(@PathVariable(value = "index") Optional<Integer> index, Model model) {
        List<Job> jobs = jobRepository.findAll();
        return returnPageByIndex(index, model, jobs, "list");
    }


    @RequestMapping(value = "/{id}")
    public String getJobById(@PathVariable(value = "id") Long id, Model model) {
        Job job = jobRepository.getReferenceById(id);
        model.addAttribute("job", job);
        List<Employee> employees = employeeRepository.findByJobsContaining(job);
        model.addAttribute("employees", employees);
        return "jobDetail";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addJobForm(@ModelAttribute("job") Job job, Model model) {
        model.addAttribute("job", job);
        return "jobAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addJob(@Valid Job job, BindingResult result) {
        if (result.hasErrors()) {
            return "jobAdd";
        }
        jobRepository.saveAndFlush(job);
        return "redirect:/job/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateJobForm(@PathVariable(value = "id") Long id, Model model) {
        Job job = jobRepository.getReferenceById(id);
        model.addAttribute("job", job);
        return "jobUpdate";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateJob(@PathVariable(value = "id") Long id, @Valid Job job, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            job.setId(id);
            return "jobUpdate";
        }
        jobRepository.saveAndFlush(job);
        return "redirect:/job/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteJob(@PathVariable(value = "id") Long id) {
        jobRepository.deleteById(id);
        return "redirect:/job/list";
    }

    @RequestMapping(value = {"/search/{index}", "/search"})
    public String searchJob(@PathVariable Optional<Integer> index, Model model, @RequestParam(value = "name") String name) {
        List<Job> jobs = jobRepository.findByNameContaining(name);
        model.addAttribute("name", name);
        return returnPageByIndex(index, model, jobs, "search");
    }

    @RequestMapping(value = {"/sort/asc/{index}", "/sort/asc"})
    public String sortEmployeeAsc(@PathVariable Optional<Integer> index, Model model) {
        List<Job> jobs = jobRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return returnPageByIndex(index, model, jobs, "sort/asc");
    }

    @RequestMapping(value = {"/sort/desc/{index}", "/sort/desc"})
    public String sortEmployeeDesc(@PathVariable Optional<Integer> index, Model model) {
        List<Job> jobs = jobRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        return returnPageByIndex(index, model, jobs, "sort/desc");
    }

}
