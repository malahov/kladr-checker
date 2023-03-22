class KladrChecker(private val kladrs: List<String>) {

    fun include(kladr: String): Boolean {
        return kladrs.any { kladr.startsWith(areaPrefix(it)) }
    }

    /*
        Определение префикса для наиболее крупного региона (регион, район, город, деревня и тп),
        получаем путем отбрасывания нулей справа до первой значащей цифры.
        Минимальная длина префикса 2 знака - это регион России. Если длина префикса меньше 2,
        то добавляем 0-и пока не получим минимальную длину префикса.
     */

    private fun areaPrefix(kladr: String) = kladr.trimEnd('0').padEnd(2, '0')
}
