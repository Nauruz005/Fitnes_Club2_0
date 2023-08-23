package domain

import model.Client
import model.Ticket
import model.Trainer

interface FitnesClubUseCase {
    fun getClientId(id: Int): Client?
    fun getTicketId(id: Int): Ticket?
    fun getAllPriceOfSoldTicket(): Int
    fun getTheMostPopularTrainer(): String?
    fun getClientStatus(id: Int): String?
}