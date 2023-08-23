package ui

import domain.FitnesClubUseCase

class FitnesClubAdapter(private val fitnesClubUseCase: FitnesClubUseCase) {
    fun PrintInfoClientById(id: Int) {
        val client = fitnesClubUseCase.getClientId(id)
        if (client != null) {
            println("Имя клиента: ${client.name}, его(её) id: ${client.id}, статус: ${client.status}")
        }
        else
            println("Клиент не найден")
    }

    fun PrintInfoTicketById(id: Int) {
        val ticket = fitnesClubUseCase.getTicketId(id)
        if (ticket != null) {
            println("Id клиента: ${ticket.clientId}, id абонемента: ${ticket.idTicket}, цена абонемента: ${ticket.price}")
        }
        else
            println("Неверно указан id")
    }

    fun PrintInfoAllPriceOfSoldTicket(){
        val ticket = fitnesClubUseCase.getAllPriceOfSoldTicket()
        println("Общая стоимость всех абонементов равна ${ticket}")
    }

    fun PrintTheMostPopularTrainer(){
        val trainer = fitnesClubUseCase.getTheMostPopularTrainer()
        println("Любимый тренер наших клиентов: $trainer")
    }

    fun PrintClientStatus(id: Int) {
        val client = fitnesClubUseCase.getClientStatus(id)
        if (client != null) {
        println("Статус клиента: $client")
        }
        else
            println("Клиент не найден")
    }
}