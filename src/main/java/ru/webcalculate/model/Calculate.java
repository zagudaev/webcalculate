package ru.webcalculate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.webcalculate.calculateForm.CalculateForm;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  //как этим пользоваться
@Entity
@Table(name = "database_calculate")
public class Calculate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_cookie")
    private String user_cookie;
    @Column(name = "example")
    private String example;
    @Column(name = "result")
    private String result;


}