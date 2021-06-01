package org.serratec.backend.repository;

import org.serratec.backend.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long>{

//	@Query("Select * from livro l where l.autor = :autor  order by l.autor")
//	public List<LivroEntity> buscarLivro(@Param("autor")String autor);
	
}
