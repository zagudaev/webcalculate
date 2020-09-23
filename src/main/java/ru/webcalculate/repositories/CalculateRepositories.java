package ru.webcalculate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webcalculate.model.Calculate;

import java.util.List;

public interface CalculateRepositories extends JpaRepository<Calculate, Long> {

    public List<Calculate> findAllByUser_cookie(String user_cookie);

}
