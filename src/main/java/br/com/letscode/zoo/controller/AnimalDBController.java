package br.com.letscode.zoo.controller;

import br.com.letscode.zoo.dto.AnimalDTO;
import br.com.letscode.zoo.dto.FactoryDTO;
import br.com.letscode.zoo.exception.NotFoundException;
import br.com.letscode.zoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal-db")
@AllArgsConstructor
public class AnimalDBController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalDBController.class);
    private AnimalService animalService;

    @GetMapping("/{uid}")
    public ResponseEntity<AnimalDTO> getByUid(@PathVariable(value = "uid") String uid) {
        try {
            return ResponseEntity.ok(FactoryDTO.entityToDTO(
                    animalService.findByUid(uid)
            ));
        } catch (NotFoundException e) {
            LOGGER.warn(e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AnimalDTO animalDTO) {
        var animal = FactoryDTO.dtoToEntity(animalDTO);
        try {
            animalService.create(animal);
            return ResponseEntity.ok(FactoryDTO.entityToDTO(animal));
        } catch (NotFoundException e) {
            LOGGER.warn(e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody AnimalDTO animalDTO) {
        var animal = FactoryDTO.dtoToEntity(animalDTO);
        try {
            animalService.update(animal);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            LOGGER.warn(e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity remove(@RequestParam("uid") String uid) {
        try {
            animalService.remove(uid);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            LOGGER.warn(e.toString());
            return ResponseEntity.notFound().build();
        }
    }
}
