package br.com.letscode.zoo.config;

import br.com.letscode.zoo.model.Category;
import br.com.letscode.zoo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
@AllArgsConstructor
public class CategoryDBConfig {
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void initDB() {
        Category category1 = new Category();
        category1.setUid(UUID.randomUUID().toString());
        category1.setName("Peixe");
        categoryRepository.saveAndFlush(category1);
        Category category2 = new Category();
        category2.setUid(UUID.randomUUID().toString());
        category2.setName("Mamífero");
        categoryRepository.saveAndFlush(category2);
        Category category3 = new Category();
        category3.setUid(UUID.randomUUID().toString());
        category3.setName("Ave");
        categoryRepository.saveAndFlush(category3);
    }

}
