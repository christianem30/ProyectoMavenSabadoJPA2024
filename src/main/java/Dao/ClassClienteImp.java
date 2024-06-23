package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.ICliente;
import model.TblCliente;

public class ClassClienteImp  implements ICliente  {

	@Override
	public void RegistrarCliente(TblCliente cliente) {
		//establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
	    //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(cliente);
		//emitimos mensaje por consola
		System.out.println("cliente registrado en la BD correctamente");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion
		em.close();
	}  //fin del metodo registrar...

	@Override
	public void ActualizarCliente(TblCliente cliente) {
		//establecer conexion con la unidad de psersistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		 //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
				em.getTransaction().begin();
				//registramos
				em.merge(cliente);
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
		
	}   //fin del metodo actualizar cliente..

	@Override
	public void EliminarCliente(TblCliente cliente) {
	//establecer conexion con la unidad de psersistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		 //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblCliente elim=em.merge(cliente);
		//eliminamos registro
		em.remove(elim);
		//emitimimos mensaje por consola
		System.out.println("Cliente eliminado de la bd");
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		
		
	}   //fin del metodo eliminar cliente...

	@Override
	public TblCliente BuscarCliente(TblCliente cliente) {
		//establecer conexion con la unidad de psersistencia
	EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
        //permite gestionar entidades
	EntityManager em=fabr.createEntityManager();
	//iniciar transaccion
			em.getTransaction().begin();
			//recuperamos el codigo a buscar
			TblCliente buscliente= em.find(TblCliente.class,cliente.getIdcliente());
			//confirmamos
			em.getTransaction().commit();
			//cerramos
			em.close();
			return buscliente;
	
				
	}  //fin del metodo buscar cliente...

	@Override
	public List<TblCliente> ListadoCliente() {
		//establecer conexion con la unidad de psersistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		//gestionamos las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos los clientes de la bd
		//****utilizando jpql
		List<TblCliente> listadoclientes=em.createQuery("select c from TblCliente c",TblCliente.class).getResultList();
		//confirmamos la trasnaccion
		em.getTransaction().commit();
		//cerramos
		em.close();
		
		return listadoclientes;
		
	}   //fin del metodo listado cliente.. 

}
