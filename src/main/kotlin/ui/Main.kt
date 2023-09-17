import data.sourse.FitnesClubDataSourseImpl
import domain.FitnesClubRepository
import domain.FitnesClubUseCaseImpl
import ui.DI

fun main(){
val  adapter = DI.createFitnesClubAdapter()
    // Первое задание
    println(adapter.printInfoClientById(1))
    println(adapter.printInfoClientById(11))

    // Второе задание
    println(adapter.printInfoTicketById(3))
    println(adapter.printInfoTicketById(23))

    //   Третье задание
    println(adapter.printInfoAllPriceOfSoldTicket())

    // Четвёртое задание
    println(adapter.printTheMostPopularTrainer())

      // Пятое задание
    println(adapter.printClientStatus(2))
    println(adapter.printClientStatus(7))
    println(adapter.printClientStatus(29))
}