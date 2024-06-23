package TestEntidades;

import java.util.List;

import Dao.ClassClienteImp;
import model.TblCliente;

public class TestEntidadCliente {

	public static void main(String[] args) {
		//realizamos la respectiva instancia de las clases...
		TblCliente cliente=new TblCliente();
		ClassClienteImp crud=new ClassClienteImp();
		//asignamos valores
		/*cliente.setNombre("nilson ronaldo");
		cliente.setApellido("ramirez ramirez");
		cliente.setDni("1045789");
		cliente.setEmail("nilson@gmail.com");
		cliente.setTelf("3871459");
		cliente.setSexo("M");
		cliente.setNacionalidad("argentina");
		//invocamos al metodo registrar...
		crud.RegistrarCliente(cliente); */

		//TESTEANDO LISTADO
		List<TblCliente> listado=crud.ListadoCliente();
		//aplicamos un bucle for...
		for(TblCliente lis:listado) {
			//imprimimos por pantalla
			System.out.println("nombre: "+lis.getNombre()+" apellido: "+lis.getApellido()+
					" DNI: "+lis.getDni()+
					" email: "+lis.getEmail()+
					" telef: "+lis.getTelf()+
					" sexo: "+lis.getSexo()+
					" nacionalidad: "+lis.getNacionalidad());
			
		}
	}   //fin del metodo main...

} //fin de la clase...
