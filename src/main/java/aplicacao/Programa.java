package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin(); //iniciar transa��o		
		em.persist(p2); //Inserir		
		Pessoa p = em.find(Pessoa.class, 2); //Busca uma pessoa que o id seja igual a 2
		System.out.println(p); 		
		em.remove(p); //remove
		em.getTransaction().commit(); //encerrar transa��o
		em.close();
		emf.close();		
		
		System.out.println("Pronto!");

	}

}
