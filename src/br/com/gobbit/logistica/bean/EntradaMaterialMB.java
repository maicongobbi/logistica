package br.com.gobbit.logistica.bean;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.gobbit.logistica.Dao.DAO;
import br.com.gobbit.logistica.modelo.Estoque;
import br.com.gobbit.logistica.modelo.Produto;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
public class EntradaMaterialMB {
	
	@Getter
	@Setter
	Produto produto;	
	
	@Getter
	@Setter
	Estoque estoque = new Estoque();

	/**
	 * montando um produto
	 */
	@Getter
	@Setter
	String produtoSelecionado; //id do mesmo para facilitar na busca
	
	@Getter
	@Setter
	String estado; //estado de conservação
	
	@Getter
	@Setter
	List<String> estadoProduto = new ArrayList<String>(); //lista de estados
	@Getter
	@Setter
	String quantidade;	
	@PostConstruct
	public void init()
	{	this.produtoDao =  new DAO<Produto>(Produto.class);
		this.listaProdutos = produtoDao.listaTodos();
		estadoProduto.add("Novo");
		estadoProduto.add("Usado - Bom");
		estadoProduto.add("Usado - Ruim");
		estadoProduto.add("Usado - precário");
		estadoProduto.add("baixado");
		
	}
	
	DAO<Produto> produtoDao ;
	
	@Getter
	@Setter
	List<Produto> listaProdutos;
	@Getter
	@Setter
	public List<String> produtosAdicionados = new ArrayList<String>();
	
	public void addProduto()
	{
		Produto p = new Produto();
		p.setId(Integer.parseInt(produtoSelecionado));
		listaProdutos.get(listaProdutos.indexOf(p));
		System.out.println("teste");
		System.out.println(produtosAdicionados.size());
		

		
		
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
