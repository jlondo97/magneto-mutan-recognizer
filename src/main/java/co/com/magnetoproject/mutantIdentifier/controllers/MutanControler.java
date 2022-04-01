package co.com.magnetoproject.mutantIdentifier.controllers;

import co.com.magnetoproject.mutantIdentifier.business.MutanIdentifierBusiness;
import co.com.magnetoproject.mutantIdentifier.business.StatsMutanBusiness;
import co.com.magnetoproject.mutantIdentifier.dto.DnaDTO;
import co.com.magnetoproject.mutantIdentifier.dto.StatsDTO;
import co.com.magnetoproject.mutantIdentifier.enums.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;

@Controller
public class MutanControler {

  private static final Logger LOGGER = Logger.getLogger(MutanControler.class);

  @Autowired private MutanIdentifierBusiness mutanIdentifierBusiness;

  @Autowired private StatsMutanBusiness statsMutanBusiness;

  @RequestMapping(value = "/mutant", method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public ResponseEntity<String> postVerificationMutantResponse(
      @RequestBody(required = true) final DnaDTO dnaDTO) {

    return mutanIdentifierBusiness.isMutan(dnaDTO.getDna())
        ? new ResponseEntity<>(MessageEnum.IS_MUTANT.getMessage(), HttpStatus.OK)
        : new ResponseEntity<>(MessageEnum.NOT_MUTANT.getMessage(), HttpStatus.FORBIDDEN);
  }

  @RequestMapping(value = "/stats", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public ResponseEntity<StatsDTO> getMutantStatsResponse() {
    return new ResponseEntity<StatsDTO>(statsMutanBusiness.calculateStats(), HttpStatus.OK);
  }
}
