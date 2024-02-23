package com.example.api2.model;

import com.example.api2.validators.EmailValidation;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;


@Getter
@Setter
@Entity
public class AtletaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    @NotEmpty(message = "The field nome is required.")
    private String nome;
    private Integer anoNascimento;
    private String esporte;
    @Email(message = "The field email is required.")
    @EmailValidation
    private String email;
    @CPF(message = "The field cpf is required.")
    private String cpf;

}



