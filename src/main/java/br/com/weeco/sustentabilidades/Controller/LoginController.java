package br.com.weeco.sustentabilidades.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody Credentials credentials) {
        // Verifique as credenciais de login
        if (credentials.getUsername().equals("admin") && credentials.getPassword().equals("password")) {
            // Crie um token de autenticação ou verifique se as credenciais estão corretas em um serviço de autenticação
            return ResponseEntity.ok().build(); // Retorna uma resposta HTTP 200 OK
        } else {
            // Retorne uma resposta HTTP 401 os dados estiverem incorretos
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // Definição de uma classe interna para interpretar a base de dados das credenciais
    private static class Credentials {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}