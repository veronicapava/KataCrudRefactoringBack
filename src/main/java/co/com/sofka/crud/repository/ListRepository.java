package co.com.sofka.crud.repository;

import co.com.sofka.crud.entities.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListEntity, Long> {
}
