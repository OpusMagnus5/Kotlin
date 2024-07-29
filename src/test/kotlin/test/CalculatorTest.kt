package test

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.example.test.Calculator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.logging.Logger

class CalculatorTest {

    @MockK //tworzy obiekt mocka
    lateinit var calculator: Calculator

    //@InjectMockKs //tworzy instacje przez wstrzykiwanie dostępnych mocków jako argumenty
    //lateinit var mathService: MathService

    /*@BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        every { mathService.add(any(), any()) } returns 5
    }*/

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

    @Test
    fun `mockk test`() {
        val calculatorMock = mockk<Calculator>() //definiowanie mocka
        every { calculatorMock.add(any(), any()) } returns 5 //mockujemy że każde wywołanie add zwraca 5
        assertEquals(5, calculatorMock.add(10, 0))

        verify { calculatorMock.add(10, 0) } //weryfikujemy czy metoda się wykonała

        val loggerMock = mockk<Logger>()
        justRun { loggerMock.log(any()) } //jeśli metoda zwraca void używamy justRun

        //jesli chcemy zamockować klasę finalną możemy skorzystać z mockkObject(MyFinalClass::class)

        val calculatorSpy = spyk<Calculator>() //tworzenie spy, któryego mozemy użyc aby zamockowac np tylko jedną metodą a reszta ma działac oryginalnie
        every { calculatorSpy.add(any(), any()) } returns 5 // i tak samo mockujemy jak dla mocka

        val mockedObject = mockkObject(Calculator::class) // mockowanie singletonów lub metod statycznych???

        //Matching specific values
        //every { myMockObject.myMethod(eq("foo")) } returns 42

        //Matching any value
        //every { myMockObject.myMethod(any()) } returns 42

        //Matching null values
        //every { myMockObject.myMethod(isNull<String>()) } returns 42

        //Matching ranges of values
        //every { myMockObject.myMethod(range(10, 20)) } returns 42

        // Matching collections
        // every { myMockObject.myMethod(match { it.contains("foo") && it.contains("bar") }) } returns 42

        /*
        captor(). - The captor() function is used to capture the value of an argument that is passed to a mocked method.
        This can be useful for testing methods that have side effects or for verifying that certain values were passed to a method.

        slot(). - The slot() function is similar to the captor() function, but it captures the value of an argument into a slot object.
        This can be useful for testing methods that return values or for verifying that certain values were passed to a method.
        argThat(). - The argThat() function is used to match an argument using a custom matcher function.
        This can be useful for testing methods that have complex argument requirements or for verifying that certain values were passed.
        */
    }
}