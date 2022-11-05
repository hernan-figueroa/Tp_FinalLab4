package entidades;

public class TipoUsuario {
	
	public Long id;
	public String descripcion;
	
	public TipoUsuario() {
	}

	public TipoUsuario(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoUsuario [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
