package com.dragondevelopers.service.Impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dragondevelopers.entity.Phone;
import com.dragondevelopers.entity.User;
import com.dragondevelopers.repository.PhoneRepository;
import com.dragondevelopers.repository.UserRepository;
import com.dragondevelopers.service.UserService;
import com.dto.MessageDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
@RequiredArgsConstructor
public class UserImlp implements UserService {
    
    private final UserRepository userRepository;
    private final PhoneRepository phonesRepository;

    @Override
    public MessageDTO save(User u) {
        MessageDTO message = new MessageDTO();
		try {
            Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(u.getEmail());
            if (mather.find() != true) {
                message.setMensaje("El formato del correo ingresado no es válido."); 
                return message;
            }
            if(userRepository.findByEmail(u.getEmail())==null){
			    User userSaved = userRepository.save(u);
                for(Phone p: u.getPhones()){
                    p.setUser(userSaved);
                    phonesRepository.save(p);
                }
                message.setMensaje("Usuario guardado satisfactoriamente con id: " + userSaved.getId());
            }
            else {
                message.setMensaje("Este correo ya existe.");
            }
		}
		catch (Exception e){
            message.setMensaje("Error: " + e);
		}
        
		return message;

    }
    
}
