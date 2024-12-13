package com.example.demo.ctr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.IscrittiDto;

import com.example.demo.dto.builder.IscrittiDtoBuilder;
import com.example.demo.model.Amministratori;
import com.example.demo.model.Iscritti;
import com.example.demo.repository.IscrittiRepository;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("iscritti")
public class IscrittiCtr {
	@Autowired
	private IscrittiRepository participantsRepo;
	@GetMapping("list")
	public String listOfParticipants(HttpSession session,Model model) {
		Amministratori admin =(Amministratori) session.getAttribute("loggedAdmin");
		if(admin==null) {
			return "redirect:/admin/login"; //reindirizza al login se non loggato
		}
		//se loggato mostra la lista degli iscritti
		List <IscrittiDto> iDto = IscrittiDtoBuilder.participantsFromEntityToDto(participantsRepo.findAll());
		model.addAttribute("participants", iDto);
		return "/views/iscritti/listaPartecipanti.jsp";
		
	}
	
	@GetMapping("search")
	public String searchParticipants(HttpSession session, Model model,@RequestParam("input") String input) {
		Amministratori admin = (Amministratori) session.getAttribute("loggedAdmin");
		if(admin==null) {
			return "redirect:/admin/login";
		}
		List<IscrittiDto> iDto = IscrittiDtoBuilder.participantsFromEntityToDto(participantsRepo.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(input, input));
		if(iDto.isEmpty()) {
			model.addAttribute("errore", "Nessun iscritto con questo nome");
			return"/views/iscritti/listaPartecipanti.jsp";
		}
		model.addAttribute("participants",iDto);
		return"/views/iscritti/listaPartecipanti.jsp";
	}
	@GetMapping("preInsertParticipants")
	public String preinsert (Model model) {
		IscrittiDto iDto = new IscrittiDto();
		model.addAttribute("insertForm", iDto);
		model.addAttribute("participantId", iDto.getId());
		return "/views/iscritti/inserisci.jsp";
	}
	@PostMapping("insertParticipants")
	public String insert(Model model, @ModelAttribute("insertForm") IscrittiDto iDto) {
		// Lista per raccogliere eventuali errori
	    List<String> errori = new ArrayList<>();

	    // Controlli sui campi
	    if (iDto.getOrganizationName() == null || iDto.getOrganizationName().trim().isEmpty()) {
	        errori.add("Inserisci il nome dell'organizzazione");
	    }
	    if (iDto.getName() == null || iDto.getName().trim().isEmpty()) {
	        errori.add("Inserisci il tuo nome");
	    }
	    if (iDto.getSurname() == null || iDto.getSurname().trim().isEmpty()) {
	        errori.add("Inserisci il tuo cognome");
	    }
	    if (iDto.getRole() == null || iDto.getRole().trim().isEmpty()) {
	        errori.add("Inserisci il tuo ruolo");
	    }
	    if (iDto.getNumber() == null || iDto.getNumber().trim().isEmpty()) {
	        errori.add("Inserisci il tuo numero di telefono");
	    }
	    if (iDto.getAddress() == null || iDto.getAddress().trim().isEmpty()) {
	        errori.add("Inserisci il tuo indirizzo");
	    }
	    if (iDto.getEmail() == null || iDto.getEmail().trim().isEmpty()) {
	        errori.add("Inserisci la tua email");
	    }
	    
	 // Se ci sono errori, aggiungili al modello e ricarica la pagina
	    if (!errori.isEmpty()) {
	        model.addAttribute("errori", errori);
	        return "/views/iscritti/inserisci.jsp";
	    }
		Iscritti i = IscrittiDtoBuilder.participantsFromDtoToEntity(iDto);
		 Iscritti savedEntity = participantsRepo.save(i);
		 model.addAttribute("participantId", savedEntity.getId());
		//participantsRepo.save(i);
		return "/views/iscritti/successIscritti.jsp";
	}
	
	@GetMapping("preUpdateParticipants/{id}")
	public String preUpdate(Model model, @PathVariable int id) {
		model.addAttribute("updateForm", IscrittiDtoBuilder.participantsFromEntitytoDto(participantsRepo.findById(id).orElse(new Iscritti())));
		return "/views/iscritti/aggiorna.jsp";
	}
	
	@PostMapping("updateParticipants")
	public String update(Model model, @ModelAttribute("updateForm") IscrittiDto iDto) {
		// Lista per raccogliere eventuali errori
	    List<String> errori = new ArrayList<>();

	    // Controlli sui campi
	    if (iDto.getOrganizationName() == null || iDto.getOrganizationName().trim().isEmpty()) {
	        errori.add("Inserisci il nome dell'organizzazione");
	    }
	    if (iDto.getName() == null || iDto.getName().trim().isEmpty()) {
	        errori.add("Inserisci il tuo nome");
	    }
	    if (iDto.getSurname() == null || iDto.getSurname().trim().isEmpty()) {
	        errori.add("Inserisci il tuo cognome");
	    }
	    if (iDto.getRole() == null || iDto.getRole().trim().isEmpty()) {
	        errori.add("Inserisci il tuo ruolo");
	    }
	    if (iDto.getNumber() == null || iDto.getNumber().trim().isEmpty()) {
	        errori.add("Inserisci il tuo numero di telefono");
	    }
	    if (iDto.getAddress() == null || iDto.getAddress().trim().isEmpty()) {
	        errori.add("Inserisci il tuo indirizzo");
	    }
	    if (iDto.getEmail() == null || iDto.getEmail().trim().isEmpty()) {
	        errori.add("Inserisci la tua email");
	    }
	    
	 // Se ci sono errori, aggiungili al modello e ricarica la pagina
	    if (!errori.isEmpty()) {
	        model.addAttribute("errori", errori);
	        return "/views/iscritti/aggiorna.jsp";
	    }
		Iscritti i = IscrittiDtoBuilder.participantsFromDtoToEntity(iDto);
		participantsRepo.save(i);
		return "/views/success.jsp";
	}
	
	@GetMapping("deleteParticipants/{id}")
	public String delete (@PathVariable int id) {
		participantsRepo.deleteById(id);
		return "/views/success.jsp";
	}
}
