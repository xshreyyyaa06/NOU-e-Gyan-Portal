package com.project.nouapp.controller;

import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.nouapp.dto.MaterialDto;
import com.project.nouapp.model.Enquiry;
import com.project.nouapp.model.Material;
import com.project.nouapp.model.Response;
import com.project.nouapp.model.StudentInfo;
import com.project.nouapp.service.AdminLoginRepository;
import com.project.nouapp.service.EnquiryRepository;
import com.project.nouapp.service.MaterialRepository;
import com.project.nouapp.service.ResponseRepository;
import com.project.nouapp.service.StudentInfoRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	AdminLoginRepository alrepo;

	@Autowired
	EnquiryRepository erepo;

	@Autowired
	ResponseRepository rrepo;

	@Autowired
	StudentInfoRepository sirepo;

	@Autowired
	MaterialRepository mrepo;
	@GetMapping("/")
	public String showAdminHome(HttpSession session, Model model, HttpServletResponse response) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				String scount=sirepo.count()+"";
				String ecount=erepo.count()+"";
				String rcount=rrepo.count()+"";
				String mcount=mrepo.count()+"";
				model.addAttribute("scount", scount);
				model.addAttribute("ecount", ecount);
				model.addAttribute("rcount", rcount);
				model.addAttribute("mcount", mcount);
				return "/admin/adminhome";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}
	}

	@GetMapping("/adminlogout")
	public String showStudentHome(HttpSession session) {

		try {
			session.invalidate();
			return "redirect:/adminlogin";
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}

	}

	@GetMapping("/managestudents")
	public String showManageStudents(HttpSession session, Model model, HttpServletResponse response) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {

				List<StudentInfo> siList=sirepo.findAll();
				model.addAttribute("silist", siList);
				return "/admin/managestudents";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}

	}
	@GetMapping("/viewenquiries")
	public String showEnquiries(HttpSession session, Model model, HttpServletResponse response) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				List<Enquiry> eList = erepo.findAll();
				model.addAttribute("elist", eList);

				return "/admin/viewenquiries";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}

	}
	@GetMapping("/deleteenq")
	public String deleteEnquiry(HttpSession session, Model model, HttpServletResponse response, @RequestParam int id) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				Enquiry e=erepo.getById(id);
				erepo.delete(e);
				

				return "redirect:/admin/viewenquiries";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}

	}
	@GetMapping("/viewfeedbacks")
	public String showFeedbacks(HttpSession session, Model model, HttpServletResponse response) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				List<Response> res=rrepo.findResponsesByResponseType("feedback");
				model.addAttribute("res", res);
				return "/admin/viewfeedbacks";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}

	}
	@GetMapping("/deletefeedback")
	public String deleteFeedback(HttpSession session, Model model, HttpServletResponse response, @RequestParam long id) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				Response r=rrepo.getById(id);
				rrepo.delete(r);
				return "redirect:/admin/viewfeedbacks";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}
	}	
	@GetMapping("/viewcomplaints")
	public String showComplaints(HttpSession session, Model model, HttpServletResponse response) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				List<Response> res=rrepo.findResponsesByResponseType("complaint");
				model.addAttribute("res", res);
				return "/admin/viewcomplaints";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}

	}
	@GetMapping("/deletecomplaint")
	public String deleteComplaint(HttpSession session, Model model, HttpServletResponse response, @RequestParam long id) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				Response r=rrepo.getById(id);
				rrepo.delete(r);
				return "redirect:/admin/viewcomplaints";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}
	}
	@GetMapping("/addmaterials")
	public String showAddMaterial(HttpSession session, Model model, HttpServletResponse response) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				MaterialDto dto=new MaterialDto();
				model.addAttribute("dto", dto);
        		return "/admin/addmaterials";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}
	}
	@PostMapping("/addmaterials")
	public String createAddMaterial(HttpSession session, Model model, HttpServletResponse response,@ModelAttribute MaterialDto dto, RedirectAttributes redirectAttributes) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				MultipartFile matfile=dto.getMatfile();
				String storageFileName=new Date().getTime()+"_"+matfile.getOriginalFilename();
				String uploadDir="public/mat/";
				Path uploadPath=Paths.get(uploadDir);
				if(!Files.exists(uploadPath))
				{
					Files.createDirectories(uploadPath);
				}	
				try (InputStream inputStream=matfile.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir+storageFileName),StandardCopyOption.REPLACE_EXISTING);
				}
				Material material=new Material();
				material.setProgram(dto.getProgram());
				material.setBranch(dto.getBranch());
				material.setYear(dto.getYear());
				material.setSubject(dto.getSubject());
				material.setTopic(dto.getTopic());
				material.setMaterialtype(dto.getMaterialtype());
				material.setFilename(storageFileName);
				material.setPosteddate(new Date()+"");
				mrepo.save(material);
				redirectAttributes.addFlashAttribute("msg", "Material is uploaded");
        		return "redirect:/admin/addmaterials";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}
	}
	@GetMapping("/managematerials")
	public String showMaterials(HttpSession session, Model model, HttpServletResponse response) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				List<Material> mlist=mrepo.findAll();
				model.addAttribute("mlist", mlist);

				return "/admin/managematerials";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}
	}
	@GetMapping("/deletemat")
	public String deleteMaterials(HttpSession session, Model model, HttpServletResponse response, @RequestParam int id) {
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		try {
			if (session.getAttribute("adminid") != null) {
				Material m=mrepo.getById(id);
				Path imagePath=Paths.get("public/mat/"+m.getFilename());
				try {
					Files.delete(imagePath);
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				mrepo.delete(m);
				return "redirect:/admin/managematerials";
			} else {
				return "redirect:/adminlogin";
			}
		} catch (Exception ex) {
			return "redirect:/adminlogin";
		}
	}

	


}
