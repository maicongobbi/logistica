package br.com.gobbit.logistica.bean;

import javax.faces.bean.ManagedBean;

import br.com.gobbit.logistica.Dao.DAO;
import br.com.gobbit.logistica.modelo.Estoque;
import br.com.gobbit.logistica.modelo.Produto;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
public class ProdutoMB {
	
	@Getter
	@Setter
	Produto produto;
	


	DAO<Produto> produtoDao;
	public ProdutoMB() {
		super();
		this.produto = new Produto();
		produtoDao = new DAO<Produto>(Produto.class);
	}
	
	

	public String gravar()
	{
		produtoDao.adiciona(this.produto);
		System.out.println(produto.getDescricao());	
		return "produto?faces-redirect=true";
	}	
	public void teste(String s){
		System.out.println(s);
	}
	
}
