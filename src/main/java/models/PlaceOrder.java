package models;

import lombok.*;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "place_order")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PlaceOrder implements Serializable {
    @Id
    @Column(name ="matour")
    private int matour;

    @Id
    @Column(name = "madiadiem")
    private int madiadiem;

    @Id
    @Column(name = "thutu")
    private int thutu;

    @ManyToOne
    @JoinColumn(name = "madiadiem", nullable = false, insertable = false, updatable = false)
    private Place place;

    @ManyToOne
    @JoinColumn(name = "matour", nullable = false, insertable = false, updatable = false)
    private Tour tour;

    public PlaceOrder(int matour, int madiadiem, int thutu) {
        this.matour = matour;
        this.madiadiem = madiadiem;
        this.thutu = thutu;
    }
}
