package com.project.nouapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.nouapp.api.SmsSender;
import com.project.nouapp.dto.AdminLoginDto;
import com.project.nouapp.dto.EnquiryDto;
import com.project.nouapp.dto.StudentInfoDto;
import com.project.nouapp.model.AdminLogin;
import com.project.nouapp.model.Enquiry;
import com.project.nouapp.model.StudentInfo;
import com.project.nouapp.service.AdminLoginRepository;
import com.project.nouapp.service.EnquiryRepository;
import com.project.nouapp.service.StudentInfoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	EnquiryRepository erepo;

	@Autowired
	StudentInfoRepository sirepo;

	@Autowired
	AdminLoginRepository alrepo;
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}

	@GetMapping("/contact")
	public String showContact(Model model) {
		EnquiryDto enquiryDto = new EnquiryDto();
		model.addAttribute("enquiryDto", enquiryDto);
		return "contact";
	}

	@PostMapping("/contact")
	public String createContact(@ModelAttribute EnquiryDto enquiryDto, RedirectAttributes redirectAttributes) {
		Enquiry e = new Enquiry();
		e.setName(enquiryDto.getName());
		e.setContactno(enquiryDto.getContactno());
		e.setEmailaddress(enquiryDto.getEmailaddress());
		e.setEnquirytype(enquiryDto.getEnquirytype());
		e.setEnquirytext(enquiryDto.getEnquirytext());
		e.setEnquirydate(new String() + "");
		erepo.save(e);
		SmsSender ss= new SmsSender();
		ss.sendSms(enquiryDto.getContactno());
		redirectAttributes.addFlashAttribute("msg", "Enquiry is saved");
		return "redirect:/contact";
	}

	@GetMapping("/registration")
	public String showRegistration(Model model) {
		StudentInfoDto infoDto = new StudentInfoDto();
		model.addAttribute("infoDto", infoDto);
		return "registration";
	}

	@PostMapping("/registration")
	public String createRegistration(@ModelAttribute StudentInfoDto infoDto, RedirectAttributes redirectAttributes) {
		StudentInfo s = new StudentInfo();
		s.setRollno(infoDto.getRollno());
		s.setName(infoDto.getName());
		s.setFname(infoDto.getFname());
		s.setMname(infoDto.getMname());
		s.setGender(infoDto.getGender());
		s.setAddress(infoDto.getAddress());
		s.setProgram(infoDto.getProgram());
		s.setBranch(infoDto.getBranch());
		s.setYear(infoDto.getYear());
		s.setContact(infoDto.getContact());
		s.setEmailaddress(infoDto.getEmailaddress());
		s.setPassword(infoDto.getPassword());
		s.setRegdate(new String() + "");
		s.setStatus("false");
		sirepo.save(s);
		redirectAttributes.addFlashAttribute("msg", "Registration is done");
		return "redirect:/registration";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String validateUser(@ModelAttribute StudentInfoDto infoDto, RedirectAttributes redirectAttributes,HttpSession session) {
		try {
			StudentInfo s = sirepo.getById(infoDto.getRollno());
			if (s.getPassword().equals(infoDto.getPassword())) {
				session.setAttribute("rollno", infoDto.getRollno() + "");
				return "redirect:/student/";
			} else {
				redirectAttributes.addFlashAttribute("msg", "Invalid User");
			}
		} catch (EntityNotFoundException ex) {
			redirectAttributes.addFlashAttribute("msg", "Student doesn't Exist");
		}
		return "redirect:/login";

	}

	@GetMapping("/adminlogin")
	public String showAdminLogin(Model model) {
		AdminLoginDto dto=new AdminLoginDto();
		model.addAttribute("dto", dto);
		return "adminlogin";
	}
	
	@PostMapping("/adminlogin")
	public String validateAdmin(@ModelAttribute AdminLoginDto dto, RedirectAttributes redirectAttributes, HttpSession session) 
	{
		try {
			AdminLogin al=alrepo.getById(dto.getAdminid());
			if(al.getAdminpassword().equals(dto.getAdminpassword())){
				{
					//redirectAttributes.addFlashAttribute("msg", "Valid User");
					session.setAttribute("adminid", al.getAdminid());
					return "redirect:/admin/";
				}
			}
				else {
					redirectAttributes.addFlashAttribute("msg", "Invalid User");
					return "redirect:/adminlogin";
				}
			
			
		}
		catch(EntityNotFoundException ex) {
			redirectAttributes.addFlashAttribute("msg", "Admin Not Found");
			return "redirect:/adminlogin";
		}
		}
}

