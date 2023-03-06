package br.com.letscode.zoo.controller;

import br.com.letscode.zoo.component.CategoryComponent;
import br.com.letscode.zoo.dto.CategoryDTO;
import br.com.letscode.zoo.dto.FactoryDTO;
import br.com.letscode.zoo.model.Category;
import br.com.letscode.zoo.repository.CategoryRepository;
import br.com.letscode.zoo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryDTO> list() {
        return categoryService.all().stream()
                .map(FactoryDTO::entityToDTO)
                .collect(Collectors.toList());
    }
}
