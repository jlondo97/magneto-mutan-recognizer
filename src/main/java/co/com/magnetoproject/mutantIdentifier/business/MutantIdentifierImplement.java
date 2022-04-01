package co.com.magnetoproject.mutantIdentifier.business;

import co.com.magnetoproject.mutantIdentifier.models.DnaModel;
import co.com.magnetoproject.mutantIdentifier.repository.DnaRepository;
import co.com.magnetoproject.mutantIdentifier.vo.ConveyorBeltVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class MutantIdentifierImplement implements MutanIdentifierBusiness {

  private static final String LEFT = "LEFT";
  private static final String LEFT_UP = "LEFT_UP";
  private static final String UP = "UP";
  private static final String RIGHT_UP = "RIGHT_UP";

  @Autowired private DnaRepository dnaRepository;

  public Boolean isMutan(List<String> dnas) {
    DnaModel model = new DnaModel();
    Boolean ismutan = brainOfXavier(createMatrix(dnas)) > 1;
    model.setDna_value(dnas.toString());
    model.setIsMutan(ismutan);

    dnaRepository.save(model);

    return ismutan;
  }

  public List<List<Character>> createMatrix(List<String> dnas) {

    ArrayList<List<Character>> matrixDnas = new ArrayList<>();

    dnas.forEach(
        dna -> matrixDnas.add(dna.chars().mapToObj(c -> (char) c).collect(Collectors.toList())));
    return matrixDnas;
  }

  public int brainOfXavier(List<List<Character>> matrix) {

    List<List<ConveyorBeltVO>> conveyorBelts = new ArrayList<>();
    AtomicInteger indexRow = new AtomicInteger();
    AtomicInteger indexColumn = new AtomicInteger();
    AtomicInteger chainDNAFounded = new AtomicInteger();

    matrix.stream()
        .takeWhile(n -> chainDNAFounded.get() < 2)
        .forEach(
            field -> {
              List<ConveyorBeltVO> unitConveyorBelt = new ArrayList<>();
              conveyorBelts.add(unitConveyorBelt);

              field.stream()
                  .takeWhile(n -> chainDNAFounded.get() < 2)
                  .forEach(
                      value -> {
                        ConveyorBeltVO conveyorBelt = new ConveyorBeltVO();
                        conveyorBelt.setValue(value);

                        conveyorBelt.setLeft(
                            validateDnaChains(
                                indexRow.get(),
                                indexColumn.get() - 1,
                                conveyorBelts,
                                value,
                                LEFT,
                                matrix.size()));
                        conveyorBelt.setLeftUp(
                            validateDnaChains(
                                indexRow.get() - 1,
                                indexColumn.get() - 1,
                                conveyorBelts,
                                value,
                                LEFT_UP,
                                matrix.size()));
                        conveyorBelt.setUp(
                            validateDnaChains(
                                indexRow.get() - 1,
                                indexColumn.get(),
                                conveyorBelts,
                                value,
                                UP,
                                matrix.size()));
                        conveyorBelt.setRightUp(
                            validateDnaChains(
                                indexRow.get() - 1,
                                indexColumn.get() + 1,
                                conveyorBelts,
                                value,
                                RIGHT_UP,
                                matrix.size()));

                        if (conveyorBelt.getIsMutant()) {
                          conveyorBelt.resetChainDNA();
                          chainDNAFounded.getAndIncrement();
                        }
                        conveyorBelts.get(indexRow.get()).add(conveyorBelt);
                        indexColumn.getAndIncrement();
                      });
              indexRow.getAndIncrement();
              indexColumn.set(0);
            });

    return chainDNAFounded.get();
  }

  public int validateDnaChains(
      int indexRow,
      int indexColumn,
      List<List<ConveyorBeltVO>> conveyorBelts,
      Character value,
      String positionGet,
      int matrixSize) {
    if (indexRow < 0 || indexColumn < 0 || indexColumn > matrixSize - 1) {
      return 0;
    }
    ConveyorBeltVO unitConveyorBelt = conveyorBelts.get(indexRow).get(indexColumn);
    int valueReturned = 0;
    if (unitConveyorBelt.getValue() == value) {
      switch (positionGet) {
        case LEFT:
          valueReturned = unitConveyorBelt.getLeft();
          break;
        case LEFT_UP:
          valueReturned = unitConveyorBelt.getLeftUp();
          break;
        case UP:
          valueReturned = unitConveyorBelt.getUp();
          break;
        case RIGHT_UP:
          valueReturned = unitConveyorBelt.getRightUp();
          break;
      }
      return valueReturned + 1;
    }

    return valueReturned;
  }
}
