import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    @Test
    public void testValidateFieldId() {
        String result = Validation.validateField(0, "123");
        assertEquals("123", result);
    }

    @Test
    public void testValidateFieldNameEmpty() {
        String result = Validation.validateField(1, "");
        assertEquals("Error required", result);
    }

    @Test
    public void testValidateFieldBirthdayEmpty() {
        String result = Validation.validateField(2, "");
        assertEquals("Error required", result);
    }

    @Test
    public void testValidateFieldGender() {
        String result = Validation.validateField(3, "male");
        assertEquals("male", result);
    }

    @Test
    public void testValidateFieldPhoneNumber() {
        String result = Validation.validateField(4, "");
        assertEquals("Error required", result);
    }
}
