package br.com.gobbit.logistica.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class SaidaMaterial {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	@OneToMany
	List<Estoque> listaSaida;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataSaida;
	
	String destino;
	
	String entreguePara;
	
	String responsavel;

}
