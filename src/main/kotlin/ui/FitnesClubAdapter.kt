package ui

import domain.FitnesClubUseCase

class FitnesClubAdapter(private val fitnesClubUseCase: FitnesClubUseCase) {
    fun printInfoClientById(id: Int) {
        val client = fitnesClubUseCase.getClientById(id)
        if (client != null) {
            println("Имя клиента: ${client.name}, его(её) id: ${client.id}, статус: ${client.status}")
        }
        else{
            println("Клиент не найден")
        }
    }

    fun printInfoTicketById(id: Int) {
        val ticket = fitnesClubUseCase.getTicketById(id)
        if (ticket != null) {
            println("Id клиента: ${ticket.clientId}, id абонемента: ${ticket.idTicket}, цена абонемента: ${ticket.price}")
        }
        else{
            println("Неверно указан id")
        }
    }

    fun printInfoAllPriceOfSoldTicket(){
        val ticket = fitnesClubUseCase.getAllPriceOfSoldTicket()
        println("Общая стоимость всех абонементов равна ${ticket}")
    }

    fun printTheMostPopularTrainer(){
        val trainer = fitnesClubUseCase.getTheMostPopularTrainer()
        println("Любимый тренер наших клиентов: $trainer")
    }

    fun printClientStatus(id: Int) {
        val client = fitnesClubUseCase.getClientStatus(id)
        if (client != null) {
        println("Статус клиента: $client")
        }
        else{
            println("Клиент не найден")
        }
    }
}