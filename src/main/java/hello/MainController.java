package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.User;
import hello.UserRepository;

@Controller    // Indica que esta classe é um Controller.
@RequestMapping(path="/crud") // Faz com que a URL inicia com "/crud" (após o caminho da aplicação/domínio).
public class MainController {
	@Autowired // Chama o Bean de nome userRepository,
	           // O qual é gerado automaticamente pelo Spring, nós o usaremos para manipular os dados.
	private UserRepository userRepository;
	
	
	//TODO Estudar como criar uma classe de serviço. @Service
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String nome, @RequestParam String telefone) {
		// @ResponseBody indica que a String retornada é a resposta, e não o nome de uma View.
		// @RequestParam indica que ele é o parâmetro da requisição GET ou POST.
					
		User n = new User();
		n.setNome(nome);
		n.setTelefone(telefone);
		userRepository.save(n);
		return MsgsConstantes.SUCESSO;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// Isto retorna um JSON ou um XML com os usuários/registros.
		return userRepository.findAll();
	}
	
	@GetMapping(path="/getById")
	public @ResponseBody User getUserById(Long id) {
		// Isto retorna um usuário com a ID especificada.
		return userRepository.findById(id);
	}
	
	@GetMapping(path="/deleteById")
	public @ResponseBody String deleteUserById(Long id) {
		// Isto deleta um usuário/registro com a ID especificada.
		userRepository.delete(id);
		return MsgsConstantes.APAGADO;
	}
	
	@GetMapping(path="/updateById")
	public @ResponseBody String updateUserById(User user) {
		if (user.getId() == null) {
			return "Erro";
		}else{
			userRepository.save(user);
		}
		return MsgsConstantes.SUCESSO;
	}
}
