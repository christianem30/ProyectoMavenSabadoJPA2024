package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_tipoproducto database table.
 * 
 */
@Entity
@Table(name="tbl_tipoproducto")
@NamedQuery(name="TblTipoproducto.findAll", query="SELECT t FROM TblTipoproducto t")
public class TblTipoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipopro;

	private String descripcion;

	//bi-directional many-to-one association to TblProducto
	@OneToMany(mappedBy="tblTipoproducto")
	private List<TblProducto> tblProductos;

	public TblTipoproducto() {
	}

	public int getIdtipopro() {
		return this.idtipopro;
	}

	public void setIdtipopro(int idtipopro) {
		this.idtipopro = idtipopro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TblProducto> getTblProductos() {
		return this.tblProductos;
	}

	public void setTblProductos(List<TblProducto> tblProductos) {
		this.tblProductos = tblProductos;
	}

	public TblProducto addTblProducto(TblProducto tblProducto) {
		getTblProductos().add(tblProducto);
		tblProducto.setTblTipoproducto(this);

		return tblProducto;
	}

	public TblProducto removeTblProducto(TblProducto tblProducto) {
		getTblProductos().remove(tblProducto);
		tblProducto.setTblTipoproducto(null);

		return tblProducto;
	}

}