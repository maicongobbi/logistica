package br.com.gobbit.logistica.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
/**
 * classe referente a um produto em estoque
 * @author m41c00n
 *
 */
public class Estoque {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	@OneToMany(mappedBy="estoque", fetch=FetchType.EAGER)	
	List <Produto> produtos;	
	
	String documento;	
	
	@Temporal(TemporalType.DATE)//somenrte data, sem hora
	private Calendar data;	
	
	@Temporal(TemporalType.DATE)
	private Calendar vencimento;
	
	
	


}
