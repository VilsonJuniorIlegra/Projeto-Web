package desafio3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import desafio3.dao.PessoaArrayDao;
import desafio3.model.Pessoa;

@Controller
public class PessoaController{
	
	private PessoaArrayDao dao;
	
	public PessoaController() {
		dao = new PessoaArrayDao();
	}
	
	@RequestMapping(value="/formulario-pessoa", method=RequestMethod.GET)
	public String PessoaForm(){
		return "pessoa";
	}
	
	@RequestMapping(value="/salvar-pessoa", method=RequestMethod.POST)
	public String PessoaSubmit(Pessoa pessoa){
		dao.save(pessoa);
		return "pessoa";
	}
	
	@RequestMapping(value="/listar-pessoa", method=RequestMethod.GET)
	public String PessoaLista(Model model){
		Pessoa[] pessoas = dao.getAll();
		model.addAttribute("pessoas", pessoas);
		for(int i = 0; i < pessoas.length; i++){
			if(pessoas[i] != null){
				System.out.println(pessoas[i]);
			}
		}
		return "listarPessoa";
	}
	
}