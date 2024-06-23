package com.example.myapplication.model

import com.example.myapplication.R

@Suppress("SpellCheckingInspection")
class ShipList {
    companion object {
        private val ship0 = Ship(
            "Аврора",
            R.drawable.p1,
            "Лёгкий крейсер",
            "1900",
            "6731",
            "Санкт-Петербург",
            "Россия",
            "Аврора - первый корабль, поднявший Красный флаг во время Великой Октябрьской революции 25 октября 1917 г., символ Советского флота.",
            59.95528,
            30.33806
        )
        private val ship1 = Ship(
            "Ленин",
            R.drawable.p2,
            "Атомный ледокол",
            "1957",
            "16000",
            "Мурманск",
            "Россия",
            "Ленин - первый в мире атомный надводный корабль, заметно упростивший судодвижение в Арктике.",
            68.97472,
            33.05944
        )
        private val ship2 = Ship(
            "Lembit",
            R.drawable.p3,
            "Подводная лодка",
            "1936",
            "665",
            "Таллин",
            "Эстония",
            "Lembit - эстонская, позже советская подводная лодка, получившая во время Великой Отечественной войны Орден Красного Знамени.",
            59.45171,
            24.73838
        )
        private val ship3 = Ship(
            "Constitution",
            R.drawable.p4,
            "Парусный фрегат",
            "1797",
            "2200",
            "Бостон",
            "США",
            "Constitution - один из первых кораблей, шести фрегатов США. Старейший в мире корабль, остающийся на плаву.",
            42.37208,
            -71.05557
        )

        private val shipList = arrayOf(ship0, ship1, ship2, ship3)

        fun data(id: Int): Ship {
            return shipList[id]
        }

        fun takeNames(): Array<String> {
            var arr: Array<String> = emptyArray()
            for (ship in shipList)
            {
                arr += ship.name
            }
            return arr
        }
    }
}