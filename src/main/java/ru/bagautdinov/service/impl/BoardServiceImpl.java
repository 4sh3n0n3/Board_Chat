package ru.bagautdinov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.model.Board;
import ru.bagautdinov.repository.BoardRepository;
import ru.bagautdinov.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void addNewBoard(String name, String link) {
        Board board = new Board();
        board.setLink(link);
        board.setName(name);
        boardRepository.save(board);
    }
}
