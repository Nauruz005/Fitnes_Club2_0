import data.sourse.FitnesClubDataSourseImpl
import domain.FitnesClubRepository
import domain.FitnesClubUseCaseImpl
import ui.DI

fun main(){
val  adapter = DI.createFitnesClubAdapter()
    // Первое задание
    println(adapter.PrintInfoClientById(1))
    println(adapter.PrintInfoClientById(11))

    // Второе задание
    println(adapter.PrintInfoTicketById(3))
    println(adapter.PrintInfoTicketById(23))

    //   Третье задание
    println(adapter.PrintInfoAllPriceOfSoldTicket())

    // Четвёртое задание
    println(adapter.PrintTheMostPopularTrainer())

      // Пятое задание
    println(adapter.PrintClientStatus(2))
    println(adapter.PrintClientStatus(7))
    println(adapter.PrintClientStatus(29))
}