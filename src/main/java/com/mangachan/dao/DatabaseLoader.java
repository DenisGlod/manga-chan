package com.mangachan.dao;

import com.mangachan.dao.entity.Role;
import com.mangachan.dao.entity.RoleEnum;
import com.mangachan.dao.entity.User;
import com.mangachan.dao.repository.RoleRepository;
import com.mangachan.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

/*
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('MODERATOR');
INSERT INTO role (name) VALUES ('USER');

-- INSERT INTO user_data(age, first_name, last_name, middle_name) VALUES ('1991-02-05', 'Евгений', 'Сидоренко', 'Иванович');
-- INSERT INTO user_data(age, first_name, last_name, middle_name) VALUES ('1993-01-08', 'Михаил', 'Петров', 'Евгеньевич');
-- INSERT INTO user_data(age, first_name, last_name, middle_name) VALUES ('1995-12-10', 'Юрий', 'Астапенко', 'Валентинович');
-- INSERT INTO user_data(age, first_name, last_name, middle_name) VALUES ('2000-03-14', 'Валерий', 'Нитко', 'Леонидович');
-- INSERT INTO user_data(age, first_name, last_name, middle_name) VALUES ('1999-04-15', 'Иван', 'Чуп', 'Иванович');

INSERT INTO "user" (email, username, password, role_id, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('admin@freebook.test', 'admin', '$2y$12$o76w3/iVUBvaK2gBa8RC7OoexJEVGOG5YMwYROr024c3WAAEuTO3y', 1, true, true, true, true);
INSERT INTO "user" (email, username, password, role_id, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('moderator1@freebook.test', 'moderator1', '$2y$12$mm5ux4CepGKW1ILBKO/E8ODTxRmDDilcIrwsZ2Zju3Z/70DPl9FrW', 2, true, true, true, true);
INSERT INTO "user" (email, username, password, role_id, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('moderator2@freebook.test', 'moderator2', '$2y$12$0CAkzZsGtAe22xyL6guEAe2vvmU0RxJD9rUiYsJmva64hkMNAeuRe', 2, true, true, true, true);
INSERT INTO "user" (email, username, password, role_id, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('user1@freebook.test', 'user1', '$2y$12$h3MLCMEKTgdAMu10baOmGePqNjrr7ZOxamemDVNlJnUowfc94vZ0u', 3, true, true, true, true);
INSERT INTO "user" (email, username, password, role_id, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('user2@freebook.test', 'user2', '$2y$12$McmPBG3ViZHs3W2FYm98uO8oU7wfZSxDeVl9B0A8T4sIq4L9g5Rmi', 3, true, true, true, true);

-- INSERT INTO book(name, author, publisher, binding, age_restrictions, isbn, publishing_year, description) VALUES ('Философия Java', 'Брюс Эккель', 'Питер', 'Твердый переплет', '16+', '978-5-4461-1107-7', 2019, 'Впервые читатель может познакомиться с полной версией этого классического труда, который ранее на русском языке печатался в сокращении. Книга, выдержавшая в оригинале не одно переиздание, за глубокое и поистине философское изложение тонкостей языка Java считается одним из лучших пособий для программистов. Чтобы по-настоящему понять язык Java, необходимо рассматривать его не просто как набор неких команд и операторов, а понять его «философию», подход к решению задач, в сравнении с таковыми в других языках программирования. На этих страницах автор рассказывает об основных проблемах написания кода: в чем их природа и какой подход использует Java в их разрешении. Поэтому обсуждаемые в каждой главе черты языка неразрывно связаны с тем, как они используются для решения определенных задач.');
-- INSERT INTO book(name, author, publisher, binding, age_restrictions, isbn, publishing_year, description) VALUES ('1984', 'Джордж Оруэлл', 'АСТ', 'Твердый переплет', '16+', '978-5-17-103595-2', 2019, 'Своеобразный антипод второй великой антиутопии XX века - "О дивный новый мир" Олдоса Хаксли. Что, в сущности, страшнее: доведенное до абсурда "общество потребления" - или доведенное до абсолюта "общество идеи"? По Оруэллу, нет и не может быть ничего ужаснее тотальной несвободы...');
-- INSERT INTO book(name, author, publisher, binding, age_restrictions, isbn, publishing_year, description) VALUES ('Краткие ответы на большие вопросы', 'Стивен Хокинг', 'Эксмо', 'Твердый переплет', '16+', '978-5-04-099443-4', 2019, 'Стивен Хокинг, величайший ученый современности, изменил наш мир. Его уход - огромная потеря для человечества. В своей финальной книге, над которой Стивен Хокинг работал практически до самого конца, великий физик делится с нами своим отношением к жизни, цивилизации, времени, Богу, к глобальным вещам, волнующим каждого из нас. Перед вами книга-сенсация, книга-завещание, последний труд всемирно известного физика Стивена Хокинга, в которой он подводит некий итог и высказывается по самым главным вопросам, волнующим всех. Выживет ли человечество? Должны ли мы так активно внедряться в космос? Есть ли Бог? Это лишь некоторые из вопросов, на которые отвечает Стивен Хокинг, один из величайших умов в истории, в своей финальной книге. В книгу включены воспоминания оскароносца Эдди Редмэйна, игравшего Стивена Хокинга, Нобелевского лауреата Кипа Торна и дочери Хокинга, Люси.');
 */

	@Override
	public void run(String... args) {
		List<Role> roles = saveRoles();
		saveUsers(roles);
	}

	private void saveUsers(List<Role> roles) {
		this.userRepository.saveAll(
				Arrays.asList(
						User.builder()
								.email("admin@freebook.test")
								.username("admin")
								.password("$2y$12$o76w3/iVUBvaK2gBa8RC7OoexJEVGOG5YMwYROr024c3WAAEuTO3y")
								.authorities(List.of(roles.get(0)))
								.enabled(true)
								.accountNonExpired(true)
								.accountNonLocked(true)
								.credentialsNonExpired(true)
								.build(),
						User.builder()
								.email("moderator1@freebook.test")
								.username("moderator1")
								.password("$2y$12$mm5ux4CepGKW1ILBKO/E8ODTxRmDDilcIrwsZ2Zju3Z/70DPl9FrW")
								.authorities(List.of(roles.get(1)))
								.enabled(true)
								.accountNonExpired(true)
								.accountNonLocked(true)
								.credentialsNonExpired(true)
								.build(),
						User.builder()
								.email("moderator2@freebook.test")
								.username("moderator2")
								.password("$2y$12$0CAkzZsGtAe22xyL6guEAe2vvmU0RxJD9rUiYsJmva64hkMNAeuRe")
								.authorities(List.of(roles.get(1)))
								.enabled(true)
								.accountNonExpired(true)
								.accountNonLocked(true)
								.credentialsNonExpired(true)
								.build()
				)
		);
	}

	private List<Role> saveRoles() {
		return this.roleRepository.saveAll(
				Arrays.asList(
						Role.builder().name(RoleEnum.ADMIN).build(),
						Role.builder().name(RoleEnum.MODERATOR).build(),
						Role.builder().name(RoleEnum.USER).build()
				)
		);
	}
}
