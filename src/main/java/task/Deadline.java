package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import enumerations.SymbolEnum;

/**
 * This is the Deadline class. It is a subclass of Task.
 */
public class Deadline extends Task {

    /**
     * This is the date and time variable. It is of LocalDateTime format.
     */
    private LocalDateTime dateAndTime;

    /**
     * This method creates the Deadline-class. It calls the superclass constructor, as well as sets the symbol to "D"
     * and sets the date and time. It has two cases of usage (thus two formatter methods), normal creation and when
     * loading from the text file.
     *
     * @param description This is the description of the task as input by user in string format.
     * @param dateAndTime This is the date and time of the task as input by user in string format.
     * @throws DateTimeParseException This exception is thrown when the format of the date and time as input by user
     *                                is invalid.
     */
    public Deadline(String description, String dateAndTime) throws DateTimeParseException {
        super(description);
        this.symbol = SymbolEnum.valueOf("D");
        try {
            this.dateAndTime = LocalDateTime.parse(dateAndTime, formatter());
        } catch (DateTimeParseException e) {
            this.dateAndTime = LocalDateTime.parse(dateAndTime, formatterLoad());
        }
    }

    /**
     * This method returns the symbol of the task.
     *
     * @return Returns symbol of task.
     */
    public SymbolEnum getSymbol() {
        return symbol;
    }

    /**
     * This method returns the date and time of the task.
     *
     * @return Returns LocalDateTime of deadline.
     */
    @Override
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    /**
     * This formatter method is used during normal creation of deadline task.
     */
    private DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern("d/M/yyyy H:mm");
    }

    /**
     * This formatter method is used during loading of deadline task from the text file.
     */
    private DateTimeFormatter formatterLoad() {
        return DateTimeFormatter.ofPattern("d/M/yyyy, H:mm", Locale.ENGLISH);
    }
}
