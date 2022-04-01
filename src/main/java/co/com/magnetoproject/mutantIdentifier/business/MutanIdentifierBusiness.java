package co.com.magnetoproject.mutantIdentifier.business;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface MutanIdentifierBusiness {

    public Boolean isMutan(List<String> dnas);

}
