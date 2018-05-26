package validate;import com.vandersoncamp.bankslip.business.validate.BoletoValidate;import com.vandersoncamp.bankslip.model.Boleto;import com.vandersoncamp.bankslip.model.Status;import com.vandersoncamp.bankslip.util.exception.BusinessException;import org.junit.jupiter.api.DisplayName;import org.junit.jupiter.api.Test;import java.math.BigDecimal;import static org.junit.jupiter.api.Assertions.*;public class BoletoValidateTest {    private static final String HASH_ID = "ef4b73d8-a983-4941-9748-1c25de65b0ac";    private Boleto getBoleto() {        Boleto boleto = new Boleto();        boleto.setId(HASH_ID);        boleto.setDue_date(new java.sql.Date(new java.util.Date().getTime()));        boleto.setTotal_in_cents(BigDecimal.TEN);        boleto.setStatus(Status.PENDING);        boleto.setCustomer("Customer Test");        return boleto;    }    Boleto boleto = getBoleto();    BoletoValidate validate = new BoletoValidate();    @Test    @DisplayName("Test 01")    public void TestValidate01() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setDue_date(null);            validate.validate(boleto);        });        assertEquals("Não foi informada a data de vencimento do boleto", thrown.getMessage());    }    @Test    @DisplayName("Test 02")    public void TestValidate02() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setTotal_in_cents(null);            validate.validate(boleto);        });        assertEquals("Não foi informado valor para o boleto", thrown.getMessage());    }    @Test    @DisplayName("Test 03")    public void TestValidate03() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setCustomer(null);            validate.validate(boleto);        });        assertEquals("Não foi informado o pagador do boleto", thrown.getMessage());    }    @Test    @DisplayName("Test 04")    public void TestValidate04() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setStatus(null);            validate.validate(boleto);        });        assertEquals("Não foi informada a situação do boleto", thrown.getMessage());    }    @Test    @DisplayName("Test 05")    public void TestValidate05() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setId(null);            validate.validate(boleto);        });        assertEquals("Identificador do boleto não pode ser nulo", thrown.getMessage());    }    @Test    @DisplayName("Test 06")    public void TestValidate06() {        BusinessException thrown = assertThrows(BusinessException.class, () -> {            boleto.setId("ef4b73d8-a983-4941-9748-1c25de65b");            validate.validate(boleto);        });        assertEquals("Identificador do boleto incorreto", thrown.getMessage());    }    @Test    @DisplayName("Test 07")    public void TestValidate07() {        boleto.setDue_date(new java.sql.Date(new java.util.Date().getTime()));        validate.validate(boleto);        assertNotNull(boleto.getDue_date());    }    @Test    @DisplayName("Test 08")    public void TestValidate08() {        boleto.setTotal_in_cents(BigDecimal.ONE);        validate.validate(boleto);        assertNotNull(boleto.getTotal_in_cents());    }    @Test    @DisplayName("Test 09")    public void TestValidate09() {        boleto.setCustomer("Customer test");        validate.validate(boleto);        assertNotNull(boleto.getCustomer());    }    @Test    @DisplayName("Test 10")    public void TestValidate10() {        boleto.setStatus(Status.PENDING);        validate.validate(boleto);        assertNotNull(boleto.getStatus());    }    @Test    @DisplayName("Test 11")    public void TestValidate11() {        boleto.setId(HASH_ID);        validate.validate(boleto);        assertNotNull(boleto.getStatus());    }}