package br.com.letscode.zoo.service;

import br.com.letscode.zoo.model.Category;
import br.com.letscode.zoo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> all() {
        return categoryRepository.findSortedHQL();
    }

}
