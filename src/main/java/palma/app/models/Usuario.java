package palma.app.models;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idusuario")
	private Integer idusuario;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "estatus")
	private Integer estatus;	

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "UsuarioPerfil", 
			joinColumns = @JoinColumn(name = "idusuario"), 
			inverseJoinColumns = @JoinColumn(name = "idperfil") 
	)
	private List<Perfil> perfiles;

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	public void agregar(Perfil tempPerfil) {
		if (perfiles == null) {
			perfiles = new LinkedList<>();
		}
		perfiles.add(tempPerfil);
	}

}
