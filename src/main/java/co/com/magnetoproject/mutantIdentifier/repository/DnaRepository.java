package co.com.magnetoproject.mutantIdentifier.repository;

import co.com.magnetoproject.mutantIdentifier.dto.StatsDTO;
import co.com.magnetoproject.mutantIdentifier.models.DnaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DnaRepository extends JpaRepository<DnaModel, Long>{

    Integer countByIsMutan(Boolean ismutan);

}