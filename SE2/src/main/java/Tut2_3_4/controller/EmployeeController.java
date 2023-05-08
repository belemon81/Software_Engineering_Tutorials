package Tut2_3_4.controller;

import Tut2_3_4.model.Company;
import Tut2_3_4.model.Employee;
import Tut2_3_4.model.Job;
import Tut2_3_4.repository.CompanyRepository;
import Tut2_3_4.repository.EmployeeRepository;
import Tut2_3_4.repository.JobRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends HelperController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    JobRepository jobRepository;

    protected String returnPageByIndex(Optional<Integer> index, Model model, List<Employee> employees, String path) {
        int start = 0;
        if (index.isPresent()) start = index.get();
        int pages = employees.size() / 5;
        if (employees.size() % 5 == 0 && pages != 0) pages--;
        model.addAttribute("pages", pages);
        List<Employee> list;
        if (start * 5 + 5 <= employees.size()) {
            list = employees.subList(start * 5, start * 5 + 5);
        } else {
            list = employees.subList(start * 5, employees.size());
        }
        model.addAttribute("currentPos", start);
        model.addAttribute("employees", list);
        model.addAttribute("path", "/employee/" + path);
        return "employeeList";
    }

//    @RequestMapping(value = "/list")
//    public String getAllEmployees(Model model) {
//        List<Employee> employees = employeeRepository.findAll();
//        model.addAttribute("employees", employees);
//        return "employeeList";
//    }

    @RequestMapping(value = {"/list/{index}", "/list"})
    public String getEmployees(@PathVariable(value = "index") Optional<Integer> index, Model model) {
        List<Employee> employees = employeeRepository.findAll();
        return returnPageByIndex(index, model, employees, "list");
    }

    @RequestMapping(value = "/{id}")
    public String getEmployeeById(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.getReferenceById(id);
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEmployeeForm(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("employee", employee);
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "employeeAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addEmployee(@RequestParam("file") MultipartFile multipartFile, @Valid Employee employee, BindingResult result, Model model) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        employee.setImage(fileName);
        if (result.hasErrors()) {
            List<Company> companies = companyRepository.findAll();
            model.addAttribute("companies", companies);
            List<Job> jobs = jobRepository.findAll();
            model.addAttribute("jobs", jobs);
            return "employeeAdd";
        }
        Employee employeeSaved = employeeRepository.saveAndFlush(employee);
        String uploadDir = "emp_images/" + employeeSaved.getId();
        saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateEmployeeForm(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.getReferenceById(id);
        List<Company> companies = companyRepository.findAll();
        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        model.addAttribute("companies", companies);
        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateEmployee(@PathVariable(value = "id") Long id, @RequestParam("file") MultipartFile multipartFile, @Valid Employee employee, BindingResult result, Model model) throws IOException {
        String fileName = null;
        if (!multipartFile.isEmpty()) {
            fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            employee.setImage(fileName);
        } else {
            String image = employeeRepository.getReferenceById(id).getImage();
            employee.setImage(image);
        }
        if (result.hasErrors()) {
            if (id == null) {
                return "employeeAdd";
            } else {
                employee.setId(id);
                List<Company> companies = companyRepository.findAll();
                model.addAttribute("companies", companies);
                List<Job> jobs = jobRepository.findAll();
                model.addAttribute("jobs", jobs);
                return "employeeUpdate";
            }
        }
        Employee employeeSaved = employeeRepository.saveAndFlush(employee);
        if (fileName != null) {
            String uploadDir = "emp_images/" + employeeSaved.getId();
            saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employee/list";
    }

    @RequestMapping(value = {"/search/{index}", "/search"})
    public String searchEmployee(@PathVariable Optional<Integer> index, Model model, @RequestParam(value = "name") String name) {
        List<Employee> employees = employeeRepository.findByNameContaining(name);
        model.addAttribute("name", name);
        return returnPageByIndex(index, model, employees, "search");
    }

    @RequestMapping(value = {"/sort/asc/{index}", "/sort/asc"})
    public String sortEmployeeAsc(@PathVariable Optional<Integer> index, Model model) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return returnPageByIndex(index, model, employees, "sort/asc");
    }

    @RequestMapping(value = {"/sort/desc/{index}", "/sort/desc"})
    public String sortEmployeeDesc(@PathVariable Optional<Integer> index, Model model) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        return returnPageByIndex(index, model, employees, "sort/desc");
    }
}
