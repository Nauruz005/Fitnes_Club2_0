package domain

import model.Client
import model.Status
import model.Ticket
import model.Trainer

class FitnesClubUseCaseImpl(private val repository: FitnesClubRepository): FitnesClubUseCase {

    //Ищет клиента по его id
    override fun getClientById(id: Int): Client? = repository.getClients().find { it.id == id }

    //Ищет абонемент по его id
    override fun getTicketById(id: Int): Ticket? = repository.getTickets().find { it.idTicket == id }

    //Высчитывает общую стоимость всех купленных абонементов
    override fun getAllPriceOfSoldTicket(): Int = repository.getTickets().sumOf { it.price }

    //Ищет самого популярного тренера
    override fun getTheMostPopularTrainer(): String? {
        val countByElement = repository.getTrainer().filter { it.name != Status.TRAINER_STATUS.status }.groupingBy { it.name }.eachCount()
        val maximumElement = countByElement.maxBy { it.value }?.key
        return maximumElement
    }


    //  Выводит "статус" клиента
    override fun getClientStatus(id: Int): String? {
        var clientStatus = getClientById(id)?.status
        if(id == getClientById(id)?.id && id == getTicketById(id)?.idTicket && getTicketById(id)?.price!! >= 2000){
           clientStatus = Status.CLIENT_STATUS_VIP.status
        }
        return clientStatus
    }
}
