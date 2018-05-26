package validate;import com.vandersoncamp.bankslip.business.validate.BoletoStatusValidate;import com.vandersoncamp.bankslip.model.Boleto;import com.vandersoncamp.bankslip.model.Status;import com.vandersoncamp.bankslip.util.exception.BusinessException;import org.junit.jupiter.api.DisplayName;import org.junit.jupiter.api.Test;import java.math.BigDecimal;import static org.junit.jupiter.api.Assertions.*;public class BoletoStatusValidateTest {    private Boleto getBoleto() {        Boleto boleto = new Boleto();        boleto.setDue_date(new java.sql.Date(new java.util.Date().getTime()));        boleto.setTotal_in_cents(BigDecimal.TEN);        boleto.setStatus(Status.PENDING);        boleto.setCustomer("Customer Test");        return boleto;    }    Boleto boleto = getBoleto();    BoletoStatusValidate statusValidate = new BoletoStatusValidate();    @Test    @DisplayName("Test 01")    public void TestStatus01() {        statusValidate.validate(boleto, Status.PAID);        assertTrue(boleto.getStatus().equals(Status.PENDING));    }    @Test    @DisplayName("Test 02")    public void TestStatus02() {        statusValidate.validate(boleto, Status.CANCELED);        assertTrue(boleto.getStatus().equals(Status.PENDING));    }    @Test    @DisplayName("Test 03")    public void TestStatus03() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setStatus(Status.PAID);            statusValidate.validate(boleto, Status.PAID);        });        assertEquals("Boleto já está pago", thrown.getMessage());    }    @Test    @DisplayName("Test 04")    public void TestStatus04() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setStatus(Status.PAID);            statusValidate.validate(boleto, Status.CANCELED);        });        assertEquals("Boleto já está pago", thrown.getMessage());    }    @Test    @DisplayName("Test 05")    public void TestStatus05() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setStatus(Status.PAID);            statusValidate.validate(boleto, Status.PENDING);        });        assertEquals("Boleto já está pago", thrown.getMessage());    }    @Test    @DisplayName("Test 06")    public void TestStatus06() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setStatus(Status.CANCELED);            statusValidate.validate(boleto, Status.PAID);        });        assertEquals("Boleto já está cancelado", thrown.getMessage());    }    @Test    @DisplayName("Test 07")    public void TestStatus07() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setStatus(Status.CANCELED);            statusValidate.validate(boleto, Status.CANCELED);        });        assertEquals("Boleto já está cancelado", thrown.getMessage());    }    @Test    @DisplayName("Test 08")    public void TestStatus08() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setStatus(Status.CANCELED);            statusValidate.validate(boleto, Status.PENDING);        });        assertEquals("Boleto já está cancelado", thrown.getMessage());    }}