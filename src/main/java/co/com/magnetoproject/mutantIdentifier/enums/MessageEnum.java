package co.com.magnetoproject.mutantIdentifier.enums;

public enum MessageEnum {
  IS_MUTANT("Welcome to lines of Magneto,you'r one of us"),
  NOT_MUTANT("You'r a simple human");

  private final String message;

  MessageEnum(String Message) {
    this.message = Message;
  }

  public String getMessage() {
    return message;
  }
}
