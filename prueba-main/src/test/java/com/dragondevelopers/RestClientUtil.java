
package com.dragondevelopers;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dragondevelopers.entity.Phone;
import com.dragondevelopers.entity.User;
import com.dragondevelopers.service.UserService;
import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RestClientUtil {

	@Autowired
	private UserService userService;

	@Test
	void testResponseNotNull() {

		User user = new User();
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		List<Phone> phones = new ArrayList();
		phones.add(phone1);
		phones.add(phone2);
		user.setEmail("aaa@aaa.cl");
		user.setPhones(phones);

		assertThat(userService.save(user).getMensaje()).isNotNull();
	}

	@Test
	void testMailNotValid() {

		User user = new User();
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		List<Phone> phones = new ArrayList();
		phones.add(phone1);
		phones.add(phone2);
		user.setEmail("aaaaaa");
		user.setPhones(phones);

		assertThat(userService.save(user).getMensaje()).isEqualTo("El formato del correo ingresado no es válido.");
	}

}