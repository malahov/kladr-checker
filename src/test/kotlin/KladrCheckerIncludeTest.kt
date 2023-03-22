import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

private const val MOSCOW_AREA_KLADR_CODE = "5000000000000"
private const val MOSCOW_KLADR_CODE = "7700000000000"
private const val BALASHIHA_KLADR_CODE = "5000003600000"
private const val VIBORG_KLADR_CODE = "4700600100000"

class KladrCheckerIncludeTest {

    @Test
    fun `Balashiha is in Moscow area`() {
        val checker =  KladrChecker(listOf(MOSCOW_AREA_KLADR_CODE))
        Assertions.assertTrue(checker.include(BALASHIHA_KLADR_CODE))
    }

    @Test
    fun `Balashiha is not in Moscow`() {
        val checker =  KladrChecker(listOf(MOSCOW_KLADR_CODE))
        Assertions.assertFalse(checker.include(BALASHIHA_KLADR_CODE))
    }

    @Test
    fun `Balashiha is in Balashiha`() {
        val checker =  KladrChecker(listOf(BALASHIHA_KLADR_CODE))
        Assertions.assertTrue(checker.include(BALASHIHA_KLADR_CODE))
    }

    @Test
    fun `Moscow area is not in Balashiha`() {
        val checker =  KladrChecker(listOf(BALASHIHA_KLADR_CODE))
        Assertions.assertFalse(checker.include(MOSCOW_AREA_KLADR_CODE))
    }

    @Test
    fun `Balashiha is in one of kaldr list element`() {
        val checker =  KladrChecker(listOf(MOSCOW_AREA_KLADR_CODE, MOSCOW_KLADR_CODE))
        Assertions.assertTrue(checker.include(BALASHIHA_KLADR_CODE))
    }

    @Test
    fun `Viborg is not in one of kaldr list element`() {
        val checker =  KladrChecker(listOf(MOSCOW_AREA_KLADR_CODE, MOSCOW_KLADR_CODE))
        Assertions.assertFalse(checker.include(VIBORG_KLADR_CODE))
    }


}
