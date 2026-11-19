package com.example.demo.Repository;

import com.example.demo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client,Long> {
}
