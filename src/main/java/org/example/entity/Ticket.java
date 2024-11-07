package org.example.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;
    @Column(name = "created_at")
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanet;
    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanetId;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", createdAt=" + createdAt +
                ", clientId=" + client.getId() +
                ", fromPlanetId=" + fromPlanet.getId() +
                ", toPlanetId=" + toPlanetId.getId() +
                '}';
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public void setToPlanetId(Planet toPlanetId) {
        this.toPlanetId = toPlanetId;
    }
    public int getTicketId() {
        return ticketId;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public Client getClient() {
        return client;
    }

    public Planet getFromPlanet() {
        return fromPlanet;
    }

    public Planet getToPlanetId() {
        return toPlanetId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId &&
                Objects.equals(createdAt, ticket.createdAt) &&
                Objects.equals(client, ticket.client) &&
                Objects.equals(fromPlanet, ticket.fromPlanet) &&
                Objects.equals(toPlanetId, ticket.toPlanetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, createdAt, client, fromPlanet, toPlanetId);
    }
}
