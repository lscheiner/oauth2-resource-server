package br.com.scheiner.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
	

	@PreAuthorize("isAuthenticated()")  
    @GetMapping("/users/autenticado")
    public String[] getUsuariosAutenticado() {
        return new String[] { "Joao", "Maria", "Pedro" };
    }
	
	@PreAuthorize("hasAuthority('SCOPE_usuarios.read')")  
    @GetMapping("/users/scope/read")
    public String[] getUsersRead() {
        return new String[] { "Joao", "Maria", "Pedro" };
    }

	@PreAuthorize("hasAuthority('SCOPE_usuarios.teste')")  
    @GetMapping("/users/scope/forbidden")
    public String[] getUsersTeste() {
        return new String[] { "Joao", "Maria", "Pedro" };
    }
}
