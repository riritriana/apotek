package com.tugas5.apotek.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tugas5.apotek.models.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>{
List<Login> findByUsernameAndPassword(String username, String password);
    
} 