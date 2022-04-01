package co.com.magnetoproject.mutantIdentifier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatsDTO {
  private Integer countMutantDna;
  private Integer countHumanDna;
  private Float ratio;
}
