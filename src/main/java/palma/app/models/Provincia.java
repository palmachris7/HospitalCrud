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
@Table(name = "PROVINCIA")
public class Provincia {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto_increment 
	private Integer idprovincia;
	private String descprovincia;
	private Date fecharegistro;

    
}
