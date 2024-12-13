package com.example.demo.ctr;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Amministratori;
import com.example.demo.repository.AmministratoriRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminCtr {
	@Autowired
	private AmministratoriRepository adminRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
	//pagina del login
	@GetMapping("login")
	public String loginPage() {
		return "/views/amministratori/login.jsp";
	}
	
	//gestione del login
	@PostMapping("login")
	public String login(@RequestParam("emailAdmin") String email, @RequestParam("password") String password,HttpSession session, Model model) {
		Optional<Amministratori> admin = adminRepo.findByEmailAdmin(email);
		if(admin.isPresent() && passwordEncoder.matches(password, admin.get().getPassword())) {
			session.setAttribute("loggedAdmin", admin.get());
			return "redirect:/iscritti/list";
		}else {
			model.addAttribute("errore","E-mail o password non corretti");
			return"/views/amministratori/login.jsp";
		}
	}
	
	/*	passwordEncoder.matches(password, admin.get().getPassword()):
		Verifica se la password in chiaro fornita dall'utente (password) corrisponde alla password criptata salvata nel database (admin.get().getPassword()).
		
		passwordEncoder.matches:
		Confronta la password non criptata con la versione criptata.
		Funziona anche se la password criptata è diversa ogni volta che viene generata (grazie al meccanismo di salt di BCrypt)*/
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); //invalida la sessione
		return "/views/amministratori/login.jsp";
	}
}
