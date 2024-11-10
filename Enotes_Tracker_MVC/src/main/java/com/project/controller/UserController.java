package com.project.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.UserDAO;
import com.project.entity.Notes;
import com.project.entity.User;

@Controller
@RequestMapping("/user/")
public class UserController 
{
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping("/addNotes")
	public String addNotes() {
		return "addNotes";
	}
	@RequestMapping("/viewNotes")
	public String viewNotes(HttpSession session, Model m) {
		User u = (User) session.getAttribute("userObj");
		List<Notes> noteslist = userDao.getNotesByUser(u);
		m.addAttribute("noteslist", noteslist);
		return "viewNotes";
	} 
	@RequestMapping("/editNotes")
	public String editNotes(@RequestParam int id, Model m) {
		Notes n = userDao.getNotesById(id);
		m.addAttribute("notes", n);
		return "editNotes";
	}
	
	@RequestMapping("/updateNotes")
	public String updateNotes(@ModelAttribute Notes n, HttpSession session)
	{
		User u = (User)session.getAttribute("userObj");
		n.setUser(u);
		n.setDate(LocalDate.now().toString());
		userDao.updateNotes(n);
		session.setAttribute("msg", "Updated Successfully");
		return "redirect:/user/viewNotes";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Successfully");
		return "redirect:/login";
	}
	@RequestMapping(path = "/saveNotes", method= RequestMethod.POST)
	public String saveNotes(@ModelAttribute Notes n, HttpSession session) {
		User u = (User) session.getAttribute("userObj");
		n.setUser(u);
		n.setDate(LocalDate.now().toString());
		userDao.saveNotes(n);
		session.setAttribute("msg", "Notes Added Successfully");
		return "redirect:/user/addNotes";
	}
	
	@RequestMapping("/deleteNotes")
	public String deleteNotes(@RequestParam int id,HttpSession session)
	{
		userDao.deleteNotes(id);
		session.setAttribute("msg", "Notes Deleted Sucessfully");
		return "redirect:/user/viewNotes";
	}
	
	@RequestMapping("/{garbageValue}")
    public String handleLogin(@PathVariable String garbageValue) {
     
		if(garbageValue.equalsIgnoreCase("deleteNotes") == false || 
		   garbageValue.equalsIgnoreCase("saveNotes") == false   ||
		   garbageValue.equalsIgnoreCase("logout") == false      ||
		   garbageValue.equalsIgnoreCase("updateNotes") == false ||
		   garbageValue.equalsIgnoreCase("editNotes") == false   ||
		   garbageValue.equalsIgnoreCase("viewNotes") == false   ||
		   garbageValue.equalsIgnoreCase("addNotes") == false)   
          return "redirect:/login"; 
        
        return "redirect:/login";
        
    }
	
}
