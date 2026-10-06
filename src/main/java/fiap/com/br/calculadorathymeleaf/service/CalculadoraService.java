package fiap.com.br.calculadorathymeleaf.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CalculadoraService {

    public double calcular(int n1, int n2, String operacao){
        return switch (operacao){
            case "soma"->n1+n2;
            case "subtracao"->n1-n2;
            case "multiplicacao"->n1*n2;
            case "divisao"->dividir(n1,n2);

            default -> throw new IllegalArgumentException("ERRO: operação inválida");
        };
    }

    private double dividir(int n1, int n2){
        if (n2==0){
            throw new IllegalArgumentException("ERRO: divisão impossível");
        }
        return (double) n1/n2;
    }
}
