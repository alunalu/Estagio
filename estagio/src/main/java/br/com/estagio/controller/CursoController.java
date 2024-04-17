package br.com.estagio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.estagio.service.CursoService;

@Controller
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/curso")
	public String curso(ModelMap model)
	{
		model.addAttribute("curso", cursoService.findAll());
		return "curso";
	}
	
	@GetMapping("/alterar_curso/{idCurso}")
	public ModelAndView update(ModelMap model,@PathVariable("idCurso") Long idCurso) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_curso");
		model.addAttribute("idCurso", idCurso);
		model.addAttribute("curso", cursoService.getOneByIdCurso(idCurso));
		
		return mv;
	}
	
	@GetMapping("/excluir_curso/{idCurso}")
	public ModelAndView delete(ModelMap model,@PathVariable("idCurso") Long idCurso,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/curso");
		model.addAttribute("mensagem",cursoService.deleteById(idCurso));
		model.addAttribute("curso",cursoService.findAll());
		
		return mv;
			
	}
	
	

}
