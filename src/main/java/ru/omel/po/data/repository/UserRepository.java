package ru.omel.po.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.omel.po.data.entity.Client;

public interface UserRepository extends JpaRepository<Client, Integer> {
}