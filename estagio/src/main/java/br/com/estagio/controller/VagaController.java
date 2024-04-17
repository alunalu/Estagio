package br.com.estagio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.estagio.service.VagaService;

@Controller
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	@GetMapping("/vaga")
	public String vaga(ModelMap model)
	{
		model.addAttribute("vaga", vagaService.findAll());
		return "vaga";
	}
	
	@GetMapping("/alterar_vaga/{idVaga}")
	public ModelAndView update(ModelMap model,@PathVariable("idVaga") Long idVaga) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_vaga");
		model.addAttribute("idVaga", idVaga);
		model.addAttribute("vaga", vagaService.getOneByIdVaga(idVaga));
		
		return mv;
	}
	
	@GetMapping("/excluir_vaga/{idVaga}")
	public ModelAndView delete(ModelMap model,@PathVariable("idVaga") Long idVaga,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/vaga");
		model.addAttribute("mensagem",vagaService.deleteById(idVaga));
		model.addAttribute("vaga",vagaService.findAll());
		
		return mv;
			
	}

}
