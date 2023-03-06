package br.com.letscode.zoo.dto;

import br.com.letscode.zoo.model.Animal;
import br.com.letscode.zoo.model.Category;

public class FactoryDTO {

    public static CategoryDTO entityToDTO(Category category) {
        return new CategoryDTO(category.getUid(), category.getName());
    }

    public static AnimalDTO entityToDTO(Animal animal) {
        return new AnimalDTO(animal.getUid(), animal.getName(), animal.getAge());
    }
}
