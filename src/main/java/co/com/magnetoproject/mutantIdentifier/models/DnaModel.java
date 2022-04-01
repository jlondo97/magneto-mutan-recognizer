package co.com.magnetoproject.mutantIdentifier.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "dnas", schema = "dnaMutan")
public class DnaModel {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dna_generate")
  private long id_chain_dna;

  @Column(name = "dna_value")
  private String dna_value;

  @Column(name = "is_mutan")
  private Boolean isMutan;

  public DnaModel() {}
}
