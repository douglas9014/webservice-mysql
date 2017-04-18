<<<<<<< HEAD
package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete.

public interface UserRepository extends CrudRepository<User, Integer> {

}
=======
package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete.

public interface UserRepository extends CrudRepository<User, Long/*Integer*/> {
	
}
>>>>>>> 132ca0a0187f519ec563c15f60a9629b9d986fb9
