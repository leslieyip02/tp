package seedu.ddd.model.contact.client;

import static seedu.ddd.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Set;

import seedu.ddd.commons.util.ToStringBuilder;
import seedu.ddd.model.contact.common.Address;
import seedu.ddd.model.contact.common.Contact;
import seedu.ddd.model.contact.common.Email;
import seedu.ddd.model.contact.common.Id;
import seedu.ddd.model.contact.common.Name;
import seedu.ddd.model.contact.common.Phone;
import seedu.ddd.model.tag.Tag;

/**
 * Represents a Client in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Client extends Contact {
    private Date date;
    /**
     * Constructs a {@code Client}.
     *
     * @param name    A valid name.
     * @param phone   A valid phone number.
     * @param email   A valid email address.
     * @param address A valid address.
     * @param date    A valid date.
     * @param tags    A set of tags associated with the client.
     */
    public Client(Name name, Phone phone, Email email, Address address, Date date, Set<Tag> tags, Id id) {
        super(name, phone, email, address, tags, id);
        requireAllNonNull(date);
        this.date = date;
    }

    /**
     * Returns the client's date.
     *
     * @return the date associated with the client.
     */
    public Date getDate() {
        return date;
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Client)) {
            return false;
        }

        Client otherClient = (Client) other;
        return super.equals(otherClient) && date.equals(otherClient.date);
    }
    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(this.getName(), this.getPhone(), this.getEmail(),
                this.getAddress(), this.date, this.getTags());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", this.getName())
                .add("phone", this.getPhone())
                .add("email", this.getEmail())
                .add("address", this.getAddress())
                .add("date", this.date)
                .add("tags", this.getTags())
                .toString();
    }

}