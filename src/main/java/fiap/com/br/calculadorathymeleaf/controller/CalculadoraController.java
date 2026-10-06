package fiap.com.br.calculadorathymeleaf.controller;

import fiap.com.br.calculadorathymeleaf.service.CalculadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("calculadora")
public class CalculadoraController {

    private final CalculadoraService service;
    public CalculadoraController(CalculadoraService service){
        this.service=service;
    }

    @GetMapping("calcular")
    public String calcular(int n1, int n2, String operacao, Model model){
        model.addAttribute("n1",n1);
        model.addAttribute("n2",n2);
        model.addAttribute("operacao",operacao);

        try{
          model.addAttribute("resultado",service.calcular(n1,n2,operacao));
        } catch (IllegalArgumentException e){
            model.addAttribute("erro",e.getMessage());
        }
        return "index";
    }
}
