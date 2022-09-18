package palma.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DISTRITO")
public class Distrito {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer iddistrito;
	private String descdistrito;
	private Date fecharegistro;

	@ManyToOne
    @JoinColumn(name = "idProvincia")
    Provincia provincia;

}
