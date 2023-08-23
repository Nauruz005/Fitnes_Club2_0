package domain

import model.Client
import model.Ticket
import model.Trainer

class FitnesClubUseCaseImpl(private val repository: FitnesClubRepository): FitnesClubUseCase {

    //Ищет клиента по его id
    override fun getClientId(id: Int): Client? = repository.getClients().find { it.id == id }

    //Ищет абонемент по его id
    override fun getTicketId(id: Int): Ticket? = repository.getTickets().find { it.idTicket == id }

    //Высчитывает общую стоимость всех купленных абонементов
    override fun getAllPriceOfSoldTicket(): Int = repository.getTickets().sumOf { it.price }

    //Ищет самого популярного тренера
    override fun getTheMostPopularTrainer(): String? {
        val no = "No"
        val countByElement = repository.getTrainer().filter { it.name != no }.groupingBy { it.name }.eachCount()
        val maximumElement = countByElement.maxBy { it.value }?.key
        return maximumElement
    }


    //  Выводит "статус" клиента
    override fun getClientStatus(id: Int): String? {
        val vip = "VIP"
        var clientStatus = getClientId(id)?.status
        if(id == getClientId(id)?.id && id == getTicketId(id)?.idTicket && getTicketId(id)?.price!! >= 2000){
           clientStatus = vip
        }
        return clientStatus
    }
}
