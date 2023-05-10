package util.validacoes;

import java.util.InputMismatchException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataCpfValidator implements ConstraintValidator<DataCpf, Object> {
   
  public boolean somenteNumeros(Object value) {
        return value != null && value.trim().matches("[0-9]*");
  }
  
  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (!somenteNumeros(value)) {
            return false;
        }

        // considera-se erro CPF's formados por uma sequencia de números iguais
        if (value.equals("00000000000") || value.equals("11111111111") || 
                value.equals("22222222222") || value.equals("33333333333") || 
                value.equals("44444444444") || value.equals("55555555555") || 
                value.equals("66666666666") || value.equals("77777777777") || 
                value.equals("88888888888") || value.equals("99999999999") || (value.length() != 11)) {
            return (false);
        }

        char digito10, digito11;
        int soma;
        int resultado;
        int num;
        int peso;

        try {

            // Calculo do 1º Digito Verificador
            soma = 0;
            peso = 10;
            for (int i = 0; i < 9; i++) {
                num = (int) (value.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso - 1;
            }

            resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11)) {
                digito10 = '0';
            } else {
                digito10 = (char) (resultado + 48); // converte no respectivo caractere numerico
            }
            
            // Calculo do 2º Digito Verificador
            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                num = (int) (value.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso - 1;
            }

            resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11)) {
                digito11 = '0';
            } else {
                digito11 = (char) (resultado + 47); 
            }

            // Verifica se os dígitos verificadores calculados conferem com os dígitos informados.
            if ((digito10 == value.charAt(9)) && (digito11 == value.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}