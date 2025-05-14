package com.example.demo.data.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorsoDTO {

    private Long id;

    private String nome;

    private Integer annoAccademico;


}
