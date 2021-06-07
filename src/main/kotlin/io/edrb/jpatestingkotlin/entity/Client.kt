package io.edrb.jpatestingkotlin.entity

import javax.persistence.*

@Table(name = "client")
@Entity
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name")
    val name: String,
) {

    @OneToMany(mappedBy = "client")
    lateinit var devices: MutableSet<Device>
}