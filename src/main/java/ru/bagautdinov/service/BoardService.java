package ru.bagautdinov.service;

import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    void addNewBoard(String name, String link);
}
