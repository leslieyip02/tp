package seedu.ddd.testutil.event;

import static seedu.ddd.logic.commands.CommandTestUtil.CLIENT_FLAG;
import static seedu.ddd.logic.commands.CommandTestUtil.EVENT_FLAG;
import static seedu.ddd.logic.commands.CommandTestUtil.VENDOR_FLAG;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_CLIENTS;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_DESC;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_SERVICE;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.ddd.logic.parser.CliSyntax.PREFIX_VENDORS;

import seedu.ddd.logic.commands.AddEventCommand;
import seedu.ddd.model.event.common.Event;

/**
 * A utility class for Event.
 */
public class EventUtil {

    /**
     * Returns an add command string for adding the {@code event}.
     */
    public static String getAddEventCommand(Event event) {
        return AddEventCommand.COMMAND_WORD + " " + EVENT_FLAG + " " + getEventDetails(event);
    }

    /**
     * Returns the part of command string for the given {@code event}'s details.
     */
    public static String getEventDetails(Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + event.getName().fullName + " ");
        sb.append(PREFIX_DESC + event.getDescription().description + " ");
        sb.append(PREFIX_DATE + event.getDate().date.toString() + " ");
        event.getClients().stream().forEach(
                s -> sb.append(PREFIX_CLIENTS + s.getId().toString() + " ")
        );
        event.getVendors().stream().forEach(
                s -> sb.append(PREFIX_VENDORS + s.getId().toString() + " ")
        );
        return sb.toString();
    }

}
