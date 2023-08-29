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
    public void testValidateFieldNameTooLong() {
        String name = "ThisIsAReallyLongNameThatExceedsTheMaximumLengthAllowedByValidation";
        String result = Validation.validateField(1, name);
        assertEquals(name, result);
    }

    @Test
    public void testValidateFieldBirthdayValid() {
        String result = Validation.validateField(2, "1980/02/29");
        assertEquals("1980/02/29", result);
    }

    @Test
    public void testValidateFieldBirthdayInvalid() {
        String result = Validation.validateField(2, "02/29/1980");
        assertEquals("Error format", result);
    }

    @Test
    public void testValidateFieldGenderValid() {
        String result = Validation.validateField(3, "female");
        assertEquals("female", result);
    }

    @Test
    public void testValidateFieldGenderInvalid() {
        String result = Validation.validateField(3, "unknown");
        assertEquals("Error format", result);
    }

    @Test
    public void testValidateFieldPhoneNumberValid() {
        String result = Validation.validateField(4, "09011112222");
        assertEquals("09011112222", result);
    }

    @Test
    public void testValidateFieldPhoneNumberInvalid() {
        String result = Validation.validateField(4, "invalidPhoneNumber");
        assertEquals("Error format", result);
    }
}
