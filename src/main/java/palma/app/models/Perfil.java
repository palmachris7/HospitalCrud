package palma.app.models;
import javax.persistence.Column;
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
	@Column(name = "idperfil")
	private Integer idPerfil;
	@Column(name = "perfil")
	private String perfil;
}
