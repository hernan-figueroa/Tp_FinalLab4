package entidades;

public class TipoMovimiento {

	public Long id;
	public String Descripcion;
	
	public TipoMovimiento() {
		
	}
	
	public TipoMovimiento(Long idTipoMovimiento, String Descripcion) {
		this.id = idTipoMovimiento;
		this.Descripcion = Descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
