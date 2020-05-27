package com.powergym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.powergym.model.Log;
import com.powergym.model.Member;
import com.powergym.model.User;
import com.powergym.service.LogService;
import com.powergym.service.MemberService;
import com.powergym.service.UserService;

@Controller
public class AppController {

	@Autowired
	private LogService logService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String showLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/login-user")
	public String loginUser(User user, Model model) {
		if(userService.loginUser(user.getUsername(), user.getPassword()) != null) {
			model.addAttribute("user", user);
			return "redirect:/homepage";
		} else {
			model.addAttribute("message", "Invalid Username or Password!");
			return "login";
		}
	}
	
	@GetMapping("/homepage")
	public String showHomepage() {
		return "index";
	}
	
	@GetMapping("/add-member")
	public String showAddMemberForm(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "add-member";
	}
	
	@PostMapping("/save-member")
	public String saveMember(@ModelAttribute Member member, Model model) {
		memberService.saveMember(member);
		model.addAttribute("message", "Member Successfully Added!");
		Member newMember = new Member();
		model.addAttribute("member", newMember);
		return "add-member";
	}
	
	@GetMapping("/log-workout")
	public String showLogForm(Model model) {
		Log log = new Log();
		model.addAttribute("log", log);
		return "log-workout";
	}
	
	@PostMapping("/save-workout")
	public String saveWorkout(@ModelAttribute Log log, Model model) {
		logService.saveLog(log);
		model.addAttribute("message", "Workout Successfully Logged!");
		Log newLog = new Log();
		model.addAttribute("log", newLog);
		return "log-workout";
	}
	
	@GetMapping("/list-members")
	public String showListMembers(Model model) {
		model.addAttribute("members", memberService.findAllMembers());
		return "list-members";
	}
	
	@GetMapping("/list-logs")
	public String showWorkoutLogs(Model model) {
		model.addAttribute("logs", logService.findAllLogs());
		return "list-logs";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("message", "Logout Successful!");
		return "login";
	}
	
	
	
	
	
	
	
	
	
	
}
