package palma.app.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "PERFIL")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idperfil;
	private String perfil;
}
