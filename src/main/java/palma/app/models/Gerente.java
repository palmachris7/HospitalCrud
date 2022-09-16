package palma.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GERENTE")
public class Gerente {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 
	private Integer idgerente;
	private String descgerente;
	private Date fecharegistro;
    
    public Integer getIdgerente() {
        return idgerente;
    }
    public void setIdgerente(Integer idgerente) {
        this.idgerente = idgerente;
    }
    public String getDescgerente() {
        return descgerente;
    }
    public void setDescgerente(String descgerente) {
        this.descgerente = descgerente;
    }
    public Date getFecharegistro() {
        return fecharegistro;
    }
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    @Override
    public String toString() {
        return "Gerente [descgerente=" + descgerente + ", fecharegistro=" + fecharegistro + ", idgerente=" + idgerente
                + "]";
    }
    
    

	
}
