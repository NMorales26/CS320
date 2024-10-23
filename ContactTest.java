import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "JohnJohnJohn", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "123 Elm St"));
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "123456789", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "12345678901", "123 Elm St"));
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", "123 Elm St 123 Elm St 123 Elm St 123"));
    }

    @Test
    public void testUpdateFields() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}