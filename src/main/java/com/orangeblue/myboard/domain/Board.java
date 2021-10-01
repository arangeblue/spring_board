package com.orangeblue.myboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


/**
 *@title : Board
 *@author : wikyubok 
 *@date : "2021-10-01 20:31:47"
 *@description : 
*/

@Entity
@Getter
@Setter
public class Board extends BaseTime{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50, message = "제목은 2자에서 50자 이하이어야 합니다.")
    @Column(name = "board_title", length = 50, nullable = false)
    private String title;

    @NotEmpty
    @Size(min = 1, max = 500)
    @Column(name = "board_content", length = 500, nullable = false)
    private String content;

    @NotEmpty
    @Size(min = 2, max = 50)
    @Column(name = "board_writer", length = 50, nullable = false)
    private String writer;

    @Column(name = "hits")
    private int hits;

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Board() {

    }
    

}
