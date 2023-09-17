package domain

import model.Client
import model.Ticket
import model.Trainer

interface FitnesClubUseCase {
    fun getClientById(id: Int): Client?
    fun getTicketById(id: Int): Ticket?
    fun getAllPriceOfSoldTicket(): Int
    fun getTheMostPopularTrainer(): String?
    fun getClientStatus(id: Int): String?
}