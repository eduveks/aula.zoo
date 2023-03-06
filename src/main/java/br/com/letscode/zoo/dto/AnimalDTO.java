package br.com.letscode.zoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalDTO {

    private String uid;
    private String name;
    private int age;
}
