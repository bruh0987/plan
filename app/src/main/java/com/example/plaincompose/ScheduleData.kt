package com.example.plaincompose

data class Lesson(
    val name: String,
    val room: String = "",
    val teacher: String = "",
    val color: Long,
)

val LessonColors = mapOf(
    "matematyka" to 0xFF92D5A6,
    "j. polski" to 0xFFAAD7E8,
    "język polski" to 0xFFAAD7E8,
    "angielski" to 0xFFB0A7F8,
    "ang" to 0xFFB0A7F8,
    "biologia" to 0xFFA6D7A8,
    "historia" to 0xFFDADE73,
    "geografia" to 0xFF8DCFC8,
    "chemia" to 0xFF9B9FEA,
    "fizyka" to 0xFFA9B8A1,
    "filozofia" to 0xFF7F84D7,
    "edb" to 0xFFE0D36A,
    "informatyka" to 0xFFF39A79,
    "inf" to 0xFFF39A79,
    "religia" to 0xFFE5A6BE,
    "fiz" to 0xFF8FCA77,
    "wf" to 0xFFE3A3D5,
    "GW" to 0xFF79D6A7,
)

fun lesson(name: String, room: String = "", teacher: String = "", color: Long? = null): Lesson =
    Lesson(
        name = name,
        room = room,
        teacher = teacher,
        color = color ?: LessonColors.entries.firstOrNull { name.contains(it.key, ignoreCase = true) }?.value
            ?: 0xFFD0D0D0,
    )

val ScheduleDays = listOf("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")

val ScheduleTimes = listOf(
    "8:15 - 9:00",
    "9:10 - 9:55",
    "10:05 - 10:50",
    "11:00 - 11:45",
    "11:55 - 12:40",
    "13:00 - 13:45",
    "14:05 - 14:50",
    "15:00 - 15:45",
)

val ScheduleLessons = listOf(
    listOf(
        lesson("GW", "207", "Pawłowski Marek"),
        lesson("biologia", "201", "Chludzińska Beata"),
        lesson(""),
        lesson("wf", "", "MLe"),
        lesson("historia", "124", "Zmysłowska Adam"),
    ),
    listOf(
        lesson("j. polski", "206", "Krasińska Aleksandra"),
        lesson("matematyka", "100", "BŁ"),
        lesson("religia", "218", "PS"),
        lesson("fiz", "104", "SM"),
        lesson("ang", "200", "AW"),
    ),
    listOf(
        lesson("j. polski", "206", "Krasińska Aleksandra"),
        lesson("j. polski", "206", "Krasińska Aleksandra"),
        lesson("inf", "217", "JS"),
        lesson("ang", "200", "AW"),
        lesson("matematyka", "207", "Pawłowski Marek"),
    ),
    listOf(
        lesson("matematyka", "18", "AMi"),
        lesson("chemia", "207", "Skrzeczewska Joanna"),
        lesson("inf", "217", "JS"),
        lesson("edb", "107", "Szydłowski Andrzej"),
        lesson("geografia", "117", "Winter Tomasz"),
    ),
    listOf(
        lesson("matematyka", "207", "Pawłowski Marek"),
        lesson("matematyka", "207", "Pawłowski Marek"),
        lesson("matematyka", "207", "Pawłowski Marek"),
        lesson("j. polski", "206", "Krasińska Aleksandra"),
        lesson("wf", "", "MLe"),
    ),
    listOf(
        lesson("EZ", "221", "Mirska Małgorzata"),
        lesson("matematyka", "207", "Pawłowski Marek"),
        lesson("ang", "200", "AW"),
        lesson("j. polski", "206", "Krasińska Aleksandra"),
        lesson(""),
    ),
    listOf(
        lesson("fizyka", "126", "Miernicki Sławomir"),
        lesson("filozofia", "204", "Świetelska Agnieszka"),
        lesson("historia", "206", "Zmysłowska Adam"),
        lesson("próg", "107", "JS"),
        lesson(""),
    ),
    listOf(
        lesson(""),
        lesson("e", "204", "AŚ"),
        lesson("BiZ", "206", "Zmysłowska Adam"),
        lesson(""),
        lesson(""),
    ),
)
