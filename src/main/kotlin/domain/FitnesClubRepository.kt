package domain

import model.Client
import model.Ticket
import model.Trainer

interface FitnesClubRepository {
    fun getClients(): List<Client>
    fun getTrainer(): List<Trainer>
    fun getTickets(): List<Ticket>
}