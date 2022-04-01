package co.com.magnetoproject.mutantIdentifier.business;

import co.com.magnetoproject.mutantIdentifier.dto.StatsDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsMutanBusiness {

    public StatsDTO calculateStats();
}
