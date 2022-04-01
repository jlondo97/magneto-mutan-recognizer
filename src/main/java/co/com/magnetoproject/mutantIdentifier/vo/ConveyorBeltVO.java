package co.com.magnetoproject.mutantIdentifier.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class ConveyorBeltVO {

  private Character value;
  private int leftUp;
  private int up;
  private int rightUp;
  private int left;

  @Getter(AccessLevel.NONE)
  private boolean isMutant;

  public boolean getIsMutant() {
    return leftUp > 2 || up > 2 || rightUp > 2 || left > 2;
  }

  public void resetChainDNA() {

    if (this.left > 2) {
      this.left = 0;
    }

    if (this.leftUp > 2) {
      this.leftUp = 0;
    }

    if (this.up > 2) {
      this.up = 0;
    }

    if (this.rightUp > 2) {
      this.rightUp = 0;
    }
  }
}
