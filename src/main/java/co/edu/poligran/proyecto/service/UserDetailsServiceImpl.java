package co.edu.poligran.proyecto.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.poligran.proyecto.model.Usuario;
import co.edu.poligran.proyecto.repository.UsuarioRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

	Usuario user = usuarioRepository.findByUserName(userName);

		if (user == null)
			throw new UsernameNotFoundException(userName);

		return new UserDetailsImpl(user);
	}

}
