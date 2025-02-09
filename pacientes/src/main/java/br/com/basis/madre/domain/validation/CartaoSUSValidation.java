package br.com.basis.madre.domain.validation;

import br.com.basis.madre.domain.validation.annotation.CartaoSUS;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CartaoSUSValidation implements ConstraintValidator<CartaoSUS, String> {
    private static final int TAMANHO_NUM_CARTAO_SUS = 15;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null){
            return true;
        } else{
            if (s.length() == TAMANHO_NUM_CARTAO_SUS) {
                return somaPonderada(s) % 11 == 0;
            }
            return false;
        }
    }

    private int somaPonderada(String s) {
        char[] cs = s.toCharArray();
        int soma = 0;
        for (int i = 0; i < cs.length; i++) {
            soma += Character.digit(cs[i], 10) * (15 - i);
        }
        return soma;
    }

}
