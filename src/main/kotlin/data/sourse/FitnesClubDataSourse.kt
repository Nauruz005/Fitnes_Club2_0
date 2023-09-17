package data.sourse

import model.Client
import model.Ticket
import model.Trainer

interface FitnesClubDataSourse {
    fun getClients(): List<Client>
    fun getTrainer(): List<Trainer>
    fun getTickets(): List<Ticket>
}