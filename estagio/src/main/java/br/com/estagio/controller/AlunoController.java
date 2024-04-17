package br.com.estagio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.estagio.service.AlunoService;

@Controller
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/aluno")
	public String aluno(ModelMap model)
	{
		model.addAttribute("aluno", alunoService.findAll());
		return "aluno";
	}
	
	@GetMapping("/alterar_aluno/{idAluno}")
	public ModelAndView update(ModelMap model,@PathVariable("idAluno") Long idAluno) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_aluno");
		model.addAttribute("idAluno", idAluno);
		model.addAttribute("aluno", alunoService.getOneByIdAluno(idAluno));
		
		return mv;
	}
	
	@GetMapping("/excluir_aluno/{idAluno}")
	public ModelAndView delete(ModelMap model,@PathVariable("idAluno") Long idAluno,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/aluno");
		model.addAttribute("mensagem",alunoService.deleteById(idAluno));
		model.addAttribute("aluno",alunoService.findAll());
		
		return mv;
			
	}
}