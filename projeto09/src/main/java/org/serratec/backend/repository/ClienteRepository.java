package org.serratec.backend.repository;

import org.serratec.backend.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
//	@Query("FROM ClienteEntiy c ORDER BY :nome")
//	List<ClienteEntity> findCustom(@Param("nome") String nome);
}
