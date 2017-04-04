package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete.

public interface UserRepository extends CrudRepository<User, Long/*Integer*/> {
	/**
	 * Este método é responsável por listar um usuário por sua id
	 * @param id
	 * @return
	 */
	public User findById(Long id);
	// Equivalente à consulta SQL: SELECT * FROM User WHERE id = ?;
	 
}