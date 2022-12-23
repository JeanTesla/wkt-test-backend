package com.example.test.domain.dto.request;

import com.example.test.domain.entity.Candidate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CandidatesRequestDTO {

    private String nome;

    private String cpf;

    private String rg;

    @JsonProperty(value = "data_nasc")
    @NotBlank(message = "A data de nascimento é obrigatória.")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Formato inválido, use dd/MM/yyyy.")
    private String dataNasc;

    @NotNull
    @Pattern(regexp="^(Feminino|Masculino)$",message="O sexo deve ser Feminino ou Masculino.")
    private String sexo;

    private String mae;

    private String pai;

    private String email;

    private String cep;

    private String endereco;

    private Integer numero;

    private String bairro;

    private String cidade;

    @NotBlank(message = "O estado é obrigatório.")
    private String estado;

    @JsonProperty(value = "telefone_fixo")
    private String telefoneFixo;

    private String celular;

    @NotNull
    @Positive
    private Double altura;

    @NotNull
    @Positive
    private Double peso;

    @JsonProperty(value = "tipo_sanguineo")
    @NotBlank(message = "O tipo sanguineo é obrigatório")
    @Pattern(regexp="^(A\\+|A\\-|B\\+|B\\-|AB\\+|AB\\-|O\\+|O\\-)$", message="Tipo sanguineo inválido.")
    private String tipoSanguineo;


    public static Candidate toEntity(CandidatesRequestDTO candidatesRequestDTO) throws ParseException {
        return Candidate.builder()
                .name(candidatesRequestDTO.getNome())
                .cpf(candidatesRequestDTO.getCpf())
                .rg(candidatesRequestDTO.getRg())
                .birthDate(stringToDate(candidatesRequestDTO.getDataNasc()))
                .sex(candidatesRequestDTO.getSexo())
                .mother(candidatesRequestDTO.getMae())
                .father(candidatesRequestDTO.getPai())
                .email(candidatesRequestDTO.getEmail())
                .zipCode(candidatesRequestDTO.getCep())
                .address(candidatesRequestDTO.getEndereco())
                .number(candidatesRequestDTO.getNumero())
                .district(candidatesRequestDTO.getBairro())
                .city(candidatesRequestDTO.getCidade())
                .state(candidatesRequestDTO.getEstado())
                .landline(candidatesRequestDTO.getTelefoneFixo())
                .cell(candidatesRequestDTO.getCelular())
                .height(candidatesRequestDTO.getAltura())
                .weight(candidatesRequestDTO.getPeso())
                .bloodType(candidatesRequestDTO.getTipoSanguineo())
                .build();
    }

    private static Date stringToDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
    }

}
