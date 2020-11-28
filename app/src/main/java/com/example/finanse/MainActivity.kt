package com.example.finanse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //println("Введите сумму на нный срок")
            //var allmoney = readLine().toString().toDouble()
        var allmoney = 10000
        allSumm.text = allmoney.toString()
        var allmoney2 = allmoney //для вывода общего остатка на экран
            //println("Введите срок")
            //var alldays = readLine().toString().toInt()
        var alldays = 10
        val alldays2 = alldays //для вывода на экран чист

        var daymoneys: Array<Double> = Array(alldays, { 0.0 })
        var ostatok = 0.0
        var trat = 0.0

            for (i in 0..alldays2) {
                daymoneys[i] = (allmoney / alldays) + ostatok

                if (daymoneys[i] < 0)
                {
                    daymoneys[i] = 0.0
                }
                //println("День${i + 1} из ${alldays2}.Ваш общий бюджет ${("%.2f".format(allmoney2))}. У вас на сегодня  ${("%.2f".format(daymoneys[i]))} денег")

                //println("Введите свою траты за весь день")
                //trat = readLine().toString().toDouble()
                trat = rashod.editableText.toString().toInt().toDouble()
                ostatok = daymoneys[i] - trat
                daySumm.text = ostatok.toString()

                //println("остаток${ostatok}")

                allmoney2 -= trat.toInt()

                allSumm.text = allmoney2.toString()

                if (ostatok > 0)
                {

                    var d = 1

                    do {
                        d = 1
                        //println("Как вы хотите распределить оставшиеся деньги?: 1.Добавить наа следующий день 2.На весь срок")
                        var choose = readLine().toString().toInt()

                        when (choose) {
                            1 ->
                                continue
                            2 -> {
                                allmoney = allmoney2
                                alldays = alldays2 - i
                                ostatok = 0.0
                            }
                            else -> {
                                d = 0
                                println("Вы ввели нечитаемое значение")
                            }
                        }
                    }
                    while (d == 0)
                }
                if (ostatok < 0)
                {

                    var d = 1

                    do {
                        d = 1
                        println ("Откуда взять в долг?: 1.Со следующего дня 2.Со всего срока")
                        var choose = readLine().toString().toInt()

                        when (choose)
                        {
                            1 ->
                                if ((daymoneys[i]+daymoneys[i])>trat)
                                {
                                    daymoneys[i + 1] -= ostatok;
                                }
                                else
                                {
                                    allmoney -= trat;
                                    ostatok = 0.0
                                    alldays -= i
                                }
                            2 ->
                            {
                                allmoney -= trat
                                ostatok = 0.0
                                alldays -= i
                            }

                            else ->
                            {
                                d = 0
                                println("Вы ввели нечитаемое значение")
                            }
                        }
                    }
                    while (d == 0)
                }
                if (allmoney > 0 && i == (alldays + i))
                {
                    println("Поздравляю вы сыкономили ${allmoney} рублей за ${alldays + i} дней")
                }
            }
        }




}