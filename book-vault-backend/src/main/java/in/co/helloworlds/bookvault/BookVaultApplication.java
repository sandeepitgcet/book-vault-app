package in.co.helloworlds.bookvault;

import in.co.helloworlds.bookvault.role.Role;
import in.co.helloworlds.bookvault.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookVaultApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}
}
