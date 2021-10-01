package com.orangeblue.myboard.validator;

import com.orangeblue.myboard.domain.Board;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 *@title : BoardValidator
 *@author : wikyubok 
 *@date : "2021-10-02 00:03:29"
 *@description : 제공되는 validator 이외에 custom validator를 만든다. 
*/

@Component
public class BoardValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        Board board = (Board) obj;
        if (StringUtils.isEmpty(board.getContent())) {
            errors.rejectValue("content", "key", "내용을 입력하세요");
        }
    }
    
}
