package palma.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "GERENTE")
public class Gerente {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer idgerente;
	private String descgerente;
	private Date fecharegistro;
}
