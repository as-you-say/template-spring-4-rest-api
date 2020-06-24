package org.example.template.api.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.template.model.Account;
import org.example.template.model.Board;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectBoardList(Board board);
    Board selectBoardById(Board board);
    int insertBoard(Board board);
    int updateBoard(Board board);
    int deleteBoard(Board board);
}
