import org.example.Calculator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    @Test
    fun `when adding 1 and 2 expect 3`() { //możemy podawać nazwy funkcji w ``
        val result = Calculator.add(1, 2)
        assertEquals(3, result)
    }

    @Test
    fun `when 2 is checked if even expect true`() {
        assertTrue(Calculator.isEven(2))
    }

    @Disabled //do wyłączenia testu
    @Test
    fun `when dividing by 0 expect IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            Calculator.divide(10, 0)
        }
    }
}