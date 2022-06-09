package site.metacoding.blog_project_version_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogProjectVersion2Application {

	public static void main(String[] args) {
		SpringApplication.run(BlogProjectVersion2Application.class, args);
	}

}
