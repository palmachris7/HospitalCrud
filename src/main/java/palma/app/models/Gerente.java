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
	private Integer idGerente;
	private String desGerente;
	private Date fechaRegistro;
    
    public Integer getIdGerente() {
        return idGerente;
    }
    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }
    public String getDesGerente() {
        return desGerente;
    }
    public void setDesGerente(String desGerente) {
        this.desGerente = desGerente;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    @Override
    public String toString() {
        return "Gerente [desGerente=" + desGerente + ", fechaRegistro=" + fechaRegistro + ", idGerente=" + idGerente
                + "]";
    }

	
}
