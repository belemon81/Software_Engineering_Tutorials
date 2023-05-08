package Tut2_3_4.controller;

import Tut2_3_4.model.Company;
import Tut2_3_4.model.Employee;
import Tut2_3_4.repository.CompanyRepository;
import Tut2_3_4.repository.EmployeeRepository;
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
@RequestMapping("/company")
public class CompanyController extends HelperController {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    protected String returnPageByIndex(Optional<Integer> index, Model model, List<Company> companies, String path) {
        int start = 0;
        if (index.isPresent()) start = index.get();
        int pages = companies.size() / 5;
        if (companies.size() % 5 == 0 && pages != 0) pages--;
        model.addAttribute("pages", pages);
        List<Company> list;
        if (start * 5 + 5 <= companies.size()) {
            list = companies.subList(start * 5, start * 5 + 5);
        } else {
            list = companies.subList(start * 5, companies.size());
        }
        model.addAttribute("currentPos", start);
        model.addAttribute("companies", list);
        model.addAttribute("path", "/company/" + path);
        return "companyList";
    }

    @RequestMapping(value = "/{id}")
    public String getCompanyById(@PathVariable(value = "id") Long id, Model model) {
        Company company = companyRepository.getReferenceById(id);
        model.addAttribute("company", company);
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "companyDetail";
    }

    @RequestMapping(value = {"/list/{index}", "/list"})
    public String getCompanies(@PathVariable(value = "index") Optional<Integer> index, Model model) {
        List<Company> companies = companyRepository.findAll();
        return returnPageByIndex(index, model, companies, "list");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCompanyForm(@ModelAttribute("company") Company company, Model model) {
        model.addAttribute("company", company);
        return "companyAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addCompany(@RequestParam("file") MultipartFile multipartFile, @Valid Company company, BindingResult result) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        company.setImage(fileName);
        if (result.hasErrors()) {
            return "companyAdd";
        }
        Company companySaved = companyRepository.saveAndFlush(company);
        String uploadDir = "comp_images/" + companySaved.getId();
        saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/company/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateCompanyForm(@PathVariable(value = "id") Long id, Model model) {
        Company company = companyRepository.getReferenceById(id);
        model.addAttribute("company", company);
        return "companyUpdate";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateCompany(@PathVariable(value = "id") Long id, @RequestParam("file") MultipartFile multipartFile, @Valid Company company, BindingResult result) throws IOException {
        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            company.setImage(fileName);
            if (result.hasErrors()) {
                if (id == null) {
                    return "companyAdd";
                } else {
                    company.setId(id);
                    return "companyUpdate";
                }
            }
            Company companySaved = companyRepository.saveAndFlush(company);
            String uploadDir = "comp_images/" + companySaved.getId();
            saveFile(uploadDir, fileName, multipartFile);
            return "redirect:/company/list";
        } else {
            String image = companyRepository.getReferenceById(id).getImage();
            company.setImage(image);
            if (result.hasErrors()) {
                company.setId(id);
                return "companyUpdate";
            }
            companyRepository.saveAndFlush(company);
            return "redirect:/company/list";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCompany(@PathVariable(value = "id") Long id) {
        companyRepository.deleteById(id);
        return "redirect:/company/list";
    }

    @RequestMapping(value = {"/search/{index}", "/search"})
    public String searchCompany(@PathVariable Optional<Integer> index, Model model, @RequestParam(value = "name") String name) {
        List<Company> companies = companyRepository.findByNameContaining(name);
        model.addAttribute("name", name);
        return returnPageByIndex(index, model, companies, "search");
    }

    @RequestMapping(value = {"/sort/asc/{index}", "/sort/asc"})
    public String sortEmployeeAsc(@PathVariable Optional<Integer> index, Model model) {
        List<Company> companies = companyRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return returnPageByIndex(index, model, companies, "sort/asc");
    }

    @RequestMapping(value = {"/sort/desc/{index}", "/sort/desc"})
    public String sortEmployeeDesc(@PathVariable Optional<Integer> index, Model model) {
        List<Company> companies = companyRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        return returnPageByIndex(index, model, companies, "sort/desc");
    }

}
