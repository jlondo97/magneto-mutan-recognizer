package co.com.magnetoproject.mutantIdentifier.business;


import co.com.magnetoproject.mutantIdentifier.dto.StatsDTO;
import co.com.magnetoproject.mutantIdentifier.repository.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsMutanImplement implements StatsMutanBusiness {

    @Autowired
    private DnaRepository dnaRepository;

    public StatsDTO calculateStats(){
        Integer countMutans = dnaRepository.countByIsMutan(Boolean.TRUE);
        Integer countHumans = dnaRepository.countByIsMutan(Boolean.FALSE);
        Float ratio = countMutans.floatValue()/(countHumans.floatValue() + countMutans.floatValue());

        return new StatsDTO(countMutans,countHumans,ratio);
    }

}
