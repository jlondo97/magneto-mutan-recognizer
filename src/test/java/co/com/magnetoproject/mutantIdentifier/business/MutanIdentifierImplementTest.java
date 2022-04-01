package co.com.magnetoproject.mutantIdentifier.business;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import java.util.List;

import static org.mockito.Mockito.when;

public class MutanIdentifierImplementTest {

  private MutanIdentifierBusiness mutanIdentifierBusiness;
  MutantIdentifierImplement mutantIdentifierImplement = new MutantIdentifierImplement();

  @Test
  public void isMutanTest() {}

  @Test
  public void createMatrixTest() {

    Assert.isTrue(
        mutantIdentifierImplement.createMatrix(dnaListNotMutant()).equals(matrixCharacteres()),
        "Matrix are equals");
  }

  @Test
  public void brainOfXavier() {

    int isMutan = 2;
    List<List<Character>> chainDnaIsMutan =
        mutantIdentifierImplement.createMatrix(dnaListIsMutant());
    List<List<Character>> chainDnaNotMutan =
        mutantIdentifierImplement.createMatrix(dnaListNotMutant());
    int countDnaIsMutant = mutantIdentifierImplement.brainOfXavier(chainDnaIsMutan);
    int countDnaNotMutant = mutantIdentifierImplement.brainOfXavier(chainDnaNotMutan);

    Assert.isTrue(countDnaIsMutant >= isMutan, "Mutant");
    Assert.isTrue(countDnaNotMutant < isMutan, "Human");
  }

  @Test
  public void validateDnaChains() {

    Assert.isTrue(mutantIdentifierImplement.validateDnaChains(0, 0, null, null, null, 0) == 0, "");
  }

  public static List<String> dnaListIsMutant() {
    return List.of("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
  }

  public static List<String> dnaListNotMutant() {
    return List.of("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG");
  }

  public static List<List<Character>> matrixCharacteres() {

    return List.of(
        List.of('A', 'T', 'G', 'C', 'G', 'A'),
        List.of('C', 'A', 'G', 'T', 'G', 'C'),
        List.of('T', 'T', 'A', 'T', 'T', 'T'),
        List.of('A', 'G', 'A', 'C', 'G', 'G'),
        List.of('G', 'C', 'G', 'T', 'C', 'A'),
        List.of('T', 'C', 'A', 'C', 'T', 'G'));
  }
}
