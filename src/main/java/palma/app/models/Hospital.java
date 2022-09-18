package palma.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "HOSPITAL")
public class Hospital {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idhospital;
	private String nombre;
	private Integer antiguedad;
	private Double area;
    private Date fecharegistro;

    @OneToOne
	@JoinColumn(name = "iddistrito") 
	private Distrito distrito; 

    @OneToOne
	@JoinColumn(name = "idgerente") 
	private Gerente gerente; 
    
    @OneToOne
	@JoinColumn(name = "idecondicion") 
	private Condicion condicion; 

    @OneToOne
	@JoinColumn(name = "idsede") 
	private Sede sede; 



}
