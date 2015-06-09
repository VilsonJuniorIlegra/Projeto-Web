package desafio3.dao;

import desafio3.model.Pessoa;

public class PessoaArrayDao implements PessoaDao{
	
	private static Pessoa[] pessoas = new Pessoa[10];
	
	@Override
	public Pessoa getByName(String nome) {
		int i = pesquisaIndexPeloNome(nome);
		return pessoas[i];
	}

	@Override
	public void save(Pessoa pessoa) {
		int index = pesquisaPosicaoNula();
		pessoas[index] = pessoa;
	}

	@Override
	public void update(Pessoa pessoa) {
		int i = pesquisaIndexPeloNome(pessoa.getNome());
		pessoas[i] = pessoa;
	}

	@Override
	public void deleteByName(String nome) {
		int i = pesquisaIndexPeloNome(nome);
		pessoas[i] = null;
	}
		
	@Override
	public Pessoa[] getAll() {
		return pessoas;
	}

	private int pesquisaIndexPeloNome(String nome){
		for(int i = 0; i < pessoas.length; i++){
			if(pessoas[i] != null && nome.equals(pessoas[i].getNome())){
				return i;
			}
		}
		return 99;
	}
	
	private int pesquisaPosicaoNula(){		
		for(int i = 0; i < pessoas.length; i++){
			if (pessoas[i] == null) {
				return i;
			}
		}
		return 99;
	}	
}
