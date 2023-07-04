package com.vaccine;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VaccineController {
   Logger log =Logger.getAnonymousLogger();
	@Autowired
	VaccineDao dao;
	@RequestMapping("/")
	public ModelAndView loadbasepage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;

	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		int value = dao.login(name, pass);
		if (value != 0) {

			HttpSession session = request.getSession();
			session.setAttribute("UserName", name);
			mv.setViewName("redirect:/dashboard");
			return mv;
		} else {
			mv.setViewName("fail");
			return mv;
		}

	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
			HttpSession session=request.getSession();  
            session.invalidate();  
			mv.setViewName("redirect:/logout.jsp");
			return mv;
	}

	
	@RequestMapping("/register")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Admin adm = new Admin();
		adm.setUname(request.getParameter("uname"));
		adm.setUemail(request.getParameter("uemail"));
		adm.setUpass(request.getParameter("upass"));
		Admin value = dao.insertadm(adm);
		if (value != null) {
			mv.setViewName("RegSuccess");
			return mv;
		} else {
			mv.setViewName("fail");
			return mv;
		} 

	}

	@RequestMapping("/dashboard")
	public ModelAndView dash(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Vaccenter> listvc = dao.getcent();
		mv.setViewName("Dashboard");
		mv.addObject("listvc", listvc);
		return mv;

	}

//Retrive city from db
	@RequestMapping("/addvcent")
	public ModelAndView reqciti(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<City> citi = dao.getcity();
		if (citi != null) {
			mv.setViewName("Addvac");
			mv.addObject("citi", citi);
			return mv;
		} else {
			mv.setViewName("fail.jsp");
			return null;
		}

	}

//insert vaccenter in db
	@RequestMapping("/addvac")
	public ModelAndView insertvac(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Vaccenter vc = new Vaccenter();
		vc.setName(request.getParameter("cname"));
		vc.setCity(request.getParameter("selectedCity"));
		Vaccenter value = dao.insertcent(vc);
		if (value != null) {
			mv.setViewName("redirect:/dashboard");
			return mv;

		} else {
			mv.setViewName("fail");
			return mv;
		}

	}

	@RequestMapping("/viewvac")
	public ModelAndView viewvac(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		String clinicname = request.getParameter("name");
		Vaccenter vlist = dao.findbyid(id);
		List<Citizens> clist = dao.findbyclinicname(clinicname);
		mv.setViewName("vcview");
		mv.addObject("vlist", vlist);
		mv.addObject("clist", clist);
		return mv;
	}

	@RequestMapping("/editvac")
	public ModelAndView editvac(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		List<City> citi = dao.getcity();
		Vaccenter optlist = dao.update(id);
		if (optlist != null) {
			mv.setViewName("editcent");
			mv.addObject("optlist", optlist);
			mv.addObject("citi", citi);
			return mv;
		}
		return mv;

	}

	@RequestMapping("/update")
	public ModelAndView updateVac(HttpServletRequest request, HttpServletResponse response) {
		Vaccenter vc = new Vaccenter();
		ModelAndView mv = new ModelAndView();
		String prev = request.getParameter("prevname");
		log.info(prev);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("cname");
		String city = request.getParameter("cityname");
		vc.setId(id);
		vc.setName(name);
		vc.setCity(city);
		Vaccenter value = dao.updatedet(vc);
		dao.updateByName(name, prev);
		if (value != null) {
			mv.setViewName("redirect:/dashboard");
			return mv;
		} else {
			mv.setViewName("fail");
			return mv;
		}
	}

	@RequestMapping("/deletevac")
	public ModelAndView delVac(HttpServletRequest request, HttpServletResponse response) {
	
		Vaccenter vc = new Vaccenter();
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = (request.getParameter("name"));
		log.info(name);
		dao.deletecent(id);
		dao.deletebycname(name);
		mv.setViewName("redirect:/dashboard");
		return mv;
	}

	@RequestMapping("/citidash")
	public ModelAndView citidash(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Citizens> listctzn = dao.getciti();
		mv.setViewName("citidashboard");
		mv.addObject("listctzn", listctzn);
		return mv;

	}

	@RequestMapping("/getciticenter")
	public ModelAndView getcent(HttpServletRequest request, HttpServletResponse response) {
		Vaccenter vc = new Vaccenter();
		ModelAndView mv = new ModelAndView();
		List<Vaccenter> centerlist = dao.getcent();
		List<City> citi = dao.getcity();
		mv.setViewName("Addciti");
		mv.addObject("citi", citi);
		mv.addObject("centerlist", centerlist);
		return mv;

	}

	@RequestMapping("/addcitizen")
	public ModelAndView insertciti(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Citizens citi = new Citizens();
		citi.setName(request.getParameter("cname"));
		citi.setClinicname(request.getParameter("selectedCenter"));
		citi.setCity(request.getParameter("selectedCity"));
		int dose = Integer.parseInt(request.getParameter("noofdose"));
		citi.setNoofdose(dose);
		if (dose == 0) {
			citi.setStatus("Not vaccinated");
		} else if (dose == 1) {
			citi.setStatus("Partially vaccinated");
		} else if (dose == 2) {
			citi.setStatus("Fully vaccinated");
		}
		Citizens ctzn = dao.insertciti(citi);
		if (ctzn != null) {
			mv.setViewName("redirect:/citidash");
			return mv;
		} else {
			mv.setViewName("fail");
			return mv;
		}
	}

	@RequestMapping("/viewciti")
	public ModelAndView viewciti(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		Citizens citiinfo = dao.getcitibyid(id);
		mv.setViewName("viewciti");
		mv.addObject("citiinfo", citiinfo);
		return mv;
	}

	@RequestMapping("/editcit")
	public ModelAndView editciti(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		Citizens citz = dao.getcitibyid(id);
		List<City> city = dao.getcity();
		List<Vaccenter> centerlist = dao.getcent();
		mv.setViewName("citiedit");
		mv.addObject("citi", city);
		mv.addObject("citiinfo", citz);
		mv.addObject("centerlist", centerlist);
		return mv;

	}

	@RequestMapping("/updateciti")
	public ModelAndView updateciti(HttpServletRequest request, HttpServletResponse response) {
		Citizens citi = new Citizens();
		ModelAndView mv = new ModelAndView();
		citi.setId(Integer.parseInt(request.getParameter("cid")));
		citi.setName(request.getParameter("cname"));
		citi.setCity(request.getParameter("cityname"));
		citi.setClinicname(request.getParameter("centername"));
		int dose = Integer.parseInt(request.getParameter("dose"));
		citi.setNoofdose(dose);
		if (dose == 0) {
			citi.setStatus("Not vaccinated");
		} else if (dose == 1) {
			citi.setStatus("Partially vaccinated");
		} else if (dose == 2) {
			citi.setStatus("Fully vaccinated");
		}
		Citizens ctzn = dao.updatecitz(citi);
		if (ctzn != null) {
			mv.setViewName("redirect:/citidash");
			return mv;
		} else {
			mv.setViewName("fail");
			return mv;
		}

	}

	@RequestMapping("/deleteciti")
	public ModelAndView delCit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteciti(id);
		mv.setViewName("redirect:/citidash");
		return mv;
	}

}