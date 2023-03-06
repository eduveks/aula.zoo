package br.com.letscode.zoo.repository;

import br.com.letscode.zoo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // HQL
    @Query(value="SELECT c FROM Category c ORDER BY c.name")
    List<Category> findSortedHQL();

    // NATIVE
    @Query(value="SELECT * FROM category ORDER BY name", nativeQuery = true)
    List<Category> findSortedNative();
}
